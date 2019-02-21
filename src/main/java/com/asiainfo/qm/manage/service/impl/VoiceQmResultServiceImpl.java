package com.asiainfo.qm.manage.service.impl;


import com.asiainfo.qm.execution.vo.VoiceCheckResultResponse;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.dao.VoiceCheckResultMapper;
import com.asiainfo.qm.manage.domain.VoiceCheckResult;
import com.asiainfo.qm.manage.domain.VoiceCheckResultExample;
import com.asiainfo.qm.manage.service.VoiceCheckResultService;
import com.asiainfo.qm.manage.util.WebUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：wangcheng.
 * @ Date       ：Created in 14:22 2018/12/16
 * @ Description：${description}
 */
@Service
public class VoiceQmResultServiceImpl implements VoiceCheckResultService {

    private static Logger logger = LoggerFactory.getLogger(VoiceQmResultServiceImpl.class);

    @Autowired
    private VoiceCheckResultMapper voiceCheckResultMapper;

    @Autowired
    private SequenceUtils sequenceUtils;

    @Override
    public VoiceCheckResultResponse selectByParams(Map params, int start, int limit) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        VoiceCheckResultResponse voiceCheckResultResponse = null;
        VoiceCheckResultExample voiceCheckResultExample = new VoiceCheckResultExample();
        try {
            VoiceCheckResultExample.Criteria criteria= voiceCheckResultExample.createCriteria();//在运行时动态生成查询语句
            if (null != params.get("touchId") && !"".equals(params.get("touchId"))) {
                criteria.andTouchIdEqualTo((String) params.get("touchId"));
            }
            if (null != params.get("planId") && !"".equals(params.get("planId"))) {
                criteria.andPlanIdEqualTo((String) params.get("planId"));
            }
            if (null != params.get("originInspectionId") && !"".equals(params.get("originInspectionId"))) {
                criteria.andOriginInspectionIdEqualTo((String) params.get("originInspectionId"));
            }
            if (null != params.get("lastResultFlag") && !"".equals(params.get("lastResultFlag"))) {
                criteria.andLastResultFlagEqualTo((String) params.get("lastResultFlag"));
            }
            if (null != params.get("checkStaffId") && !"".equals(params.get("checkStaffId"))) {
                criteria.andCheckStaffIdEqualTo((String) params.get("checkStaffId"));
            }
            if (null != params.get("checkedStaffId") && !"".equals(params.get("checkedStaffId"))) {
                criteria.andCheckedStaffIdEqualTo((String) params.get("checkedStaffId"));
            }
            if (null != params.get("inspectionId") && !"".equals(params.get("inspectionId"))) {
                criteria.andInspectionIdEqualTo((String) params.get("inspectionId"));
            }
            if (null != params.get("startTime") && !"".equals(params.get("startTime")) && null != params.get("endTime") && !"".equals(params.get("endTime"))) {
                criteria.andCheckEndTimeBetween(sdf.parse((String) params.get("startTime")), sdf.parse((String) params.get("endTime")));
            }
            if (null != params.get("resultStatus") && !"".equals(params.get("resultStatus"))) {
                criteria.andResultStatusEqualTo((String) params.get("resultStatus"));
            }

            if (0 != limit) {
                PageHelper.offsetPage(start, limit);
                List<VoiceCheckResult> list = voiceCheckResultMapper.selectByExample(voiceCheckResultExample);
                Page<VoiceCheckResult> pagelist = (Page)list;
                voiceCheckResultResponse = new VoiceCheckResultResponse(pagelist);
            } else {
                voiceCheckResultResponse = new VoiceCheckResultResponse();
                List<VoiceCheckResult> list = voiceCheckResultMapper.selectByExample(voiceCheckResultExample);
                voiceCheckResultResponse.setData(list);
            }

            if(null != voiceCheckResultResponse.getData() && voiceCheckResultResponse.getData().size() > 0){
                voiceCheckResultResponse.setRspcode(WebUtil.SUCCESS);
                voiceCheckResultResponse.setRspdesc("查询成功");
            }else {
                voiceCheckResultResponse.setRspcode(WebUtil.FAIL);
                voiceCheckResultResponse.setRspdesc("无数据");
            }
        }catch (Exception e){
            logger.error("查询异常",e);
            voiceCheckResultResponse.setRspcode(WebUtil.EXCEPTION);
            voiceCheckResultResponse.setRspdesc("查询异常");
        }
        return voiceCheckResultResponse;
    }

}

