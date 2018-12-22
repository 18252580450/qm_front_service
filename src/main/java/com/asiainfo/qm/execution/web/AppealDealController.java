package com.asiainfo.qm.execution.web;

import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.execution.domain.AppealDeal;
import com.asiainfo.qm.execution.service.AppealDealService;
import com.asiainfo.qm.manage.domain.AppealNode;
import com.asiainfo.qm.manage.domain.AppealProcess;
import com.asiainfo.qm.manage.service.AppealNodeService;
import com.asiainfo.qm.manage.service.AppealProcessService;
import com.asiainfo.qm.manage.util.Constants;
import com.asiainfo.qm.manage.util.DateUtil;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.execution.vo.AppealDealResponse;
import com.asiainfo.qm.execution.vo.AppealDealServiceResponse;
import com.asiainfo.qm.manage.vo.AppealNodeResponse;
import com.asiainfo.qm.manage.vo.AppealProcessResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-21 15:08
 * @ Description：${description}
 */
@RestController
@RequestMapping("/qm/configservice/appealDeal/")
public class AppealDealController {

    // 创建Logger实例
    private static Logger logger = LoggerFactory.getLogger(AppealDealController.class);

    @Autowired
    private AppealProcessService appealProcessService;
    @Autowired
    private AppealNodeService appealNodeService;
    @Autowired
    private AppealDealService appealDealService;
    @Autowired
    private SequenceUtils sequenceUtils;

    @ApiOperation(value = "前端调用接口提交申诉", notes = "qm_configservice提交申诉", response = AppealDealServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "createAppealDeal", threadPoolKey = "createAppealDealThread", fallbackMethod = "fallbackCreateAppealDeal", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public AppealDealServiceResponse createAppealDeal(@RequestBody Map<String, Object> reqMap) throws Exception {
        AppealDealResponse appealDealResponse = new AppealDealResponse();
        AppealDealServiceResponse appealDealServiceResponse = new AppealDealServiceResponse();
        //申诉流水号
        String appealId = String.valueOf(sequenceUtils.getSequence("t_qm_appeal_process"));
        String departmentId = reqMap.get("departmentId").toString();
        String mainProcessId = "";      //主流程编码
        String currentProcessId = "";   //当前子流程编码
        int currentNodeId = 0;          //当前子节点编码
        String currentNodeName = "";    //当前子节点名称
        String nextProcessId = "";      //下一子流程编码
        int nextNodeId = 0;             //下一子节点编码
        try {
            String rspCode = WebUtil.SUCCESS;
            //根据申诉人部门id绑定申诉流程
            Map<String, String> mainProcessParams = new HashMap<String, String>();
            mainProcessParams.put("departmentId", departmentId);
            mainProcessParams.put("mainProcessFlag", "0");
            mainProcessParams.put("processStatus", Constants.QM_APPEAL_PROCESS_STATUS.ENABLE);
            //查询主流程
            AppealProcessResponse appealProcessResponse = appealProcessService.queryAppealProcess(mainProcessParams, 0, 0);
            if (!appealProcessResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                rspCode = WebUtil.FAIL;
            }
            if (null != appealProcessResponse.getData() && appealProcessResponse.getData().size() > 0) {
                int processNum = 1;  //主流程的子流程数
                //主流程ID
                mainProcessId = appealProcessResponse.getData().get(0).getProcessId();
                processNum = appealProcessResponse.getData().get(0).getSubProcessNum();
                //查询子流程
                Map<String, String> subProcessParams = new HashMap<String, String>();
                subProcessParams.put("parentProcessId", mainProcessId);
                appealProcessResponse = appealProcessService.queryAppealProcess(subProcessParams, 0, 0);
                if (!appealProcessResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    rspCode = WebUtil.FAIL;
                }
                if (null != appealProcessResponse.getData() && appealProcessResponse.getData().size() > 0) {
                    int nodeNum = 1;   //第一子流程的节点数
                    for (AppealProcess appealProcess : appealProcessResponse.getData()
                    ) {
                        if (appealProcess.getOrderNo() == 1) {
                            //当前子流程ID
                            currentProcessId = appealProcess.getProcessId();
                            nodeNum = appealProcess.getSubNodeNum();
                            break;
                        }
                    }

                    if (nodeNum > 1) {   //第一流程有多个子节点时，下一子流程编码为当前子流程编码
                        nextProcessId = currentProcessId;
                    } else {
                        if (processNum > 1) {  //主流程有多个子流程，且第一子流程只有一个节点
                            for (AppealProcess appealProcess : appealProcessResponse.getData()
                            ) {
                                if (appealProcess.getOrderNo() == 2) {
                                    //下一子流程ID
                                    nextProcessId = appealProcess.getProcessId();
                                    break;
                                }
                            }
                        } else {  //主流程只有一个子流程，且只有一个节点的情况
                            nextProcessId = currentProcessId;
                        }
                    }

                    //查询子节点
                    Map<String, String> nodeParams = new HashMap<String, String>();
                    nodeParams.put("processId", currentProcessId);
                    AppealNodeResponse appealNodeResponse = appealNodeService.queryAppealNode(nodeParams, 0, 0);
                    if (!appealNodeResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                        rspCode = WebUtil.FAIL;
                    }
                    if (null != appealNodeResponse.getData() && appealNodeResponse.getData().size() > 0) {
                        for (AppealNode appealNode : appealNodeResponse.getData()
                        ) {
                            if (appealNode.getOrderNo() == 1) {
                                //当前子节点ID
                                currentNodeId = appealNode.getNodeId();
                                currentNodeName = appealNode.getNodeName();
                                break;
                            }
                        }
                        if (nodeNum > 1) {   //第一流程有多个子节点当情况
                            for (AppealNode appealNode : appealNodeResponse.getData()
                            ) {
                                if (appealNode.getOrderNo() == 2) {
                                    //下一子节点ID
                                    nextNodeId = appealNode.getNodeId();
                                    break;
                                }
                            }
                        } else {
                            if (processNum > 1) {    //主流程有多个子流程，且第一子流程只有一个节点
                                nodeParams.put("processId", nextProcessId);
                                appealNodeResponse = appealNodeService.queryAppealNode(nodeParams, 0, 0);
                                if (!appealNodeResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                                    rspCode = WebUtil.FAIL;
                                }
                                if (null != appealNodeResponse.getData() && appealNodeResponse.getData().size() > 0) {
                                    for (AppealNode appealNode : appealNodeResponse.getData()
                                    ) {
                                        if (appealNode.getOrderNo() == 1) {
                                            //下一子节点ID
                                            nextNodeId = appealNode.getNodeId();
                                            break;
                                        }
                                    }
                                }
                            } else {  //主流程只有一个子流程，且只有一个节点的情况
                                nextNodeId = currentNodeId;
                            }
                        }
                    }
                }
            }

            if(rspCode.equals(WebUtil.SUCCESS)){
                AppealDeal appealDeal = new AppealDeal();
                appealDeal.setCheckType(reqMap.get("checkType").toString());
                appealDeal.setTouchId(reqMap.get("touchId").toString());
                appealDeal.setInspectionId(reqMap.get("inspectionId").toString());
                appealDeal.setAppealId(appealId);
                appealDeal.setAppealStaffId(reqMap.get("appealStaffId").toString());
                appealDeal.setAppealStaffName(reqMap.get("appealStaffName").toString());
                appealDeal.setAppealReason(reqMap.get("appealReason").toString());
                appealDeal.setAppealTime(DateUtil.getCurrontTime());
                appealDeal.setAppealStatus(Constants.QM_APPEAL_STATUS.APPEALING);
                appealDeal.setMainProcessId(mainProcessId);
                appealDeal.setCurrentProcessId(currentProcessId);
                appealDeal.setCurrentNodeId(currentNodeId);
                appealDeal.setCurrentNodeName(currentNodeName);
                appealDeal.setNextProcessId(nextProcessId);
                appealDeal.setNextNodeId(nextNodeId);

                appealDealResponse = appealDealService.createAppeal(appealDeal);
            }
        } catch (Exception e) {
            logger.error("申诉提交异常", e);
            appealDealResponse.setRspcode(WebUtil.EXCEPTION);
            appealDealResponse.setRspdesc("申诉提交异常!");
        }
        appealDealServiceResponse.setResponse(appealDealResponse);
        return appealDealServiceResponse;
    }

    public AppealDealServiceResponse fallbackCreateAppealDeal(@RequestBody Map<String, Object> reqMap) throws Exception {
        logger.info("申诉提交出错啦！");
        logger.error("");
        return new AppealDealServiceResponse();
    }
}
