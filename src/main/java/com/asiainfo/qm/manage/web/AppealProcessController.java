package com.asiainfo.qm.manage.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.domain.AppealNode;
import com.asiainfo.qm.manage.domain.AppealProcess;
import com.asiainfo.qm.manage.service.AppealNodeService;
import com.asiainfo.qm.manage.service.AppealProcessService;
import com.asiainfo.qm.manage.util.DateUtil;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.*;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 15:13 2018/11/8
 * @ Description：${description}
 */
@RestController
@RequestMapping("/qm/configservice/appealProcess/")
public class AppealProcessController {
    // 创建Logger实例
    private static Logger logger = LoggerFactory.getLogger(AppealProcessController.class);

    @Autowired
    private AppealProcessService appealProcessService;
    @Autowired
    private AppealNodeService appealNodeService;
    @Autowired
    private SequenceUtils sequenceUtils;

    @ApiOperation(value = "前端调用接口查询申诉流程", notes = "qm_configservice查询申诉流程", response = AppealProcessServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "queryAppealProcess", threadPoolKey = "queryAppealProcessThread", fallbackMethod = "fallbackQueryAppealProcess", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/queryAppealProcess", method = RequestMethod.GET)
    public AppealProcessServiceResponse queryAppealProcess(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        AppealProcessResponse appealProcessResponse = new AppealProcessResponse();
        AppealProcessServiceResponse appealProcessServiceResponse = new AppealProcessServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            appealProcessResponse = appealProcessService.queryAppealProcess(reqParams, start, limit);
        } catch (Exception e) {
            logger.error("申诉流程数据查询异常", e);
            appealProcessResponse.setRspcode(WebUtil.EXCEPTION);
            appealProcessResponse.setRspdesc("申诉流程数据查询异常!");
        }
        appealProcessServiceResponse.setResponse(appealProcessResponse);
        return appealProcessServiceResponse;
    }

    public AppealProcessServiceResponse fallbackQueryAppealProcess(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        logger.info("申诉流程数据查询出错啦！");
        logger.error("");
        return new AppealProcessServiceResponse();
    }

    @ApiOperation(value = "前端调用接口新增申诉流程", notes = "qm_configservice新增申诉流程", response = AppealProcessServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "createAppealProcess", threadPoolKey = "createAppealProcessThread", fallbackMethod = "fallbackCreateAppealProcess", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public AppealProcessServiceResponse createAppealProcess(@RequestBody Map<String, Object> reqMap) throws Exception {
        AppealProcessResponse appealProcessResponse = new AppealProcessResponse();
        AppealProcessServiceResponse appealProcessServiceResponse = new AppealProcessServiceResponse();
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
            appealProcessResponse = appealProcessService.addAppealProcess(appealProcesses);
            //新增节点（流程新增成功之后）
            if (appealProcessResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                if (!appealNodes.isEmpty()) {
                    AppealNodeResponse appealNodeResponse = appealNodeService.addAppealNode(appealNodes);
                    //新增节点失败
                    if (appealNodeResponse.getRspcode().equals(WebUtil.FAIL)) {
                        appealProcessResponse.setRspcode(WebUtil.FAIL);
                        appealProcessResponse.setRspdesc("新增失败");
                    }
                }
            }
        } catch (Exception e) {
            logger.error("申诉流程新增异常", e);
            appealProcessResponse.setRspcode(WebUtil.EXCEPTION);
            appealProcessResponse.setRspdesc("申诉流程新增异常!");
        }
        appealProcessServiceResponse.setResponse(appealProcessResponse);
        return appealProcessServiceResponse;
    }

    public AppealProcessServiceResponse fallbackCreateAppealProcess(@RequestBody Map<String, Object> reqMap) throws Exception {
        logger.info("申诉流程新增出错啦！");
        logger.error("");
        return new AppealProcessServiceResponse();
    }

    @ApiOperation(value = "前端调用接口修改申诉流程", notes = "qm_configservice修改申诉流程", response = AppealProcessServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "updateAppealProcess", threadPoolKey = "updateAppealProcessThread", fallbackMethod = "fallbackUpdateAppealProcess", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public AppealProcessServiceResponse updateAppealProcess(@RequestBody Map<String, Object> reqMap) throws Exception {
        AppealProcessResponse appealProcessResponse = new AppealProcessResponse();
        AppealNodeResponse appealNodeResponse = new AppealNodeResponse();
        AppealProcessServiceResponse appealProcessServiceResponse = new AppealProcessServiceResponse();
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
            String rspCode = WebUtil.SUCCESS;
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
                appealNodeResponse = appealNodeService.deleteAppealNode(null, nodeDelList);
                rspCode = appealNodeResponse.getRspcode();
            }

            //子节点修改（已有子流程的已有子节点）
            if (!nodeUpdateData.isEmpty() && rspCode.equals(WebUtil.SUCCESS)) {
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
                appealNodeResponse = appealNodeService.updateAppealNode(nodeUpdateList);
                rspCode = appealNodeResponse.getRspcode();
            }

            //子节点新增（已有子流程的新增节点）
            if (!nodeAddData.isEmpty() && rspCode.equals(WebUtil.SUCCESS)) {
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
                appealNodeResponse = appealNodeService.addAppealNode(nodeAddList);
                rspCode = appealNodeResponse.getRspcode();
            }

            //子流程删除（删除子流程及该流程下的所有子节点）
            if (!processDelData.isEmpty() && rspCode.equals(WebUtil.SUCCESS)) {
                List<AppealProcess> processIdList = new ArrayList<AppealProcess>();
                for (Map data : processDelData
                ) {
                    AppealProcess appealProcess = new AppealProcess();
                    appealProcess.setProcessId(data.get("processId").toString());
                    appealProcess.setSubNodeNum(Integer.parseInt(data.get("subNodeNum").toString()));
                    processIdList.add(appealProcess);
                }
                appealProcessResponse = appealProcessService.deleteSubProcess(processIdList);
                rspCode = appealProcessResponse.getRspcode();
            }

            //子流程修改
            if (!processUpdateData.isEmpty() && rspCode.equals(WebUtil.SUCCESS)) {
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
                appealProcessResponse = appealProcessService.updateAppealProcess(processesUpdateList);
                rspCode = appealProcessResponse.getRspcode();
            }

            //子流程新增（包括新增子流程的子节点新增）
            if (!processAddData.isEmpty() && rspCode.equals(WebUtil.SUCCESS)) {
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
                appealProcessResponse = appealProcessService.addAppealProcess(processAddList);
                rspCode = appealProcessResponse.getRspcode();
                //新增节点（流程新增成功之后）
                if (rspCode.equals(WebUtil.SUCCESS)) {
                    if (!nodeAddList.isEmpty()) {
                        appealNodeResponse = appealNodeService.addAppealNode(nodeAddList);
                        rspCode = appealNodeResponse.getRspcode();
                    }
                }
            }
            //修改成功
            if (rspCode.equals(WebUtil.SUCCESS)) {
                appealProcessResponse.setRspcode(WebUtil.SUCCESS);
                appealProcessResponse.setRspdesc("修改成功");
            } else { //修改失败
                appealProcessResponse.setRspcode(WebUtil.FAIL);
                appealProcessResponse.setRspdesc("修改失败");
            }
        } catch (Exception e) {
            logger.error("申诉流程更新异常", e);
            appealProcessResponse.setRspcode(WebUtil.EXCEPTION);
            appealProcessResponse.setRspdesc("申诉流程更新异常!");
        }
        appealProcessServiceResponse.setResponse(appealProcessResponse);
        return appealProcessServiceResponse;
    }

    public AppealProcessServiceResponse fallbackUpdateAppealProcess(@RequestBody Map<String, Object> reqMap) throws Exception {
        logger.info("申诉流程更新出错啦！");
        logger.error("");
        return new AppealProcessServiceResponse();
    }

    @ApiOperation(value = "前端调用接口删除主流程", notes = "qm_configservice删除主流程", response = AppealProcessServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "deleteAppealProcess", threadPoolKey = "deleteAppealProcessThread", fallbackMethod = "fallbackDeleteAppealProcess", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/{delArr}", method = RequestMethod.DELETE)
    public AppealProcessServiceResponse deleteAppealProcess(@PathVariable("delArr") String delArr) throws Exception {
        AppealProcessResponse appealProcessResponse = new AppealProcessResponse();
        AppealProcessServiceResponse appealProcessServiceResponse = new AppealProcessServiceResponse();
        List<String> idlList = Arrays.asList(delArr.split(","));
        try {
            appealProcessResponse = appealProcessService.deleteMainProcess(idlList);
        } catch (Exception e) {
            logger.error("主流程数据删除异常", e);
            appealProcessResponse.setRspcode(WebUtil.EXCEPTION);
            appealProcessResponse.setRspdesc("主流程数据删除异常!");
        }
        appealProcessServiceResponse.setResponse(appealProcessResponse);
        return appealProcessServiceResponse;
    }

    public AppealProcessServiceResponse fallbackDeleteAppealProcess(@RequestParam(name = "delArr") String delArr) throws Exception {
        logger.info("主流程数据删除出错啦！");
        logger.error("");
        return new AppealProcessServiceResponse();
    }

    @ApiOperation(value = "前端调用接口修改流程状态", notes = "qm_configservice修改流程状态", response = AppealProcessServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "changeProcessStatus", threadPoolKey = "changeProcessStatusThread", fallbackMethod = "fallbackChangeProcessStatus", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/changeProcessStatus", method = RequestMethod.PUT)
    public AppealProcessServiceResponse changeProcessStatus(@RequestBody List<AppealProcess> processList) throws Exception {
        AppealProcessResponse appealProcessResponse = new AppealProcessResponse();
        AppealProcessServiceResponse appealProcessServiceResponse = new AppealProcessServiceResponse();
        String processStatus = processList.get(0).getProcessStatus();
        try {
            appealProcessResponse = appealProcessService.changeProcessStatus(processList, processStatus);
        } catch (Exception e) {
            logger.error("流程状态更新异常", e);
            appealProcessResponse.setRspcode(WebUtil.EXCEPTION);
            appealProcessResponse.setRspdesc("流程状态更新异常!");
        }
        appealProcessServiceResponse.setResponse(appealProcessResponse);
        return appealProcessServiceResponse;
    }

    public AppealProcessServiceResponse fallbackChangeProcessStatus(@RequestBody List<AppealProcess> processList) throws Exception {
        logger.info("流程状态更新出错啦！");
        logger.error("");
        return new AppealProcessServiceResponse();
    }
}
