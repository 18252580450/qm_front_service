package com.asiainfo.qm.task.service.impl;

import com.asiainfo.qm.manage.dao.QmPlanMapper;
import com.asiainfo.qm.manage.domain.QmPlan;
import com.asiainfo.qm.task.dao.QmBindRlnMapper;
import com.asiainfo.qm.task.domain.QmBindRln;
import com.asiainfo.qm.task.domain.QmBindRlnExample;
import com.asiainfo.qm.task.domain.QmVoice;
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

    public void extractVoice(String planId) throws Exception{
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
        Map params = new HashMap<>();
        params.put("planId", planId);
        params.put("staffId", staffIds.toString());
        params.put("departId", departIds.toString());
        params.put("pId",qmPlan.getpId());
        params.put("limit", qmPlan.getPlanCount());
        if(qmPlan.getPlanType().equals("0")){
            List<QmVoice> voices = autoExtractCommonService.autoExtractVoiceInfo(params);
            saveQmVoicePools(voices);
        }else{

        }
    }

    private void saveQmVoicePools(List<QmVoice> voices){
        if(voices.size() > 0){
            for(int i = 0;i<voices.size();i++){

            }
        }
    }
}
