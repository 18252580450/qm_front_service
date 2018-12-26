package com.asiainfo.qm.task.service.impl;

import com.asiainfo.qm.manage.dao.QmPlanMapper;
import com.asiainfo.qm.manage.domain.QmPlan;
import com.asiainfo.qm.task.dao.QmBindRlnMapper;
import com.asiainfo.qm.task.domain.QmBindRln;
import com.asiainfo.qm.task.domain.QmBindRlnExample;
import com.asiainfo.qm.task.domain.QmVoice;
import com.asiainfo.qm.task.domain.QmWorkform;
import com.asiainfo.qm.task.service.IAutoExtractCommonService;
import com.asiainfo.qm.task.service.IExtractVoiceInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shiying on 2018/12/21.
 */
public class ExtractVoiceInfoServiceImpl implements IExtractVoiceInfoService{

    @Autowired
    private QmPlanMapper qmPlanMapper;

    @Autowired
    private QmBindRlnMapper qmBindRlnMapper;

    @Autowired
    private IAutoExtractCommonService autoExtractCommonService;

    public void extract(String planId) throws Exception{
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
        params.put("staffId", staffIds.toString());
        params.put("departId", departIds.toString());
        params.put("pId",qmPlan.getpId());
        params.put("limit", qmPlan.getPlanCount());
        if(qmPlan.getPlanType().equals("0")){
            //语音数据收取
            List<QmVoice> voices = autoExtractCommonService.autoExtractVoiceInfo(params);
            //录入质检池
            saveQmVoicePools(voices);
        }else{
            //工单数据抽取
            List<QmWorkform> workforms = autoExtractCommonService.autoExtractWorkformInfo(params);
            //录入质检池
            saveQmWorkformPools(workforms);
        }
    }

    private void saveQmVoicePools(List<QmVoice> voices){
        if(voices.size() > 0){
            for(int i = 0;i<voices.size();i++){

            }
        }
    }

    private void saveQmWorkformPools(List<QmWorkform> workforms){
        if(workforms.size() > 0){
            for(int i = 0;i<workforms.size();i++){

            }
        }
    }
}
