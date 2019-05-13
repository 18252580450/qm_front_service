package com.asiainfo.qm.task.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.manage.common.restClient.HttpClient;
import com.asiainfo.qm.manage.common.restClient.RestClient;
import com.asiainfo.qm.manage.util.*;
import com.asiainfo.qm.task.dao.QmVoiceMapper;
import com.asiainfo.qm.task.dao.QmWorkformMapper;
import com.asiainfo.qm.task.domain.QmVoice;
import com.asiainfo.qm.task.domain.QmVoiceExample;
import com.asiainfo.qm.task.domain.QmWorkform;
import com.asiainfo.qm.task.service.IQmTaskService;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by shiying on 2018/12/21.
 */
@Service
public class QmTaskServiceImpl implements IQmTaskService {

    private static Logger logger = LoggerFactory.getLogger(QmTaskServiceImpl.class);
    @Autowired
    private HttpClient httpClient;

    @Autowired
    private FtpUtil ftpUtil;

    @Autowired
    private RestClient restClient;

    @Autowired
    private QmVoiceMapper qmVoiceMapper;

    @Autowired
    private QmWorkformMapper qmWorkformMapper;

    @Override
    public boolean querySynchroVoices(String startTime, String endTime, int pageNum) {
        try {
            //调明细数据查询接口，查询录音数据，获取数据和总页数，循环调用
            JSONObject jsonObject = querySessionDetail(startTime, endTime, String.valueOf(pageNum));
            String code = jsonObject.getString("code");
            if (code.equals(HttpConstants.HttpParams.CODE_SUCCESS)) {
                Integer totalPages = jsonObject.getInteger("totalPages");
                List<Map<String, Object>> voices = (List<Map<String, Object>>) jsonObject.get("result");
                if (voices.size() > 0) {
                    //保存入库
                    saveVoices(voices);
                    if (pageNum < totalPages) {
                        pageNum++;
                        querySynchroVoices(startTime, endTime, pageNum);
                    }
                }
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("语音数据同步异常", e);
            return false;
        }
    }

    @Override
    public boolean downloadRecordFiles(String startDate, String endDate) {
        try {
            //1.查询语音数据
            List<QmVoice> voices = queryVoices();
            //2.调用接口查询录音文件地址
            if (voices.size() > 0) {
                for (int i = 0; i < voices.size(); i++) {
                    QmVoice voice = voices.get(i);
                    String url = HttpConstants.HttpParams.URI + HttpConstants.HttpParams.RECORD_DETAIL_QUERY;
                    Map<String, String> params = new HashMap();
                    Calendar calendar = Calendar.getInstance();
                    Date beforeDay = DateUtil.currentBeforeDay();
                    if (null != startDate && !"".equals(startDate)) {
                        calendar.setTime(DateUtil.string2Date(startDate));
                    } else {
                        calendar.setTime(DateUtil.string2Date(DateUtil.date2String(beforeDay, "YYYY-MM-dd") + " 00:00:00"));
                    }
                    Long startTime = calendar.getTimeInMillis();
                    params.put("startTime", startTime + "");
                    if (null != endDate && !"".equals(endDate)) {
                        calendar.setTime(DateUtil.string2Date(endDate));
                    } else {
                        calendar.setTime(DateUtil.string2Date(DateUtil.date2String(beforeDay, "YYYY-MM-dd") + " 23:59:59"));
                    }
                    Long endTime = calendar.getTimeInMillis();
                    params.put("startTime", startTime + "");
                    params.put("endTime", endTime + "");
                    params.put("agentIds", "");
                    params.put("entId", HttpConstants.HttpParams.ENT_ID);
                    String tel = voice.getCustomerNumber().replace("TEL:", "");
                    params.put("remoteUrl", tel);
                    params.put("sessionIds", voice.getTouchId());
                    params.put("pageNum", "1");
                    logger.info("语音数据入参:", params.toString());
                    String ret = httpClient.sendGet(url, params);
                    JSONObject retJson = JSONObject.parseObject(ret);
                    //3.下载文件
                    String code = retJson.getString("code");
                    if (code.equals(HttpConstants.HttpParams.CODE_SUCCESS)) {
                        List<Map<String, Object>> result = (List<Map<String, Object>>) retJson.get("result");
                        if (result.size() > 0) {
                            //录音下载地址
                            String path = HttpConstants.HttpParams.REMOTE_PATH + String.valueOf(result.get(0).get("record_name"));
                            String fileName = path.substring(path.lastIndexOf("/"));
                            FTPClient ftpClient = new FTPClient();
                            URL urlNew = new URL(path);
                            HttpURLConnection conn = (HttpURLConnection) urlNew.openConnection();
                            //设置超时间为3秒
                            conn.setConnectTimeout(3 * 1000);
                            //防止屏蔽程序抓取而返回403错误
                            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
                            //得到输入流
                            InputStream inputStream = conn.getInputStream();
                            boolean uploadFlag = ftpUtil.uploadFile(ftpClient, HttpConstants.HttpParams.FTP_RECORD_PATH, fileName, inputStream);//上传
                            if (uploadFlag) {
                                String recordPath = HttpConstants.HttpParams.FTP_REMOTE_PATH + fileName;
                                voice.setRecordPath(recordPath);
                            }
//                            String newPath = FileUtils.downLoadFromUrl(path);
//                            voice.setRecordPath(newPath);
                            //4.更新数据库
                            updateVoice(voice);
                        }
                    }
                }
            }
            return true;
        } catch (Exception e) {
            logger.error("录音文件下载异常", e);
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean queryScore(String startDate, String endDate) throws Exception {
        try {
            //1.查询语音数据
            List<QmVoice> voices = queryVoices();
            //2.调用接口查询满意度数据
            if (voices.size() > 0) {
                for (int i = 1000; i < voices.size(); i++) {
                    QmVoice voice = voices.get(i);
                    String url = HttpConstants.HttpParams.URI + HttpConstants.HttpParams.TSRVA_DETAIL_QUERY;
                    Map<String, String> params = new HashMap();
                    Calendar calendar = Calendar.getInstance();
                    Date beforeDay = DateUtil.currentBeforeDay();
                    if (null != startDate && !"".equals(startDate)) {
                        calendar.setTime(DateUtil.string2Date(startDate));
                    } else {
                        calendar.setTime(DateUtil.string2Date(DateUtil.date2String(beforeDay, "YYYY-MM-dd") + " 00:00:00"));
                    }
                    Long startTime = calendar.getTimeInMillis();
                    params.put("startTime", startTime + "");
                    if (null != endDate && !"".equals(endDate)) {
                        calendar.setTime(DateUtil.string2Date(endDate));
                    } else {
                        calendar.setTime(DateUtil.string2Date(DateUtil.date2String(beforeDay, "YYYY-MM-dd") + " 23:59:59"));
                    }
                    Long endTime = calendar.getTimeInMillis();
                    params.put("startTime", startTime + "");
                    params.put("endTime", endTime + "");
                    params.put("agentIds", "");
                    params.put("entId", HttpConstants.HttpParams.ENT_ID);
                    String tel = voice.getCustomerNumber().replace("TEL:", "");
                    params.put("remoteUrl", tel);
                    params.put("sessionIds", voice.getTouchId());
                    params.put("pageNum", "1");
                    String ret = httpClient.sendGet(url, params);
                    if (null != ret) {
                        JSONObject retJson = JSONObject.parseObject(ret);
                        List<Map> result = (List<Map>) retJson.get("result");
                        if (result.size() > 0 && null != result.get(0).get("score")) {
                            String score = String.valueOf(result.get(0).get("score"));
                            voice.setSatisfyExtent(score);
                            //3.更新数据库
                            updateVoice(voice);
                        }
                    }
                }
            }
            return true;
        } catch (Exception e) {
            logger.error("更新满意度数据异常", e);
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean querySynchroWorkforms(String startTime, String endTime) {
        try {
            String url = HttpConstants.HttpParams.WRKFM_URL + HttpConstants.HttpParams.WRKFM_QUERY;
            Map<String, String> params = new HashMap();
            Date beforeDay = DateUtil.currentBeforeDay();
            if (null != startTime && !"".equals(startTime)) {
                params.put("arcStartTime", startTime);
            } else {
                params.put("arcStartTime", DateUtil.date2String(beforeDay, "YYYY-MM-dd") + " 00:00:00");
            }
            if (null != endTime && !"".equals(endTime)) {
                params.put("arcEndTime", endTime);
            } else {
                params.put("arcEndTime", DateUtil.date2String(beforeDay, "YYYY-MM-dd") + " 23:59:59");
            }
            params.put("provCode", HttpConstants.HttpParams.PROV_CODE);
            JSONObject rsp = (JSONObject) restClient.callRemoteServicetWithHeader(url, HttpMethod.POST, params, JSONObject.class, null, "1");
            if (rsp.getString("status").equals(HttpConstants.HttpParams.INT_SUCCESS_CODE)) {
                JSONObject rspRet = rsp.getJSONObject("rsp");
                if (rspRet.getString("rspCode").equals(HttpConstants.HttpParams.SUCCESS_CODE)) {
                    List<Map<String, Object>> datas = (List<Map<String, Object>>) rspRet.get("datas");
                    if (datas.size() > 0) {
                        for (int i = 0; i < datas.size(); i++) {
                            JSONObject data = (JSONObject) datas.get(i);
                            saveWorkforms(data);
                        }

                        return true;
                    } else {
                        logger.error("【工单数据同步】：无数据");
                    }
                } else {
                    logger.error("【工单数据同步】：" + rspRet.getString("rspDesc"));
                }
            } else {
                logger.error("【工单数据同步】：" + rsp.getString("msg"));
            }

        } catch (Exception e) {
            logger.error("【工单数据同步】：" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public void saveWorkforms(JSONObject data) throws Exception {
        QmWorkform workform = new QmWorkform();
        workform.setWrkfmId((Long) data.get("wrkfmId"));//工单ID
        if (null != data.get("wrkfmShowSwftno")) {//工单展示编码
            workform.setWrkfmShowSwftno((String) data.get("wrkfmShowSwftno"));
        }
        if (null != data.get("srvReqstId")) {//服务请求ID
            workform.setSrvReqstId((Long) data.get("srvReqstId"));
        }
        if (null != data.get("srvReqstTypeId")) {//服务请求类型ID
            workform.setSrvReqstTypeId((String) data.get("srvReqstTypeId"));
        }
        if (null != data.get("seqprcTmpltId")) {//流程模板ID
            workform.setSeqprcTmpltId((String) data.get("seqprcTmpltId"));
        }
        if (null != data.get("wrkfmTypeCd")) {//工单类型代码，普通，补救
            workform.setWrkfmTypeCd((String) data.get("wrkfmTypeCd"));
        }
        if (null != data.get("provCode")) {//省份编码
            workform.setProvCode((String) data.get("provCode"));
        }
        if (null != data.get("crtTime")) {//创建时间
            Long crtTime = (Long) data.get("crtTime");
            workform.setCrtTime(new Date(crtTime));
        }
        if (null != data.get("modfTime")) {//修改时间
            Long modfTime = (Long) data.get("modfTime");
            workform.setModfTime(new Date(modfTime));
        }
        if (null != data.get("arcTime")) {//归档时间
            Long arcTime = (Long) data.get("arcTime");
            workform.setArcTime(new Date(arcTime));
        }
        if (null != data.get("currWorkItemGroup")) {//当前任务拥有组，最多5个，可根据情况调整
            workform.setCurrWorkItemGroup((String) data.get("currWorkItemGroup"));
        }
        if (null != data.get("currWorkItemOwner")) {//当前任务拥有者，最多5个，可根据情况调整
            workform.setCurrWorkItemOwner((String) data.get("currWorkItemOwner"));
        }
        if (null != data.get("lastRouteLgIdSet")) {//最后路由日志ID集合，最多5个，可根据情况调整
            workform.setLastRouteLgIdSet((String) data.get("lastRouteLgIdSet"));
        }
        if (null != data.get("prstTskStsCd")) {//当前任务状态代码，等待处理，正在处理，处理结束，休眠中，最多5个，可根据情况调整
            workform.setPrstTskStsCd((String) data.get("prstTskStsCd"));
        }
        if (null != data.get("latestSegRemainTmlen")) {//最新环节剩余时长，最多5个，可根据情况调整
            workform.setLatestSegRemainTmlen((String) data.get("latestSegRemainTmlen"));
        }
        if (null != data.get("latestSegTlmt")) {//最新环节期限，最多5个，可根据情况调整
            workform.setLatestSegTlmt((String) data.get("latestSegTlmt"));
        }
        if (null != data.get("segTlmtStsCd")) {//环节时限状态代码，最多5个，可根据情况调整
            workform.setSegTlmtStsCd((String) data.get("segTlmtStsCd"));
        }
        if (null != data.get("concrrTskFlag")) {//并发任务标志，为了多派
            workform.setConcrrTskFlag(Byte.valueOf(data.get("concrrTskFlag").toString()));
        }
        if (null != data.get("dspsStaffOpList")) {//处理员工操作列表
            workform.setDspsStaffOpList((String) data.get("dspsStaffOpList"));
        }
        if (null != data.get("opTypeList")) {//操作类型列表
            workform.setOpTypeList((String) data.get("opTypeList"));
        }
        if (null != data.get("lastOpType")) {//最后操作类型
            workform.setLastOpType((String) data.get("lastOpType"));
        }
        if (null != data.get("dspsStaffList")) {//处理员工列表
            workform.setDspsStaffList((String) data.get("dspsStaffList"));
        }
        if (null != data.get("wrkfmPtcptWorkGrpList")) {//工单参与工作组列表
            workform.setWrkfmPtcptWorkGrpList((String) data.get("wrkfmPtcptWorkGrpList"));
        }
        if (null != data.get("dspsComplteStaffId")) {//工单责任人
            workform.setDspsComplteStaffId((String) data.get("dspsComplteStaffId"));
        }
        if (null != data.get("prstNodeTypeCd")) {//当前节点类型代码
            workform.setPrstNodeTypeCd((String) data.get("prstNodeTypeCd"));
        }
        if (null != data.get("wrkfmStsCd")) {//工单状态代码
            workform.setWrkfmStsCd((String) data.get("wrkfmStsCd"));
        }
        if (null != data.get("exprTime")) {//到期时间
            Long exprTime = (Long) data.get("exprTime");
            workform.setExprTime(new Date(exprTime));
        }
        if (null != data.get("tmlmtRuleId")) {//时限规则ID
            workform.setTmlmtRuleId((Long) data.get("tmlmtRuleId"));
        }
        if (null != data.get("tmoutTmlenCnt")) {//剩余时长
            workform.setTmoutTmlenCnt((Integer) data.get("tmoutTmlenCnt"));
        }
        if (null != data.get("tlmtStsCd")) {//整体时限状态代码
            workform.setTlmtStsCd((String) data.get("tlmtStsCd"));
        }
        if (null != data.get("dspsComplteWorkGrpId")) {//处理完成工作组ID
            workform.setDspsComplteWorkGrpId((String) data.get("dspsComplteWorkGrpId"));
        }
        if (null != data.get("validFlag")) {//有效标志
            workform.setValidFlag(Byte.valueOf(data.get("validFlag").toString()));
        }
        if (null != data.get("arcStaffId")) {//归档员工
            workform.setArcStaffId((String) data.get("arcStaffId"));
        }
        if (null != data.get("arcStaffWorkGrpId")) {//归档人所在部门
            workform.setArcStaffWorkGrpId((String) data.get("arcStaffWorkGrpId"));
        }
        if (null != data.get("arcStaffDeptId")) {//归档员工工作组ID
            workform.setArcStaffDeptId((String) data.get("arcStaffDeptId"));
        }
        if (null != data.get("arcOpinCntt")) {//归档意见内容
            workform.setArcOpinCntt((String) data.get("arcOpinCntt"));
        }
        if (null != data.get("aformFlag")) {//自动派单、分单标记
            workform.setAformFlag(Byte.valueOf(data.get("aformFlag").toString()));
        }
        if (null != data.get("aformTmsCnt")) {//派单次数
            workform.setAformTmsCnt(Byte.valueOf(data.get("aformTmsCnt").toString()));
        }
        if (null != data.get("haveRcdngCount")) {//录音记录数
            workform.setHaveRcdngCount(Short.valueOf(data.get("haveRcdngCount").toString()));
        }
        if (null != data.get("inactTmsCnt")) {//休眠次数
            workform.setInactTmsCnt(Byte.valueOf(data.get("inactTmsCnt").toString()));
        }
        if (null != data.get("inactTime")) {//休眠时间
            Long inactTime = (Long) data.get("inactTime");
            workform.setInactTime(new Date(inactTime));
        }
        if (null != data.get("actvtModeCd")) {//激活方式代码，手动，自动
            workform.setActvtModeCd((String) data.get("actvtModeCd"));
        }
        if (null != data.get("acptStaffId")) {//立单人
            workform.setAcptStaffId((String) data.get("acptStaffId"));
        }
        if (null != data.get("custNum")) {//客户号码
            workform.setCustNum((String) data.get("custNum"));
        }
        if (null != data.get("custName")) {//客户名称
            workform.setCustName((String) data.get("custName"));
        }
        if (null != data.get("custEmail")) {//客户账号
            workform.setCustEmail((String) data.get("custEmail"));
        }
        if (null != data.get("bizTitle")) {//工单标题
            workform.setBizTitle((String) data.get("bizTitle"));
        }
        if (null != data.get("bizCntt")) {//工单内容
            workform.setBizCntt((String) data.get("bizCntt"));
        }
        if (null != data.get("srvReqstTypeFullNm")) {//服务请求类型全称
            workform.setSrvReqstTypeFullNm((String) data.get("srvReqstTypeFullNm"));
        }
        if (null != data.get("actualHandleDuration")) {//实际处理时长
            workform.setActualHandleDuration((Integer) data.get("actualHandleDuration"));
        }
        if (null != data.get("handleDuration")) {//处理时长
            workform.setHandleDuration((Integer) data.get("handleDuration"));
        }
        if (null != data.get("urgeFlag")) {//催办标志
            workform.setUrgeFlag(Byte.valueOf(data.get("urgeFlag").toString()));
        }
        if (null != data.get("rmdrTmsCnt")) {//催单次数
            workform.setRmdrTmsCnt(Byte.valueOf(data.get("rmdrTmsCnt").toString()));
        }
        if (null != data.get("rmdrTime")) {//催单时间
            Long rmdrTime = (Long) data.get("rmdrTime");
            workform.setRmdrTime(new Date(rmdrTime));
        }
        if (null != data.get("rmdrStaffNum")) {//催单人
            workform.setRmdrStaffNum((String) data.get("rmdrStaffNum"));
        }
        if (null != data.get("revstRemedyFlag")) {//回访补救标志
            workform.setRevstRemedyFlag(Byte.valueOf(data.get("revstRemedyFlag").toString()));
        }
        if (null != data.get("trsprtSmsIsudFlag")) {//透明化短信下发标志
            workform.setTrsprtSmsIsudFlag(Byte.valueOf(data.get("trsprtSmsIsudFlag").toString()));
        }
        if (null != data.get("rmdrStsCd")) {//催单状态代码，已催办，未催办
            workform.setRmdrStsCd((String) data.get("rmdrStsCd"));
        }
        if (null != data.get("dplctCmplntsFlag")) {//重复投诉标志
            workform.setDplctCmplntsFlag(Byte.valueOf(data.get("dplctCmplntsFlag").toString()));
        }
        qmWorkformMapper.insertSelective(workform);


    }

    private List<QmVoice> queryVoices() throws Exception {
        QmVoiceExample example = new QmVoiceExample();
        QmVoiceExample.Criteria criteria = example.createCriteria();
        Date beforeDay = DateUtil.currentBeforeDay();
        Timestamp startTime = DateUtils.paraseSqlTimestamp(DateUtil.date2String(beforeDay, "YYYY-MM-dd")
                + " 00:00:00", DateUtils.DATE_FORMAT_A_YYYYMMDDHHMMSS);
        Timestamp endTime = DateUtils.paraseSqlTimestamp(DateUtil.date2String(beforeDay, "YYYY-MM-dd")
                + " 23:59:59", DateUtils.DATE_FORMAT_A_YYYYMMDDHHMMSS);
        criteria.andBeginTimeBetween(startTime, endTime);
        List<QmVoice> voices = qmVoiceMapper.selectByExample(example);
        return voices;
    }

    public void updateVoice(QmVoice qmVoice) throws Exception {
        qmVoiceMapper.updateByPrimaryKeySelective(qmVoice);
    }

    //调用查询录音数据接口
    private JSONObject querySessionDetail(String startDate, String endDate, String pageNum) throws Exception {
        String url = HttpConstants.HttpParams.URI + HttpConstants.HttpParams.SESSION_DETAIL_QUERY;
        Map<String, String> params = new HashMap();
        Calendar calendar = Calendar.getInstance();
        Date beforeDay = DateUtil.currentBeforeDay();
        if (null != startDate && !"".equals(startDate)) {
            calendar.setTime(DateUtil.string2Date(startDate));
        } else {
            calendar.setTime(DateUtil.string2Date(DateUtil.date2String(beforeDay, "YYYY-MM-dd") + " 00:00:00"));
        }
        Long startTime = calendar.getTimeInMillis();
        params.put("startTime", startTime + "");
        if (null != endDate && !"".equals(endDate)) {
            calendar.setTime(DateUtil.string2Date(endDate));
        } else {
            calendar.setTime(DateUtil.string2Date(DateUtil.date2String(beforeDay, "YYYY-MM-dd") + " 23:59:59"));
        }
        Long endTime = calendar.getTimeInMillis();
        params.put("endTime", endTime + "");
        params.put("entId", HttpConstants.HttpParams.ENT_ID);
        params.put("endType", "255,252,254,206,207,208,209");
        params.put("pageNum", pageNum);
        String ret = httpClient.sendGet(url, params);
        JSONObject result = JSONObject.parseObject(ret);
        return result;
    }

    //保存数据库
    public void saveVoices(List<Map<String, Object>> voices) {
        for (int i = 0; i < voices.size(); i++) {
            QmVoice qmVoice = new QmVoice();
            Map<String, Object> voice = voices.get(i);
            qmVoice.setTenantId(HttpConstants.HttpParams.TENANT_ID);
            if (null != voice.get("start_time")) {//开始时间
                Long start_time = Long.valueOf((String) voice.get("start_time"));
                qmVoice.setBeginTime(new Date(start_time));
            }
            if (null != voice.get("end_time")) {//结束时间
                Long end_time = Long.valueOf((String) voice.get("end_time"));
                qmVoice.setEndTime(new Date(end_time));
            }
            if (null != voice.get("session_id")) {//接触ID
                String session_id = (String) voice.get("session_id");
                qmVoice.setTouchId(session_id);
            }
            if (null != voice.get("agent_id")) {//坐席工号
                String agent_id = (String) voice.get("agent_id");
                qmVoice.setStaffId(agent_id);
            }
            if (null != voice.get("agent_name")) {//坐席名称
                String agent_name = (String) voice.get("agent_name");
                qmVoice.setStaffName(agent_name);
            }
            if (null != voice.get("skill_id")) {//技能组ID
                String skill_id = (String) voice.get("skill_id");
                qmVoice.setDepartId(skill_id);
            }
            if (null != voice.get("skill_name")) {//技能组名称
                String skill_name = (String) voice.get("skill_name");
                qmVoice.setDepartName(skill_name);
            }
            if (null != voice.get("call_type")) {//呼叫类型
                String call_type = String.valueOf(voice.get("call_type"));
                qmVoice.setCallType(call_type);
            }
            if (null != voice.get("local_url")) {//坐席号码
                String local_url = String.valueOf(voice.get("local_url"));
                qmVoice.setStaffNumber(local_url);
            }
            if (null != voice.get("remote_url")) {//客户号码
                String remote_url = String.valueOf(voice.get("remote_url"));
                qmVoice.setCustomerNumber(remote_url);
            }
            if (null != voice.get("talk_duration")) {//通话时长
                Integer talk_duration = Integer.parseInt(String.valueOf(voice.get("talk_duration")));
                qmVoice.setTalkDuration(talk_duration);
            }
            if (null != voice.get("end_type")) {//结束类型
                String end_type = String.valueOf(voice.get("end_type"));
                qmVoice.setEndType(end_type);
            }
            qmVoiceMapper.insertSelective(qmVoice);
        }
    }

}
