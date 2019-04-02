package com.asiainfo.qm.execution.service.impl;

import com.asiainfo.qm.execution.dao.WorkformPoolMapper;
import com.asiainfo.qm.execution.domain.QmWorkForm;
import com.asiainfo.qm.execution.domain.WorkformPool;
import com.asiainfo.qm.execution.service.QmWorkformService;
import com.asiainfo.qm.execution.vo.QmWorkformResponse;
import com.asiainfo.qm.manage.util.Constants;
import com.asiainfo.qm.manage.util.DateUtil;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.task.dao.QmWorkformMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2019-03-20 20:06
 * @ Description：${description}
 */

@Service
public class QmWorkformServiceImpl implements QmWorkformService {

    private static Logger logger = LoggerFactory.getLogger(QmWorkformServiceImpl.class);
    @Autowired
    private QmWorkformMapper qmWorkformMapper;
    @Autowired
    private WorkformPoolMapper workformPoolMapper;

    @Override
    public QmWorkformResponse queryWorkForm(Map params, int start, int limit) throws Exception {
        QmWorkformResponse qmWorkformResponse = null;
        try {
            QmWorkForm qmWorkForm = new QmWorkForm();
            if (null != params.get("wrkfmShowSwftno") && !"".equals(params.get("wrkfmShowSwftno"))) {
                qmWorkForm.setWrkfmShowSwftno((String) params.get("wrkfmShowSwftno"));
            }
            if (null != params.get("acptStaffId") && !"".equals(params.get("acptStaffId"))) {
                qmWorkForm.setAcptStaffId((String) params.get("acptStaffId"));
            }
            if (null != params.get("arcBeginTime") && !"".equals(params.get("arcBeginTime")) && null != params.get("arcEndTime") && !"".equals(params.get("arcEndTime"))) {
                qmWorkForm.setArcBeginTime((String) params.get("arcBeginTime"));
                qmWorkForm.setArcEndTime((String) params.get("arcEndTime"));
            }
            if (null != params.get("custName") && !"".equals(params.get("custName"))) {
                qmWorkForm.setCustName((String) params.get("custName"));
            }
            if (null != params.get("custNum") && !"".equals(params.get("custNum"))) {
                qmWorkForm.setCustNum((String) params.get("custNum"));
            }

            if (0 != limit) {
                PageHelper.offsetPage(start, limit);
                List<QmWorkForm> list = qmWorkformMapper.queryBeyondPlanWorkForm(qmWorkForm);
                Page<QmWorkForm> pagelist = (Page) list;
                qmWorkformResponse = new QmWorkformResponse(pagelist);
            } else {
                qmWorkformResponse = new QmWorkformResponse();
                List<QmWorkForm> list = qmWorkformMapper.queryBeyondPlanWorkForm(qmWorkForm);
                qmWorkformResponse.setData(list);
            }

            if (null != qmWorkformResponse.getData() && qmWorkformResponse.getData().size() > 0) {
                qmWorkformResponse.setRspcode(WebUtil.SUCCESS);
                qmWorkformResponse.setRspdesc("查询成功");
            } else {
                qmWorkformResponse.setRspcode(WebUtil.FAIL);
                qmWorkformResponse.setRspdesc("无数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("工单查询异常", e);
            qmWorkformResponse.setRspcode(WebUtil.EXCEPTION);
            qmWorkformResponse.setRspdesc("工单查询异常");
        }
        return qmWorkformResponse;
    }

    @Override
    public QmWorkformResponse workFormAllocate(Map<String, Object> reqMap) throws Exception {
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> workFormList = (ArrayList<Map<String, Object>>) reqMap.get("workFormList");
        String templateId = reqMap.get("templateId").toString();
        String checkStaffId = reqMap.get("checkStaffId").toString();
        String checkStaffName = reqMap.get("checkStaffName").toString();
        QmWorkformResponse qmWorkformResponse = new QmWorkformResponse();
        try {
            for (Map<String, Object> workForm : workFormList
            ) {
                Boolean flag = insertWorkFormPool(templateId, checkStaffId, checkStaffName, workForm);
                if (!flag) {
                    qmWorkformResponse.setRspcode(WebUtil.FAIL);
                    qmWorkformResponse.setRspdesc("分配失败");
                    return qmWorkformResponse;
                }
            }
            qmWorkformResponse.setRspcode(WebUtil.SUCCESS);
            qmWorkformResponse.setRspdesc("分配成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("工单质检分配异常", e);
            qmWorkformResponse.setRspcode(WebUtil.EXCEPTION);
            qmWorkformResponse.setRspdesc("工单质检分配异常");
        }
        return qmWorkformResponse;
    }

    private Boolean insertWorkFormPool(String templateId, String checkStaffId, String checkStaffName, Map<String, Object> workForm) throws Exception {
        try {
            WorkformPool workformPool = new WorkformPool();

            if (null != workForm.get("wrkfmId") && !"".equals(workForm.get("wrkfmId"))) {
                workformPool.setWrkfmId(Long.parseLong(workForm.get("wrkfmId").toString()));
            }
            if (null != workForm.get("wrkfmShowSwftno") && !"".equals(workForm.get("wrkfmShowSwftno"))) {
                workformPool.setWrkfmShowSwftno(workForm.get("wrkfmShowSwftno").toString());         //显示工单号
            }
            if (null != workForm.get("provCode") && !"".equals(workForm.get("provCode"))) {
                workformPool.setProvinceId(workForm.get("provCode").toString());
            }
            if (null != workForm.get("handleDuration") && !"".equals(workForm.get("handleDuration"))) {
                workformPool.setHandleDuration(Integer.parseInt(workForm.get("handleDuration").toString()));
            }
            if (null != workForm.get("actualHandleDuration") && !"".equals(workForm.get("actualHandleDuration"))) {
                workformPool.setActualHandleDuration(Integer.parseInt(workForm.get("actualHandleDuration").toString()));
            }
            if (null != workForm.get("crtTime") && !"".equals(workForm.get("crtTime"))) {
                workformPool.setCrtTime(DateUtil.string2Date(workForm.get("crtTime").toString()));   //创建时间
            }
            if (null != workForm.get("arcTime") && !"".equals(workForm.get("arcTime"))) {
                workformPool.setArcTime(DateUtil.string2Date(workForm.get("arcTime").toString()));   //归档时间
            }
            if (null != workForm.get("srvReqstTypeId") && !"".equals(workForm.get("srvReqstTypeId"))) {
                workformPool.setSrvReqstTypeId(workForm.get("srvReqstTypeId").toString());           //服务请求类型id
            }
            if (null != workForm.get("srvReqstTypeNm") && !"".equals(workForm.get("srvReqstTypeNm"))) {
                workformPool.setSrvReqstTypeNm(workForm.get("srvReqstTypeNm").toString());           //服务请求类型名称
            }
            if (null != workForm.get("srvReqstTypeFullNm") && !"".equals(workForm.get("srvReqstTypeFullNm"))) {
                workformPool.setSrvReqstTypeFullNm(workForm.get("srvReqstTypeFullNm").toString());   //服务请求类型全称
            }
            if (null != workForm.get("bizCntt") && !"".equals(workForm.get("bizCntt"))) {
                workformPool.setBizCntt(workForm.get("bizCntt").toString());                         //工单内容
            }
            if (null != workForm.get("bizTitle") && !"".equals(workForm.get("bizTitle"))) {
                workformPool.setBizTitle(workForm.get("bizTitle").toString());                       //工单标题
            }
            if (null != workForm.get("custEmail") && !"".equals(workForm.get("custEmail"))) {
                workformPool.setCustEmail(workForm.get("custEmail").toString());                     //客户账号
            }
            if (null != workForm.get("custName") && !"".equals(workForm.get("custName"))) {
                workformPool.setCustName(workForm.get("custName").toString());                       //客户姓名
            }
            if (null != workForm.get("custNum") && !"".equals(workForm.get("custNum"))) {
                workformPool.setCustNum(workForm.get("custNum").toString());                         //客户号码
            }
            if (null != workForm.get("acptStaffId") && !"".equals(workForm.get("acptStaffId"))) {
                workformPool.setAcptStaffId(workForm.get("acptStaffId").toString());                 //立单人id
            }
            if (null != workForm.get("acptStaffNum") && !"".equals(workForm.get("acptStaffNum"))) {
                workformPool.setAcptStaffNum(workForm.get("acptStaffNum").toString());               //立单人姓名
            }
            workformPool.setIsOperate(Constants.QM_DISTRIBUTE_STATUS.TRUE);                          //分派状态
            workformPool.setOperateTime(DateUtil.getCurrontTime());                                  //分派时间
            workformPool.setCheckedTime(DateUtil.getCurrontTime());                                  //抽取时间
            workformPool.setPoolStatus(Integer.parseInt(Constants.QM_CHECK_STATUS.CHECKING));        //质检状态标识
            workformPool.setCheckStaffId(checkStaffId);                                              //质检员工号
            workformPool.setCheckStaffName(checkStaffName);                                          //质检员姓名
            workformPool.setTemplateId(templateId);                                                  //模版id
            workformPool.setPlanId("");                                                              //计划外质检不绑定planId

            int result = workformPoolMapper.insertSelective(workformPool);
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("工单质检分配异常", e);
        }
        return false;
    }
}
