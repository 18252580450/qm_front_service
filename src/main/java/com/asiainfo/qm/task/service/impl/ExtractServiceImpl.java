package com.asiainfo.qm.task.service.impl;

import com.asiainfo.qm.execution.dao.VoicePoolMapper;
import com.asiainfo.qm.execution.dao.WorkformPoolMapper;
import com.asiainfo.qm.execution.domain.VoicePool;
import com.asiainfo.qm.execution.domain.WorkformPool;
import com.asiainfo.qm.manage.dao.QmPlanMapper;
import com.asiainfo.qm.manage.domain.QmPlan;
import com.asiainfo.qm.manage.util.DateUtil;
import com.asiainfo.qm.task.dao.QmBindRlnMapper;
import com.asiainfo.qm.task.domain.QmBindRln;
import com.asiainfo.qm.task.domain.QmBindRlnExample;
import com.asiainfo.qm.task.domain.QmVoice;
import com.asiainfo.qm.task.domain.QmWorkform;
import com.asiainfo.qm.task.service.IAutoExtractCommonService;
import com.asiainfo.qm.task.service.IExtractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shiying on 2018/12/21.
 */
@Service
public class ExtractServiceImpl implements IExtractService{

    @Autowired
    private QmPlanMapper qmPlanMapper;

    @Autowired
    private VoicePoolMapper voicePoolMapper;

    @Autowired
    private WorkformPoolMapper workformPoolMapper;

    @Autowired
    private QmBindRlnMapper qmBindRlnMapper;

    @Autowired
    private IAutoExtractCommonService autoExtractCommonService;

    public boolean extract(String planId){
        try {
            //      1、根据计划ID查询计划实例，根据计划ID查询计划与质检人和被质检人（班组）表
            QmPlan qmPlan = qmPlanMapper.selectByPrimaryKey(planId);
            QmBindRlnExample example = new QmBindRlnExample();
            QmBindRlnExample.Criteria criteria = example.createCriteria();
            criteria.andPlanIdEqualTo(planId);
            List<QmBindRln> qmBindRlns = qmBindRlnMapper.selectByExample(example);
            List<String> staffIds = new ArrayList<>();
            List<String> departIds = new ArrayList<>();
            if(qmBindRlns.size() > 0){
                for(int i = 0;i<qmBindRlns.size();i++){
                    QmBindRln qmBindRln = qmBindRlns.get(i);
                    if(null != qmBindRln.getCheckedObjectId() && !"".equals(qmBindRln.getCheckedObjectId())){
                        if(qmBindRln.getUserType().equals("0")){
                            staffIds.add(qmBindRln.getCheckedObjectId());
                        }else{
                            departIds.add(qmBindRln.getCheckedObjectId());
                        }
                    }
                }
            }
//     2、封装参数（计划ID，策略ID，抽取条数，被质检人工号、被质检班组ID）
            Map params = new HashMap<>();
            params.put("planId", planId);
            params.put("staffIds", staffIds);
            params.put("departIds", departIds);
            params.put("pId",qmPlan.getpId());
            params.put("limit", qmPlan.getPlanCount());
            if(qmPlan.getPlanType().equals("0")){
                //语音数据抽取
                List<QmVoice> voices = autoExtractCommonService.autoExtractVoiceInfo(params);
                //录入语音质检池
                saveQmVoicePools(voices,qmBindRlns,qmPlan);
            }else{
                //工单数据抽取
                List<QmWorkform> workforms = autoExtractCommonService.autoExtractWorkformInfo(params);
                //录入工单质检池
                saveQmWorkformPools(workforms,qmBindRlns,qmPlan);
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private void saveQmVoicePools(List<QmVoice> voices, List<QmBindRln> qmBindRlns,QmPlan qmPlan) throws Exception{
        if(voices.size() > 0){
            for(int i = 0;i<voices.size();i++){
                QmVoice qmVoice = voices.get(i);
                VoicePool voicePool = new VoicePool();
                voicePool.setTenantId(qmVoice.getTenantId());
                voicePool.setProvinceId(qmVoice.getProvinceId());
                voicePool.setCheckedStaffId(qmVoice.getStaffId());
                voicePool.setCheckedStaffName(qmVoice.getStaffName());
                voicePool.setDepartId(qmVoice.getDepartId());
                voicePool.setDepartName(qmVoice.getDepartName());
                voicePool.setBeginTime(qmVoice.getBeginTime());
                voicePool.setEndTime(qmVoice.getEndTime());
                voicePool.setTouchId(qmVoice.getTouchId());
                        voicePool.setCallType(qmVoice.getCallType());
                        voicePool.setIvrDuration(qmVoice.getIvrDuration());
                        voicePool.setAcwDuration(qmVoice.getAcwDuration());
                        voicePool.setAlertDuration(qmVoice.getAlertDuration());
                        voicePool.setQueueDuration(qmVoice.getQueueDuration());
                        voicePool.setTalkDuration(qmVoice.getTalkDuration());
                        voicePool.setEndType(qmVoice.getEndType());
                        voicePool.setStaffNumber(qmVoice.getStaffNumber());
                        voicePool.setCustomerNumber(qmVoice.getCustomerNumber());
                        voicePool.setRecordPath(qmVoice.getRecordPath());
                        voicePool.setSatisfyExtent(qmVoice.getSatisfyExtent());
                        voicePool.setDisconReason(qmVoice.getDisconReason());
                        voicePool.setCallReason(qmVoice.getCallReason());
                        voicePool.setNotOneSlt(qmVoice.getNotOneSlt());
                        voicePool.setBusinessType(qmVoice.getBusinessType());
                        voicePool.setReserve1(qmVoice.getReserve1());
                        voicePool.setReserve2(qmVoice.getReserve2());
                        voicePool.setReserve3(qmVoice.getReserve3());
                        voicePool.setReserve4(qmVoice.getReserve4());
                        voicePool.setReserve5(qmVoice.getReserve5());
                        voicePool.setReserve6(qmVoice.getReserve6());
                        voicePool.setReserve7(qmVoice.getReserve7());
                        voicePool.setReserve8(qmVoice.getReserve8());
                        //非公共参数
                        voicePool.setRecordTime(qmVoice.getTalkDuration());
                        if("1".equals(qmPlan.getManOrAuto())){
                            //自动分派
                            for(int j = 0;i<qmBindRlns.size();j++){
                                QmBindRln qmBindRln = qmBindRlns.get(j);
                                if(qmBindRln.getUserType().equals("0") && null != qmBindRln.getCheckedObjectId() &&
                                        qmBindRln.getCheckedObjectId().equals(qmVoice.getStaffId())){
                                    //话务员
                                    voicePool.setCheckStaffId(qmBindRln.getCheckStaffId());
                                }else if(qmBindRln.getUserType().equals("1") && null != qmBindRln.getCheckedObjectId() &&
                                qmBindRln.getCheckedObjectId().equals(qmVoice.getDepartId())){
                            //班组
                            voicePool.setCheckStaffId(qmBindRln.getCheckStaffId());
                        }
                    }
                    voicePool.setIsOperate("1");//分派状态 0未分派 1已分派
                    voicePool.setOperateTime(DateUtil.getCurrontTime());//分派时间
                }else{
                    voicePool.setIsOperate("0");//分派状态 0未分派 1已分派
                }
                voicePool.setPlanId(qmPlan.getPlanId());
                voicePool.setPoolStatus(0);//质检状态标识 0待质检
                voicePoolMapper.insertSelective(voicePool);
            }
        }
    }

    private void saveQmWorkformPools(List<QmWorkform> workforms, List<QmBindRln> qmBindRlns,QmPlan qmPlan) throws Exception{
        if(workforms.size() > 0){
            for(int i = 0;i<workforms.size();i++){
                QmWorkform qmWorkform = workforms.get(i);
                WorkformPool workformPool = new WorkformPool();
                workformPool.setCheckedStaffId(qmWorkform.getDspsComplteStaffId());
                workformPool.setDepartId(qmWorkform.getDspsComplteWorkGrpId());
                workformPool.setWrkfmId(qmWorkform.getWrkfmId());
                workformPool.setHandleDuration(qmWorkform.getHandleDuration());
                workformPool.setActualHandleDuration(qmWorkform.getActualHandleDuration());
                workformPool.setBeginTime(qmWorkform.getCrtTime());//创建时间
                workformPool.setEndTime(qmWorkform.getArcTime());//归档时间
                workformPool.setSrvReqstTypeId(qmWorkform.getSrvReqstTypeId());
                //非公共参数
                if("1".equals(qmPlan.getManOrAuto())){
                    //自动分派
                    for(int j = 0;i<qmBindRlns.size();j++){
                        QmBindRln qmBindRln = qmBindRlns.get(j);
                        if(qmBindRln.getUserType().equals("0") &&
                                qmBindRln.getCheckedObjectId().equals(qmWorkform.getArcStaffId())){
                            //话务员
                            workformPool.setCheckStaffId(qmBindRln.getCheckStaffId());
                        }else if(qmBindRln.getUserType().equals("1") &&
                                qmBindRln.getCheckedObjectId().equals(qmWorkform.getArcStaffDeptId())){
                            //班组
                            workformPool.setCheckStaffId(qmBindRln.getCheckStaffId());
                        }
                    }
                    workformPool.setIsOperate("1");//分派状态 0未分派 1已分派
                    workformPool.setOperateTime(DateUtil.getCurrontTime());//分派时间
                }else{
                    workformPool.setIsOperate("0");//分派状态 0未分派 1已分派
                }
                workformPool.setPoolStatus(0);//质检状态标识 0待质检
                workformPool.setPlanId(qmPlan.getPlanId());
                workformPoolMapper.insertSelective(workformPool);
            }
        }
    }
}
