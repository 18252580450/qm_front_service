package com.asiainfo.qm.manage.service.impl;

import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.dao.AppealNodeMapper;
import com.asiainfo.qm.manage.dao.AppealProcessMapper;
import com.asiainfo.qm.manage.domain.*;
import com.asiainfo.qm.manage.service.AppealProcessService;
import com.asiainfo.qm.manage.util.DateUtil;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.AppealNodeResponse;
import com.asiainfo.qm.manage.vo.AppealProcessDetailResponse;
import com.asiainfo.qm.manage.vo.AppealProcessResponse;
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
 * @ Date       ：Created in 15:07 2018/11/8
 * @ Description：${description}
 */
@Service
public class AppealProcessServiceImpl implements AppealProcessService {

    private static Logger logger = LoggerFactory.getLogger(AppealProcessServiceImpl.class);

    @Autowired
    private AppealProcessMapper appealProcessMapper;
    @Autowired
    private AppealNodeMapper appealNodeMapper;

    @Autowired
    private SequenceUtils sequenceUtils;

    @Override
    public AppealProcessResponse queryAppealProcess(Map params, int start, int limit) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        AppealProcessResponse appealProcessResponse = null;
        AppealProcessExample example = new AppealProcessExample();
        try {
            AppealProcessExample.Criteria criteria = example.createCriteria();
            if (null != params.get("departmentId") && !"".equals(params.get("departmentId"))) {
                criteria.andDepartmentIdEqualTo((String) params.get("departmentId"));
            }
            if (null != params.get("mainProcessFlag") && !"".equals(params.get("mainProcessFlag"))) {
                criteria.andMainProcessFlagEqualTo((String) params.get("mainProcessFlag"));
            }
            if (null != params.get("processId") && !"".equals(params.get("processId"))) {
                criteria.andProcessIdEqualTo((String) params.get("processId"));
            }
            if (null != params.get("parentProcessId") && !"".equals(params.get("parentProcessId"))) {
                criteria.andParentProcessIdEqualTo((String) params.get("parentProcessId"));
            }
            if (null != params.get("processName") && !"".equals(params.get("processName"))) {
                criteria.andProcessNameLike("%" + (String) params.get("processName") + "%");
            }
            if (null != params.get("createStaffId") && !"".equals(params.get("createStaffId"))) {
                criteria.andCreateStaffIdEqualTo((String) params.get("createStaffId"));
            }
            if (null != params.get("tenantId") && !"".equals(params.get("tenantId"))) {
                criteria.andTenantIdEqualTo((String) params.get("tenantId"));
            }
            if (null != params.get("checkType") && !"".equals(params.get("checkType"))) {
                criteria.andCheckTypeEqualTo((String) params.get("checkType"));
            }
            if (null != params.get("processStatus") && !"".equals(params.get("processStatus"))) {
                criteria.andProcessStatusEqualTo((String) params.get("processStatus"));
            }
            if (null != params.get("createTimeBegin") && !"".equals(params.get("createTimeBegin")) && null != params.get("createTimeEnd") && !"".equals(params.get("createTimeEnd"))) {
                criteria.andCreateTimeBetween(sdf.parse((String) params.get("createTimeBegin")), sdf.parse((String) params.get("createTimeEnd")));
            }

            if (0 != limit) {
                PageHelper.offsetPage(start, limit);
                List<AppealProcess> list = appealProcessMapper.selectByExample(example);
                Page<AppealProcess> pagelist = (Page) list;
                appealProcessResponse = new AppealProcessResponse(pagelist);
            } else {
                appealProcessResponse = new AppealProcessResponse();
                List<AppealProcess> list = appealProcessMapper.selectByExample(example);
                appealProcessResponse.setData(list);
            }

            if (null != appealProcessResponse.getData() && appealProcessResponse.getData().size() > 0) {
                appealProcessResponse.setRspcode(WebUtil.SUCCESS);
                appealProcessResponse.setRspdesc("查询成功");
            } else {
                appealProcessResponse.setRspcode(WebUtil.FAIL);
                appealProcessResponse.setRspdesc("无数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("申诉流程查询异常", e);
            appealProcessResponse.setRspcode(WebUtil.EXCEPTION);
            appealProcessResponse.setRspdesc("申诉流程查询异常");
        }
        return appealProcessResponse;
    }

    @Override
    public AppealProcessDetailResponse queryProcessDetail(Map params, int start, int limit) throws Exception {
        AppealProcessDetailResponse appealProcessDetailResponse = null;
        try {
            AppealProcessDetail appealProcessDetail = new AppealProcessDetail();
            if (null != params.get("tenantId") && !"".equals(params.get("tenantId"))) {
                appealProcessDetail.setTenantId((String) params.get("tenantId"));
            }
            if (null != params.get("processId") && !"".equals(params.get("processId"))) {
                appealProcessDetail.setParentProcessId((String) params.get("processId"));
            }

            appealProcessDetailResponse = new AppealProcessDetailResponse();

            List<AppealProcessDetail> list = appealProcessMapper.unionSelectByExample(appealProcessDetail);
            appealProcessDetailResponse.setData(list);

            if (null != appealProcessDetailResponse.getData() && appealProcessDetailResponse.getData().size() > 0) {
                appealProcessDetailResponse.setRspcode(WebUtil.SUCCESS);
                appealProcessDetailResponse.setRspdesc("查询成功");
            } else {
                appealProcessDetailResponse.setRspcode(WebUtil.FAIL);
                appealProcessDetailResponse.setRspdesc("无数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("审批流程查询异常", e);
            appealProcessDetailResponse.setRspcode(WebUtil.EXCEPTION);
            appealProcessDetailResponse.setRspdesc("审批流程查询异常");
        }
        return appealProcessDetailResponse;
    }

    @Override
    public AppealProcessResponse createAppealProcess(Map<String, Object> reqMap) throws Exception {
        AppealProcessResponse appealProcessResponse = new AppealProcessResponse();
        @SuppressWarnings("unchecked")
        List<Map> appealProcessList = (ArrayList<Map>) reqMap.get("appealProcess");
        List<AppealProcess> appealProcesses = new ArrayList<AppealProcess>();
        List<AppealNode> appealNodes = new ArrayList<AppealNode>();
        //生成主流程id
        String mainProcessId = String.valueOf(sequenceUtils.getSequence("t_qm_appeal_process_info"));
        Date currentTime = DateUtil.getCurrontTime();
        try {
            for (int i = 0; i < appealProcessList.size(); i++) {
                AppealProcess appealProcess = new AppealProcess();
                String subProcessId = String.valueOf(Long.parseLong(mainProcessId) + i);
                if (i == 0) {
                    appealProcess.setProcessId(mainProcessId);
                    appealProcess.setParentProcessId(mainProcessId);
                } else {
                    appealProcess.setProcessId(subProcessId);
                    appealProcess.setParentProcessId(mainProcessId);
                }
                //添加子流程
                appealProcess.setCreateTime(currentTime);
                appealProcess.setProcessName(appealProcessList.get(i).get("processName").toString());
                appealProcess.setTenantId(appealProcessList.get(i).get("tenantId").toString());
                appealProcess.setDepartmentId(appealProcessList.get(i).get("departmentId").toString());
                appealProcess.setDepartmentName(appealProcessList.get(i).get("departmentName").toString());
                appealProcess.setCheckType(appealProcessList.get(i).get("checkType").toString());
                appealProcess.setMainProcessFlag(appealProcessList.get(i).get("mainProcessFlag").toString());
                appealProcess.setMaxAppealNum(Integer.parseInt(appealProcessList.get(i).get("maxAppealNum").toString()));
                appealProcess.setOrderNo(Integer.parseInt(appealProcessList.get(i).get("orderNo").toString()));
                appealProcess.setSubProcessNum(Integer.parseInt(appealProcessList.get(i).get("subProcessNum").toString()));
                appealProcess.setSubNodeNum(Integer.parseInt(appealProcessList.get(i).get("subNodeNum").toString()));

                appealProcesses.add(appealProcess);

                //添加子节点
                @SuppressWarnings("unchecked")
                List<Map> appealNodeList = (ArrayList<Map>) appealProcessList.get(i).get("subNodeList");
                if (!appealNodeList.isEmpty()) {
                    for (Map data : appealNodeList
                    ) {
                        AppealNode appealNode = new AppealNode();
                        appealNode.setProcessId(subProcessId);
                        appealNode.setCreateTime(currentTime);
                        appealNode.setTenantId(data.get("tenantId").toString());
                        appealNode.setNodeId(Integer.parseInt(data.get("nodeId").toString()));
                        appealNode.setNodeName(data.get("nodeName").toString());
                        appealNode.setUserId(data.get("userId").toString());
                        appealNode.setInformId(data.get("userId").toString());
                        appealNode.setUserName(data.get("userName").toString());
                        appealNode.setUserType(data.get("userType").toString());
                        appealNode.setOrderNo(Integer.parseInt(data.get("orderNo").toString()));

                        appealNodes.add(appealNode);
                    }
                }
            }
            //新增流程
            appealProcessResponse = addAppealProcess(appealProcesses);
            if (!appealProcessResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                return appealProcessResponse;
            } else {//新增节点
                if (!appealNodes.isEmpty()) {
                    AppealNodeResponse appealNodeResponse = addAppealNode(appealNodes);
                    //新增节点失败
                    if (!appealNodeResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                        appealProcessResponse.setRspcode(appealNodeResponse.getRspcode());
                        appealProcessResponse.setRspdesc(appealNodeResponse.getRspdesc());
                        return appealProcessResponse;
                    }
                }
            }
            appealProcessResponse.setRspcode(WebUtil.SUCCESS);
            appealProcessResponse.setRspdesc("新增成功");
        } catch (Exception e) {
            logger.error("申诉流程新增异常", e);
            appealProcessResponse.setRspcode(WebUtil.EXCEPTION);
            appealProcessResponse.setRspdesc("申诉流程新增异常!");
        }
        return appealProcessResponse;
    }

    @Override
    public AppealProcessResponse editAppealProcess(Map<String, Object> reqMap) throws Exception {
        AppealProcessResponse appealProcessResponse = new AppealProcessResponse();
        AppealNodeResponse appealNodeResponse = new AppealNodeResponse();
        Date currentTime = DateUtil.getCurrontTime();
        String mainProcessId = reqMap.get("mainProcessId").toString();
        //新增子流程id
        String subProcessId = String.valueOf(sequenceUtils.getSequence("t_qm_appeal_process_info"));
        @SuppressWarnings("unchecked")
        List<Map> processAddData = (ArrayList<Map>) reqMap.get("processAddData");
        @SuppressWarnings("unchecked")
        List<Map> processDelData = (ArrayList<Map>) reqMap.get("processDelData");
        @SuppressWarnings("unchecked")
        List<Map> processUpdateData = (ArrayList<Map>) reqMap.get("processUpdateData");
        @SuppressWarnings("unchecked")
        List<Map> nodeAddData = (ArrayList<Map>) reqMap.get("nodeAddData");
        @SuppressWarnings("unchecked")
        List<Map> nodeDelData = (ArrayList<Map>) reqMap.get("nodeDelData");
        @SuppressWarnings("unchecked")
        List<Map> nodeUpdateData = (ArrayList<Map>) reqMap.get("nodeUpdateData");
        try {
            //子节点删除（已有子流程的已有子节点）
            if (!nodeDelData.isEmpty()) {
                List<AppealNode> nodeDelList = new ArrayList<AppealNode>();
                for (Map data : nodeDelData
                ) {
                    AppealNode appealNode = new AppealNode();
                    appealNode.setProcessId(data.get("processId").toString());
                    appealNode.setNodeId(Integer.parseInt(data.get("nodeId").toString()));
                    appealNode.setUserId(data.get("userId").toString());
                    nodeDelList.add(appealNode);
                }
                appealNodeResponse = deleteAppealNode(null, nodeDelList);
                if (!appealNodeResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    appealProcessResponse.setRspcode(appealNodeResponse.getRspcode());
                    appealProcessResponse.setRspdesc(appealNodeResponse.getRspdesc());
                    return appealProcessResponse;
                }
            }

            //子节点修改（已有子流程的已有子节点）
            if (!nodeUpdateData.isEmpty()) {
                List<AppealNode> nodeUpdateList = new ArrayList<AppealNode>();
                for (Map data : nodeUpdateData
                ) {
                    AppealNode appealNode = new AppealNode();
                    appealNode.setModifyTime(currentTime);
                    appealNode.setProcessId(data.get("processId").toString());
                    appealNode.setNodeId(Integer.parseInt(data.get("nodeId").toString()));
                    appealNode.setUserId(data.get("userId").toString());
                    appealNode.setNodeName(data.get("nodeName").toString());

                    nodeUpdateList.add(appealNode);
                }
                appealNodeResponse = updateAppealNode(nodeUpdateList);
                if (!appealNodeResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    appealNodeResponse.setRspcode(appealNodeResponse.getRspcode());
                    appealProcessResponse.setRspdesc(appealNodeResponse.getRspdesc());
                    return appealProcessResponse;
                }
            }

            //子节点新增（已有子流程的新增节点）
            if (!nodeAddData.isEmpty()) {
                List<AppealNode> nodeAddList = new ArrayList<AppealNode>();
                for (Map data : nodeAddData
                ) {
                    AppealNode appealNode = new AppealNode();
                    appealNode.setProcessId(data.get("processId").toString());
                    appealNode.setCreateTime(currentTime);
                    appealNode.setTenantId(data.get("tenantId").toString());
                    appealNode.setNodeId(Integer.parseInt(data.get("nodeId").toString()));
                    appealNode.setNodeName(data.get("nodeName").toString());
                    appealNode.setUserId(data.get("userId").toString());
                    appealNode.setInformId(data.get("userId").toString());
                    appealNode.setUserName(data.get("userName").toString());
                    appealNode.setUserType(data.get("userType").toString());
                    appealNode.setOrderNo(Integer.parseInt(data.get("orderNo").toString()));

                    nodeAddList.add(appealNode);
                }
                appealNodeResponse = addAppealNode(nodeAddList);
                if (!appealNodeResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    appealProcessResponse.setRspcode(appealNodeResponse.getRspcode());
                    appealProcessResponse.setRspdesc(appealNodeResponse.getRspdesc());
                    return appealProcessResponse;
                }
            }

            //子流程删除（删除子流程及该流程下的所有子节点）
            if (!processDelData.isEmpty()) {
                List<AppealProcess> processIdList = new ArrayList<AppealProcess>();
                for (Map data : processDelData
                ) {
                    AppealProcess appealProcess = new AppealProcess();
                    appealProcess.setProcessId(data.get("processId").toString());
                    appealProcess.setSubNodeNum(Integer.parseInt(data.get("subNodeNum").toString()));
                    processIdList.add(appealProcess);
                }
                appealProcessResponse = deleteSubProcess(processIdList);
                if (!appealProcessResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    return appealProcessResponse;
                }
            }

            //子流程修改
            if (!processUpdateData.isEmpty()) {
                List<AppealProcess> processesUpdateList = new ArrayList<AppealProcess>();
                for (Map data : processUpdateData
                ) {
                    AppealProcess appealProcess = new AppealProcess();
                    appealProcess.setProcessId(data.get("processId").toString());
                    appealProcess.setModifyTime(currentTime);
                    appealProcess.setProcessName(data.get("processName").toString());
                    appealProcess.setDepartmentId(data.get("departmentId").toString());
                    appealProcess.setDepartmentName(data.get("departmentName").toString());
                    appealProcess.setSubNodeNum(Integer.parseInt(data.get("subNodeNum").toString()));

                    processesUpdateList.add(appealProcess);
                }
                appealProcessResponse = updateAppealProcess(processesUpdateList);
                if (!appealProcessResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    return appealProcessResponse;
                }
            }

            //子流程新增（包括新增子流程的子节点新增）
            if (!processAddData.isEmpty()) {
                List<AppealProcess> processAddList = new ArrayList<AppealProcess>();
                List<AppealNode> nodeAddList = new ArrayList<AppealNode>();
                for (Map data : processAddData
                ) {
                    AppealProcess appealProcess = new AppealProcess();
                    appealProcess.setProcessId(subProcessId);
                    appealProcess.setParentProcessId(mainProcessId);
                    appealProcess.setCreateTime(currentTime);
                    appealProcess.setProcessName(data.get("processName").toString());
                    appealProcess.setTenantId(data.get("tenantId").toString());
                    appealProcess.setDepartmentId(data.get("departmentId").toString());
                    appealProcess.setDepartmentName(data.get("departmentName").toString());
                    appealProcess.setCheckType(data.get("checkType").toString());
                    appealProcess.setMainProcessFlag(data.get("mainProcessFlag").toString());
                    appealProcess.setOrderNo(Integer.parseInt(data.get("orderNo").toString()));
                    appealProcess.setSubProcessNum(Integer.parseInt(data.get("subProcessNum").toString()));
                    appealProcess.setSubNodeNum(Integer.parseInt(data.get("subNodeNum").toString()));

                    processAddList.add(appealProcess);

                    //添加子节点
                    if (data.containsKey("subNodeList")) {
                        @SuppressWarnings("unchecked")
                        List<Map> appealNodeList = (ArrayList<Map>) data.get("subNodeList");
                        if (!appealNodeList.isEmpty()) {
                            for (Map node : appealNodeList
                            ) {
                                AppealNode appealNode = new AppealNode();
                                appealNode.setProcessId(subProcessId);
                                appealNode.setCreateTime(currentTime);
                                appealNode.setTenantId(node.get("tenantId").toString());
                                appealNode.setNodeId(Integer.parseInt(node.get("nodeId").toString()));
                                appealNode.setNodeName(node.get("nodeName").toString());
                                appealNode.setUserId(node.get("userId").toString());
                                appealNode.setInformId(node.get("userId").toString());
                                appealNode.setUserName(node.get("userName").toString());
                                appealNode.setUserType(node.get("userType").toString());
                                appealNode.setOrderNo(Integer.parseInt(node.get("orderNo").toString()));

                                nodeAddList.add(appealNode);
                            }
                        }
                    }
                    //生成新子流程id
                    subProcessId = String.valueOf(Long.parseLong(subProcessId) + 1);
                }
                //新增流程
                appealProcessResponse = addAppealProcess(processAddList);
                if (!appealProcessResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    return appealProcessResponse;
                } else {  //新增节点（流程新增成功之后）
                    if (!nodeAddList.isEmpty()) {
                        appealNodeResponse = addAppealNode(nodeAddList);
                        if (!appealNodeResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                            appealProcessResponse.setRspcode(appealNodeResponse.getRspcode());
                            appealProcessResponse.setRspdesc(appealNodeResponse.getRspdesc());
                            return appealProcessResponse;
                        }
                    }
                }
            }
            appealProcessResponse.setRspcode(WebUtil.SUCCESS);
            appealProcessResponse.setRspdesc("修改成功");
        } catch (Exception e) {
            logger.error("申诉流程更新异常", e);
            appealProcessResponse.setRspcode(WebUtil.EXCEPTION);
            appealProcessResponse.setRspdesc("申诉流程更新异常!");
        }
        return appealProcessResponse;
    }

    @Override
    public AppealProcessResponse deleteMainProcess(List<String> processList) throws Exception {
        AppealProcessResponse appealProcessResponse = new AppealProcessResponse();
        try {
            AppealProcessExample mainProcessExample = new AppealProcessExample();
            AppealProcessExample.Criteria mainProcessCriteria = mainProcessExample.createCriteria();
            AppealProcessExample subProcessExample = new AppealProcessExample();
            AppealProcessExample.Criteria subProcessCriteria = subProcessExample.createCriteria();

            int result = 0;

            //查询子流程id
            subProcessCriteria.andParentProcessIdIn(processList);
            subProcessCriteria.andProcessIdNotIn(processList);   //排除主流程
            //子流程列表
            List<AppealProcess> subProcessList = appealProcessMapper.selectByExample(subProcessExample);
            List<String> nodeDelList = new ArrayList<>();
            for (AppealProcess subProcess : subProcessList
            ) {
                //判断该子流程有无子节点
                if (subProcess.getSubNodeNum() != 0) {
                    nodeDelList.add(subProcess.getProcessId());
                }
            }
            //删除子节点
            AppealNodeResponse appealNodeResponse = new AppealNodeResponse();
            if (!nodeDelList.isEmpty()) {
                appealNodeResponse = deleteAppealNode(nodeDelList, null);
            }

            //子节点删除成功后再删除子流程（或无子节点）
            if (nodeDelList.isEmpty() || appealNodeResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                //删除子流程（存在子流程）
                if (!subProcessList.isEmpty()) {
                    result = appealProcessMapper.deleteByExample(subProcessExample);
                    if (result > 0) {
                        //删除主流程
                        mainProcessCriteria.andProcessIdIn(processList);
                        result = appealProcessMapper.deleteByExample(mainProcessExample);
                    }
                } else {  //不存在子流程
                    //删除主流程
                    mainProcessCriteria.andProcessIdIn(processList);
                    result = appealProcessMapper.deleteByExample(mainProcessExample);
                }
            }
            if (result > 0) {
                appealProcessResponse.setRspcode(WebUtil.SUCCESS);
                appealProcessResponse.setRspdesc("删除成功");
            } else {
                appealProcessResponse.setRspcode(WebUtil.FAIL);
                appealProcessResponse.setRspdesc("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("主流程删除异常", e);
            appealProcessResponse.setRspcode(WebUtil.EXCEPTION);
            appealProcessResponse.setRspdesc("主流程删除异常");
        }
        return appealProcessResponse;
    }

    @Override
    public AppealProcessResponse changeProcessStatus(List<AppealProcess> processList, String processStatus) throws Exception {
        AppealProcessResponse appealProcessResponse = new AppealProcessResponse();
        String rspDesc = "";
        if (processStatus.equals("1")) {
            rspDesc = "启动";
        } else {
            rspDesc = "暂停";
        }
        try {
            int result = 0;
            for (AppealProcess appealProcess : processList
            ) {
                appealProcess.setModifyTime(DateUtil.getCurrontTime());
                result = appealProcessMapper.updateByPrimaryKey(appealProcess);
                if (result == 0) {
                    break;
                }
            }
            if (result > 0) {
                appealProcessResponse.setRspcode(WebUtil.SUCCESS);
                appealProcessResponse.setRspdesc(rspDesc + "成功");
            } else {
                appealProcessResponse.setRspcode(WebUtil.FAIL);
                appealProcessResponse.setRspdesc(rspDesc + "失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("流程状态更新异常", e);
            appealProcessResponse.setRspcode(WebUtil.EXCEPTION);
            appealProcessResponse.setRspdesc("流程状态更新异常");
        }
        return appealProcessResponse;
    }

    private AppealProcessResponse addAppealProcess(List<AppealProcess> appealProcessList) throws Exception {
        AppealProcessResponse appealProcessResponse = new AppealProcessResponse();
        try {
            int result = 0;
            for (AppealProcess appealProcess : appealProcessList
            ) {
                result = appealProcessMapper.insertSelective(appealProcess);
                if (result == 0) {
                    break;
                }
            }
            if (result > 0) {
                appealProcessResponse.setRspcode(WebUtil.SUCCESS);
            } else {
                appealProcessResponse.setRspcode(WebUtil.FAIL);
                appealProcessResponse.setRspdesc("申诉流程新增失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("申诉流程新增异常", e);
            appealProcessResponse.setRspcode(WebUtil.EXCEPTION);
            appealProcessResponse.setRspdesc("申诉流程新增异常");
        }
        return appealProcessResponse;
    }

    private AppealProcessResponse deleteSubProcess(List<AppealProcess> processList) throws Exception {
        AppealProcessResponse appealProcessResponse = new AppealProcessResponse();
        try {
            AppealProcessExample subProcessExample = new AppealProcessExample();
            AppealProcessExample.Criteria subProcessCriteria = subProcessExample.createCriteria();
            List<String> nodeDelList = new ArrayList<>();
            List<String> processDelList = new ArrayList<>();
            for (AppealProcess subProcess : processList
            ) {
                //判断该子流程有无子节点
                if (subProcess.getSubNodeNum() != 0) {
                    nodeDelList.add(subProcess.getProcessId());
                }
                processDelList.add(subProcess.getProcessId());
            }
            //删除子节点
            AppealNodeResponse appealNodeResponse = new AppealNodeResponse();
            if (!nodeDelList.isEmpty()) {
                appealNodeResponse = deleteAppealNode(nodeDelList, null);
                if (!appealNodeResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    appealProcessResponse.setRspcode(appealNodeResponse.getRspcode());
                    appealProcessResponse.setRspdesc(appealNodeResponse.getRspdesc());
                    return appealProcessResponse;
                }
            }

            //删除子流程
            subProcessCriteria.andProcessIdIn(processDelList);
            int result = appealProcessMapper.deleteByExample(subProcessExample);
            if (result > 0) {
                appealProcessResponse.setRspcode(WebUtil.SUCCESS);
            } else {
                appealProcessResponse.setRspcode(WebUtil.FAIL);
                appealProcessResponse.setRspdesc("子流程删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("子流程删除异常", e);
            appealProcessResponse.setRspcode(WebUtil.EXCEPTION);
            appealProcessResponse.setRspdesc("子流程删除异常");
        }
        return appealProcessResponse;
    }

    private AppealProcessResponse updateAppealProcess(List<AppealProcess> appealProcesses) throws Exception {
        AppealProcessResponse appealProcessResponse = new AppealProcessResponse();
        try {
            int result = 0;
            for (AppealProcess appealProcess : appealProcesses
            ) {
                result = appealProcessMapper.updateByPrimaryKeySelective(appealProcess);
                if (result == 0) {
                    break;
                }
            }
            if (result > 0) {
                appealProcessResponse.setRspcode(WebUtil.SUCCESS);
            } else {
                appealProcessResponse.setRspcode(WebUtil.FAIL);
                appealProcessResponse.setRspdesc("子流程更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("子流程更新异常", e);
            appealProcessResponse.setRspcode(WebUtil.EXCEPTION);
            appealProcessResponse.setRspdesc("子流程更新异常");
        }
        return appealProcessResponse;
    }

    private AppealNodeResponse addAppealNode(List<AppealNode> appealNodeList) throws Exception {
        AppealNodeResponse appealNodeResponse = new AppealNodeResponse();
        try {
            int result = 0;
            for (AppealNode appealNode : appealNodeList
            ) {
                result = appealNodeMapper.insertSelective(appealNode);
                if (result == 0) {
                    break;
                }
            }
            if (result > 0) {
                appealNodeResponse.setRspcode(WebUtil.SUCCESS);
            } else {
                appealNodeResponse.setRspcode(WebUtil.FAIL);
                appealNodeResponse.setRspdesc("申诉节点新增失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("申诉节点新增异常", e);
            appealNodeResponse.setRspcode(WebUtil.EXCEPTION);
            appealNodeResponse.setRspdesc("申诉节点新增异常");
        }
        return appealNodeResponse;
    }

    private AppealNodeResponse deleteAppealNode(List<String> processIdList, List<AppealNode> appealNodes) throws Exception {
        AppealNodeResponse appealNodeResponse = new AppealNodeResponse();
        try {
            int result = 0;
            //根据父流程Id删除子节点
            if (processIdList != null && !processIdList.isEmpty()) {
                AppealNodeExample example = new AppealNodeExample();
                AppealNodeExample.Criteria criteria = example.createCriteria();
                criteria.andProcessIdIn(processIdList);
                result = appealNodeMapper.deleteByExample(example);
            }
            if (appealNodes != null && !appealNodes.isEmpty()) {
                for (AppealNode appealNode : appealNodes
                ) {
                    AppealNodeExample example = new AppealNodeExample();
                    AppealNodeExample.Criteria criteria = example.createCriteria();
                    criteria.andProcessIdEqualTo(appealNode.getProcessId());
                    criteria.andNodeIdEqualTo(appealNode.getNodeId());
                    criteria.andUserIdEqualTo(appealNode.getUserId());

                    result = appealNodeMapper.deleteByExample(example);
                    if (result == 0) {
                        break;
                    }
                }
            }
            if (result > 0) {
                appealNodeResponse.setRspcode(WebUtil.SUCCESS);
            } else {
                appealNodeResponse.setRspcode(WebUtil.FAIL);
                appealNodeResponse.setRspdesc("子节点删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("子节点删除异常", e);
            appealNodeResponse.setRspcode(WebUtil.EXCEPTION);
            appealNodeResponse.setRspdesc("子节点删除异常");
        }
        return appealNodeResponse;
    }

    private AppealNodeResponse updateAppealNode(List<AppealNode> appealNodes) throws Exception {
        AppealNodeResponse appealNodeResponse = new AppealNodeResponse();
        try {
            int result = 0;
            for (AppealNode appealNode : appealNodes
            ) {
                result = appealNodeMapper.updateByPrimaryKeySelective(appealNode);
                if (result == 0) {
                    break;
                }
            }
            if (result > 0) {
                appealNodeResponse.setRspcode(WebUtil.SUCCESS);
            } else {
                appealNodeResponse.setRspcode(WebUtil.FAIL);
                appealNodeResponse.setRspdesc("子节点更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("子节点更新异常", e);
            appealNodeResponse.setRspcode(WebUtil.EXCEPTION);
            appealNodeResponse.setRspdesc("子节点更新异常");
        }
        return appealNodeResponse;
    }
}
