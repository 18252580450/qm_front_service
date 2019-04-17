package com.asiainfo.qm.execution.service.impl;

import com.asiainfo.qm.execution.dao.VoicePoolMapper;
import com.asiainfo.qm.execution.domain.QmVoiceRecord;
import com.asiainfo.qm.execution.domain.VoicePool;
import com.asiainfo.qm.execution.service.QmVoiceService;
import com.asiainfo.qm.execution.vo.QmVoiceResponse;
import com.asiainfo.qm.manage.util.Constants;
import com.asiainfo.qm.manage.util.DateUtil;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.task.dao.QmVoiceMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2019-03-20 20:05
 * @ Description：${description}
 */

@Service
public class QmVoiceServiceImpl implements QmVoiceService {

    private static Logger logger = LoggerFactory.getLogger(QmVoiceServiceImpl.class);
    @Autowired
    private QmVoiceMapper qmVoiceMapper;
    @Autowired
    private VoicePoolMapper voicePoolMapper;

    @Override
    public QmVoiceResponse queryVoiceRecord(Map params, int start, int limit) throws Exception {
        QmVoiceResponse qmVoiceResponse = null;
        try {
            QmVoiceRecord qmVoiceRecord = new QmVoiceRecord();
            if (null != params.get("touchId") && !"".equals(params.get("touchId"))) {
                qmVoiceRecord.setTouchId("%" + params.get("touchId").toString() + "%");
            }
            if (null != params.get("staffNumber") && !"".equals(params.get("staffNumber"))) {
                qmVoiceRecord.setStaffNumber("%" + (String) params.get("staffNumber") + "%");
            }
            if (null != params.get("staffId") && !"".equals(params.get("staffId"))) {
                qmVoiceRecord.setStaffId((String) params.get("staffId"));
            }
            if (null != params.get("customerNumber") && !"".equals(params.get("customerNumber"))) {
                qmVoiceRecord.setCustomerNumber("%" + params.get("customerNumber") + "%");
            }
            if (null != params.get("beginTime") && !"".equals(params.get("beginTime")) && null != params.get("endTime") && !"".equals(params.get("endTime"))) {
                qmVoiceRecord.setTouchBeginTime((String) params.get("beginTime"));
                qmVoiceRecord.setTouchEndTime((String) params.get("endTime"));
            }

            if (0 != limit) {
                PageHelper.offsetPage(start, limit);
                List<QmVoiceRecord> list = qmVoiceMapper.queryBeyondPlanVoice(qmVoiceRecord);
                Page<QmVoiceRecord> pagelist = (Page) list;
                qmVoiceResponse = new QmVoiceResponse(pagelist);
            } else {
                qmVoiceResponse = new QmVoiceResponse();
                List<QmVoiceRecord> list = qmVoiceMapper.queryBeyondPlanVoice(qmVoiceRecord);
                qmVoiceResponse.setData(list);
            }

            if (null != qmVoiceResponse.getData() && qmVoiceResponse.getData().size() > 0) {
                qmVoiceResponse.setRspcode(WebUtil.SUCCESS);
                qmVoiceResponse.setRspdesc("查询成功");
            } else {
                qmVoiceResponse.setRspcode(WebUtil.FAIL);
                qmVoiceResponse.setRspdesc("无数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("语音查询异常", e);
            qmVoiceResponse.setRspcode(WebUtil.EXCEPTION);
            qmVoiceResponse.setRspdesc("语音查询异常");
        }
        return qmVoiceResponse;
    }

    @Override
    public QmVoiceResponse voiceAllocate(Map<String, Object> reqMap) throws Exception {
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> voiceList = (ArrayList<Map<String, Object>>) reqMap.get("voiceList");
        String templateId = reqMap.get("templateId").toString();
        String checkStaffId = reqMap.get("checkStaffId").toString();
        String checkStaffName = reqMap.get("checkStaffName").toString();
        QmVoiceResponse qmVoiceResponse = new QmVoiceResponse();
        try {
            for (Map<String, Object> voice : voiceList
            ) {
                Boolean flag = insertWorkFormPool(templateId, checkStaffId, checkStaffName, voice);
                if (!flag) {
                    qmVoiceResponse.setRspcode(WebUtil.FAIL);
                    qmVoiceResponse.setRspdesc("分配失败");
                    return qmVoiceResponse;
                }
            }
            qmVoiceResponse.setRspcode(WebUtil.SUCCESS);
            qmVoiceResponse.setRspdesc("分配成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("语音质检分配异常", e);
            qmVoiceResponse.setRspcode(WebUtil.EXCEPTION);
            qmVoiceResponse.setRspdesc("语音质检分配异常");
        }
        return qmVoiceResponse;
    }

    private Boolean insertWorkFormPool(String templateId, String checkStaffId, String checkStaffName, Map<String, Object> voice) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            VoicePool voicePool = new VoicePool();
            if (null != voice.get("tenantId") && !"".equals(voice.get("tenantId"))) {
                voicePool.setTenantId(voice.get("tenantId").toString());
            }
            if (null != voice.get("provinceId") && !"".equals(voice.get("provinceId"))) {
                voicePool.setProvinceId(voice.get("provinceId").toString());
            }
            if (null != voice.get("staffId") && !"".equals(voice.get("staffId"))) {
                voicePool.setCheckedStaffId(voice.get("staffId").toString());
            }
            if (null != voice.get("staffName") && !"".equals(voice.get("staffName"))) {
                voicePool.setCheckedStaffName(voice.get("staffName").toString());
            }
            if (null != voice.get("departId") && !"".equals(voice.get("departId"))) {
                voicePool.setDepartId(voice.get("departId").toString());
            }
            if (null != voice.get("departName") && !"".equals(voice.get("departName"))) {
                voicePool.setDepartName(voice.get("departName").toString());
            }
            if (null != voice.get("beginTime") && !"".equals(voice.get("beginTime"))) {
                Date beginTime = new Date(Long.parseLong(voice.get("beginTime").toString()));
                voicePool.setBeginTime(beginTime);
            }
            if (null != voice.get("endTime") && !"".equals(voice.get("endTime"))) {
                Date endTime = new Date(Long.parseLong(voice.get("endTime").toString()));
                voicePool.setEndTime(endTime);
            }
            if (null != voice.get("touchId") && !"".equals(voice.get("touchId"))) {
                voicePool.setTouchId(voice.get("touchId").toString());
            }
            if (null != voice.get("callType") && !"".equals(voice.get("callType"))) {
                voicePool.setCallType(voice.get("callType").toString());
            }
            if (null != voice.get("ivrDuration") && !"".equals(voice.get("ivrDuration"))) {
                voicePool.setIvrDuration(Integer.parseInt(voice.get("ivrDuration").toString()));
            }
            if (null != voice.get("acwDuration") && !"".equals(voice.get("acwDuration"))) {
                voicePool.setAcwDuration(Integer.parseInt(voice.get("acwDuration").toString()));
            }
            if (null != voice.get("alertDuration") && !"".equals(voice.get("alertDuration"))) {
                voicePool.setAlertDuration(Integer.parseInt(voice.get("alertDuration").toString()));
            }
            if (null != voice.get("queueDuration") && !"".equals(voice.get("queueDuration"))) {
                voicePool.setQueueDuration(Integer.parseInt(voice.get("queueDuration").toString()));
            }
            if (null != voice.get("talkDuration") && !"".equals(voice.get("talkDuration"))) {
                voicePool.setTalkDuration(Integer.parseInt(voice.get("talkDuration").toString()));
            }
            if (null != voice.get("endType") && !"".equals(voice.get("endType"))) {
                voicePool.setEndType(voice.get("endType").toString());
            }
            if (null != voice.get("staffNumber") && !"".equals(voice.get("staffNumber"))) {
                voicePool.setStaffNumber(voice.get("staffNumber").toString());
            }
            if (null != voice.get("customerNumber") && !"".equals(voice.get("customerNumber"))) {
                voicePool.setCustomerNumber(voice.get("customerNumber").toString());
            }
            if (null != voice.get("recordPath") && !"".equals(voice.get("recordPath"))) {
                voicePool.setRecordPath(voice.get("recordPath").toString());
            }
            if (null != voice.get("satisfyExtent") && !"".equals(voice.get("satisfyExtent"))) {
                voicePool.setSatisfyExtent(voice.get("satisfyExtent").toString());
            }
            if (null != voice.get("disconReason") && !"".equals(voice.get("disconReason"))) {
                voicePool.setDisconReason(voice.get("disconReason").toString());
            }
            if (null != voice.get("callReason") && !"".equals(voice.get("callReason"))) {
                voicePool.setCallReason(voice.get("callReason").toString());
            }
            if (null != voice.get("notOneSlt") && !"".equals(voice.get("notOneSlt"))) {
                voicePool.setNotOneSlt(voice.get("notOneSlt").toString());
            }
            if (null != voice.get("businessType") && !"".equals(voice.get("businessType"))) {
                voicePool.setBusinessType(voice.get("businessType").toString());
            }
            voicePool.setIsOperate(Constants.QM_DISTRIBUTE_STATUS.TRUE);                          //分派状态
            voicePool.setOperateTime(DateUtil.getCurrontTime());                                  //分派时间
            voicePool.setCheckedTime(DateUtil.getCurrontTime());                                  //抽取时间
            voicePool.setPoolStatus(Integer.parseInt(Constants.QM_CHECK_STATUS.CHECKING));        //质检状态标识
            voicePool.setCheckStaffId(checkStaffId);                                              //质检员工号
            voicePool.setCheckStaffName(checkStaffName);                                          //质检员姓名
            voicePool.setTemplateId(templateId);                                                  //模版id
            voicePool.setPlanId("");                                                              //计划外质检不绑定planId

            int result = voicePoolMapper.insertSelective(voicePool);
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("语音质检分配异常", e);
        }
        return false;
    }
}
