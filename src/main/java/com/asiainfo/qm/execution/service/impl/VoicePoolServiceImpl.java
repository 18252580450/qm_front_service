package com.asiainfo.qm.execution.service.impl;

import com.asiainfo.qm.execution.dao.VoicePoolMapper;
import com.asiainfo.qm.execution.domain.VoicePool;
import com.asiainfo.qm.execution.domain.VoicePoolExample;
import com.asiainfo.qm.execution.service.VoicePoolService;
import com.asiainfo.qm.execution.vo.VoicePoolResponse;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.util.WebUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：wangcheng.
 * @ Date       ：Created in 14:22 2018/12/11
 * @ Description：${description}
 */
@Service
public class VoicePoolServiceImpl implements VoicePoolService {

    private static Logger logger = LoggerFactory.getLogger(VoicePoolServiceImpl.class);

    @Autowired
    private VoicePoolMapper voicePoolMapper;

    @Autowired
    private SequenceUtils sequenceUtils;

    @Override
    public VoicePoolResponse selectByParams(Map params, int start, int limit) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        VoicePoolResponse voicePoolResponse = null;
        VoicePoolExample example = new VoicePoolExample();
        try {
            VoicePoolExample.Criteria criteria= example.createCriteria();//在运行时动态生成查询语句
            if (null != params.get("touchId") && !"".equals(params.get("touchId"))) {
                criteria.andTouchIdEqualTo((String) params.get("touchId"));
            }
            if (null != params.get("planId") && !"".equals(params.get("planId"))) {
                criteria.andPlanIdEqualTo((String) params.get("planId"));
            }
            if (null != params.get("isOperate") && !"".equals(params.get("isOperate"))) {
                criteria.andIsOperateEqualTo((String) params.get("isOperate"));
            }
            if (null != params.get("checkStaffId") && !"".equals(params.get("checkStaffId"))) {
                criteria.andCheckStaffIdEqualTo((String) params.get("checkStaffId"));
            }
            if (null != params.get("checkedStaffId") && !"".equals(params.get("checkedStaffId"))) {
                criteria.andCheckedStaffIdEqualTo((String) params.get("checkedStaffId"));
            }
            if (null != params.get("hungupType") && !"".equals(params.get("hungupType"))) {
                criteria.andHungupTypeEqualTo((String) params.get("hungupType"));
            }
            if (null != params.get("startTime") && !"".equals(params.get("startTime")) && null != params.get("endTime") && !"".equals(params.get("endTime"))) {
                criteria.andCheckedTimeBetween(sdf.parse((String) params.get("startTime")), sdf.parse((String) params.get("endTime")));
            }
            if (null != params.get("callType") && !"".equals(params.get("callType"))) {
                criteria.andCallTypeEqualTo((String) params.get("callType"));
            }
            if (null != params.get("voiceSatisfyExtent") && !"".equals(params.get("voiceSatisfyExtent"))) {
                criteria.andVoiceSatisfyExtentEqualTo((String) params.get("voiceSatisfyExtent"));
            }
            if (null != params.get("callingNumber") && !"".equals(params.get("callingNumber"))) {
                criteria.andCallingNumberEqualTo((String) params.get("callingNumber"));
            }
            if (null != params.get("satisfyExtentType") && !"".equals(params.get("satisfyExtentType"))) {
                criteria.andSatisfyExtentTypeEqualTo((String) params.get("satisfyExtentType"));
            }
            if (null != params.get("vipSatisfyExtent") && !"".equals(params.get("vipSatisfyExtent"))) {
                criteria.andVipSatisfyExtentEqualTo((String) params.get("vipSatisfyExtent"));
            }
            if (null != params.get("mediaType") && !"".equals(params.get("mediaType"))) {
                criteria.andMediaTypeEqualTo((String) params.get("mediaType"));
            }
            if (null != params.get("srvReqstTypeId") && !"".equals(params.get("srvReqstTypeId"))) {
                criteria.andSrvReqstTypeIdEqualTo((String) params.get("srvReqstTypeId"));
            }
            if (null != params.get("strategyName") && !"".equals(params.get("strategyName"))) {
                criteria.andStrategyNameEqualTo((String) params.get("strategyName"));
            }
            if (null != params.get("recordTimeMin") && !"".equals(params.get("recordTimeMin")) && null != params.get("recordTimeMax") && !"".equals(params.get("recordTimeMax"))) {
                criteria.andRecordTimeBetween(Integer.parseInt((String) params.get("recordTimeMin")) , Integer.parseInt((String)  params.get("recordTimeMax")));
            }
            if (0 != limit) {
                PageHelper.offsetPage(start, limit);
                List<VoicePool> list = voicePoolMapper.selectByExample(example);
                Page<VoicePool> pagelist = (Page)list;
                voicePoolResponse = new VoicePoolResponse(pagelist);
            } else {
                voicePoolResponse = new VoicePoolResponse();
                List<VoicePool> list = voicePoolMapper.selectByExample(example);
                voicePoolResponse.setData(list);
            }

            if(null != voicePoolResponse.getData() && voicePoolResponse.getData().size() > 0){
                voicePoolResponse.setRspcode(WebUtil.SUCCESS);
                voicePoolResponse.setRspdesc("查询成功");
            }else {
                voicePoolResponse.setRspcode(WebUtil.FAIL);
                voicePoolResponse.setRspdesc("无数据");
            }
        }catch (Exception e){
            logger.error("查询异常",e);
            voicePoolResponse.setRspcode(WebUtil.EXCEPTION);
            voicePoolResponse.setRspdesc("查询异常");
        }
        return voicePoolResponse;
    }

    @Override
    public VoicePoolResponse update(@Param("list")List<String> list) throws Exception{
        VoicePoolResponse voicePoolResponse = new VoicePoolResponse();
        try {
            int result = voicePoolMapper.update(list);
            if (result > 0) {
                voicePoolResponse.setRspcode(WebUtil.SUCCESS);
                voicePoolResponse.setRspdesc("操作成功");
            } else {
                voicePoolResponse.setRspcode(WebUtil.FAIL);
                voicePoolResponse.setRspdesc("操作失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("操作异常", e);
            voicePoolResponse.setRspcode(WebUtil.EXCEPTION);
            voicePoolResponse.setRspdesc("操作异常");
        }
        return voicePoolResponse;
    }

    @Override
    public VoicePoolResponse updateCheck(List<Map> list) throws Exception{
        VoicePoolResponse voicePoolResponse = new VoicePoolResponse();
        try {
            int result = voicePoolMapper.updateCheck(list);
            if (result > 0) {
                voicePoolResponse.setRspcode(WebUtil.SUCCESS);
                voicePoolResponse.setRspdesc("操作成功");
            } else {
                voicePoolResponse.setRspcode(WebUtil.FAIL);
                voicePoolResponse.setRspdesc("操作失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("操作异常", e);
            voicePoolResponse.setRspcode(WebUtil.EXCEPTION);
            voicePoolResponse.setRspdesc("操作异常");
        }
        return voicePoolResponse;
    }
}

