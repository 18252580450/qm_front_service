package com.asiainfo.qm.task.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.manage.common.restClient.HttpClient;
import com.asiainfo.qm.manage.util.DateUtil;
import com.asiainfo.qm.manage.util.DateUtils;
import com.asiainfo.qm.manage.util.FileUtils;
import com.asiainfo.qm.manage.util.HttpConstants;
import com.asiainfo.qm.task.dao.QmVoiceMapper;
import com.asiainfo.qm.task.domain.QmVoice;
import com.asiainfo.qm.task.domain.QmVoiceExample;
import com.asiainfo.qm.task.service.IQmTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created by shiying on 2018/12/21.
 */
@Service
public class QmTaskServiceImpl implements IQmTaskService{

    private static Logger logger = LoggerFactory.getLogger(QmTaskServiceImpl.class);
    @Autowired
    private HttpClient httpClient;

    @Autowired
    private QmVoiceMapper qmVoiceMapper;

    @Override
    public boolean doSynchroVoices(int pageNum){
        try {
            //调明细数据查询接口，查询录音数据，获取数据和总页数，循环调用
            JSONObject jsonObject = querySessionDetail(String.valueOf(pageNum));
            logger.info("语音数据:", jsonObject.toJSONString());
            String code = jsonObject.getString("code");
            if(code.equals(HttpConstants.HttpParams.CODE_SUCCESS)){
                Integer totalPages = jsonObject.getInteger("totalPages");
                List<Map<String,Object>> voices = (List<Map<String,Object>>)jsonObject.get("result");
                if(voices.size() > 0){
                    //保存入库
                    saveVoices(voices);
                    if(pageNum < totalPages){
                        pageNum++;
                        doSynchroVoices(pageNum);
                    }
                }
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("语音数据同步异常",e);
            return false;
        }
    }

    @Override
    public boolean downloadRecordFiles(){
        try {
            //1.查询语音数据
            List<QmVoice> voices = queryVoices();
            //2.调用接口查询录音文件地址
            if(voices.size() > 0){
                for(int i = 0;i<voices.size();i++){
                    QmVoice voice = voices.get(i);
                    String url = HttpConstants.HttpParams.URI + HttpConstants.HttpParams.RECORD_DETAIL_QUERY;
                    Map<String,String> params = new HashMap();
                    Calendar calendar = Calendar.getInstance();
                    Date beforeDay = DateUtil.currentBeforeDay();
//                calendar.setTime(DateUtil.string2Date("2019-01-27 00:00:00"));
                    logger.info("日期："+DateUtil.date2String(beforeDay,"YYYY-MM-dd"));
                    calendar.setTime(DateUtil.string2Date(DateUtil.date2String(beforeDay,"YYYY-MM-dd") + " 00:00:00"));
                    Long startTime = calendar.getTimeInMillis();
//                calendar.setTime(DateUtil.string2Date("2019-01-27 23:59:59"));
                    calendar.setTime(DateUtil.string2Date(DateUtil.date2String(beforeDay,"YYYY-MM-dd") + " 23:59:59"));
                    Long endTime = calendar.getTimeInMillis();
                    params.put("startTime",startTime + "");
                    params.put("endTime",endTime + "");
                    params.put("agentIds", "");
                    params.put("entId",HttpConstants.HttpParams.ENT_ID);
                    String tel = voice.getCustomerNumber().replace("TEL:","");
                    params.put("remoteUrl", tel);
                    params.put("sessionIds", voice.getTouchId());
                    params.put("pageNum","1");
                    logger.info("语音数据入参:", params.toString());
                    String ret = httpClient.sendGet(url, params);
                    JSONObject retJson = JSONObject.parseObject(ret);
                    //3.下载文件
                    String code = retJson.getString("code");
                    if(code.equals(HttpConstants.HttpParams.CODE_SUCCESS)){
                        List<Map<String,Object>> result = (List<Map<String,Object>>)retJson.get("result");
                        if(result.size() > 0) {
                            String path = HttpConstants.HttpParams.REMOTE_PATH + String.valueOf(result.get(0).get("record_name"));
                            String newPath = FileUtils.downLoadFromUrl(path);
                            //4.更新数据库
                            voice.setRecordPath(newPath);
                            updateVoice(voice);
                        }
                    }
                }
            }
            return true;
        }catch (Exception e){
            logger.error("录音文件下载异常",e);
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean queryScore() throws Exception {
        try {
            //1.查询语音数据
            List<QmVoice> voices = queryVoices();
            //2.调用接口查询满意度数据
            if(voices.size() > 0){
                for(int i = 1000;i<voices.size();i++){
                    QmVoice voice = voices.get(i);
                    String url = HttpConstants.HttpParams.URI + HttpConstants.HttpParams.TSRVA_DETAIL_QUERY;
                    Map<String,String> params = new HashMap();
                    Calendar calendar = Calendar.getInstance();
                    Date beforeDay = DateUtil.currentBeforeDay();
//                calendar.setTime(DateUtil.string2Date("2019-01-27 00:00:00"));
                    calendar.setTime(DateUtil.string2Date(DateUtil.date2String(beforeDay,"YYYY-MM-dd") + " 00:00:00"));
                    Long startTime = calendar.getTimeInMillis();
//                calendar.setTime(DateUtil.string2Date("2019-01-27 23:59:59"));
                    calendar.setTime(DateUtil.string2Date(DateUtil.date2String(beforeDay,"YYYY-MM-dd") + " 23:59:59"));
                    Long endTime = calendar.getTimeInMillis();
                    params.put("startTime",startTime + "");
                    params.put("endTime",endTime + "");
                    params.put("agentIds", "");
                    params.put("entId",HttpConstants.HttpParams.ENT_ID);
                    String tel = voice.getCustomerNumber().replace("TEL:","");
                    params.put("remoteUrl", tel);
                    params.put("sessionIds", voice.getTouchId());
                    params.put("pageNum","1");
                    String ret = httpClient.sendGet(url, params);
                    if(null != ret) {
                        JSONObject retJson = JSONObject.parseObject(ret);
                        List<Map> result = (List<Map>)retJson.get("result");
                        if(result.size() > 0 && null != result.get(0).get("score")){
                            String score = String.valueOf(result.get(0).get("score"));
                            voice.setSatisfyExtent(score);
                            //3.更新数据库
                            updateVoice(voice);
                        }
                    }
                }
            }
            return true;
        }catch (Exception e){
            logger.error("更新满意度数据异常",e);
            e.printStackTrace();
            return false;
        }

    }

    private List<QmVoice> queryVoices() throws Exception{
        QmVoiceExample example = new QmVoiceExample();
        QmVoiceExample.Criteria criteria = example.createCriteria();
        Date beforeDay = DateUtil.currentBeforeDay();
        Timestamp startTime = DateUtils.paraseSqlTimestamp(DateUtil.date2String(beforeDay,"YYYY-MM-dd")
                + " 00:00:00", DateUtils.DATE_FORMAT_A_YYYYMMDDHHMMSS);
        Timestamp endTime = DateUtils.paraseSqlTimestamp(DateUtil.date2String(beforeDay,"YYYY-MM-dd")
                + " 23:59:59", DateUtils.DATE_FORMAT_A_YYYYMMDDHHMMSS);
        criteria.andBeginTimeBetween(startTime,endTime);
        List<QmVoice> voices = qmVoiceMapper.selectByExample(example);
        return voices;
    }

    public void updateVoice(QmVoice qmVoice) throws Exception{
        qmVoiceMapper.updateByPrimaryKeySelective(qmVoice);
    }

    //调用查询录音数据接口
    private JSONObject querySessionDetail(String pageNum)throws Exception{
        String url = HttpConstants.HttpParams.URI + HttpConstants.HttpParams.SESSION_DETAIL_QUERY;
        Map<String,String> params = new HashMap();
        Calendar calendar = Calendar.getInstance();
        Date beforeDay = DateUtil.currentBeforeDay();
//        calendar.setTime(DateUtil.string2Date("2019-01-27 00:00:00"));
        logger.info("日期："+DateUtil.date2String(beforeDay,"YYYY-MM-dd"));
        calendar.setTime(DateUtil.string2Date(DateUtil.date2String(beforeDay,"YYYY-MM-dd") + " 00:00:00"));
        Long startTime = calendar.getTimeInMillis();
//        calendar.setTime(DateUtil.string2Date("2019-01-27 23:59:59"));
        calendar.setTime(DateUtil.string2Date(DateUtil.date2String(beforeDay,"YYYY-MM-dd") + " 23:59:59"));
        Long endTime = calendar.getTimeInMillis();
        params.put("startTime",startTime + "");
        params.put("endTime",endTime + "");
        params.put("entId",HttpConstants.HttpParams.ENT_ID);
        params.put("pageNum",pageNum);
        String ret = httpClient.sendGet(url, params);
        JSONObject result = JSONObject.parseObject(ret);
        return result;
    }

    //保存数据库
    private void saveVoices(List<Map<String, Object>> voices){
        for(int i = 0;i<voices.size();i++){
            QmVoice qmVoice = new QmVoice();
            Map<String, Object> voice = voices.get(i);
            if(null != voice.get("start_time")){//开始时间
                Long start_time = Long.valueOf((String)voice.get("start_time"));
                qmVoice.setBeginTime(new Date(start_time));
            }
            if(null != voice.get("end_time")){//结束时间
                Long end_time = Long.valueOf((String)voice.get("end_time"));
                qmVoice.setEndTime(new Date(end_time));
            }
            if(null != voice.get("session_id")){//接触ID
                String session_id = (String)voice.get("session_id");
                qmVoice.setTouchId(session_id);
            }
            if(null != voice.get("agent_id")){//坐席工号
                String agent_id = (String)voice.get("agent_id");
                qmVoice.setStaffId(agent_id);
            }
            if(null != voice.get("agent_name")){//坐席名称
                String agent_name = (String)voice.get("agent_name");
                qmVoice.setStaffName(agent_name);
            }
            if(null != voice.get("skill_id")){//技能组ID
                String skill_id = (String)voice.get("skill_id");
                qmVoice.setDepartId(skill_id);
            }
            if(null != voice.get("skill_name")){//技能组名称
                String skill_name = (String)voice.get("skill_name");
                qmVoice.setDepartName(skill_name);
            }
            if(null != voice.get("call_type")){//呼叫类型
                String call_type = String.valueOf(voice.get("call_type"));
                qmVoice.setCallType(call_type);
            }
            if(null != voice.get("local_url")){//坐席号码
                String local_url = String.valueOf(voice.get("local_url"));
                qmVoice.setStaffNumber(local_url);
            }
            if(null != voice.get("remote_url")){//客户号码
                String remote_url = String.valueOf(voice.get("remote_url"));
                qmVoice.setCustomerNumber(remote_url);
            }
            if(null != voice.get("talk_duration")){//通话时长
                Integer talk_duration = Integer.parseInt(String.valueOf(voice.get("talk_duration")));
                qmVoice.setTalkDuration(talk_duration);
            }
            if(null != voice.get("end_type")){//结束类型
                String end_type = String.valueOf(voice.get("end_type"));
                qmVoice.setEndType(end_type);
            }
            qmVoiceMapper.insertSelective(qmVoice);
        }
    }

}
