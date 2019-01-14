package com.asiainfo.qm.manage.web;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.manage.domain.CheckItem;
import com.asiainfo.qm.manage.service.CheckItemDetailService;
import com.asiainfo.qm.manage.service.CheckItemService;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.CheckItemDetailResponse;
import com.asiainfo.qm.manage.vo.CheckItemDetailServiceResponse;
import com.asiainfo.qm.manage.vo.CheckItemResponse;
import com.asiainfo.qm.manage.vo.CheckItemServiceResponse;
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
 * @ Date       ：Created in 10:18 2018/11/2
 * @ Description：${description}
 */
@RestController
@RequestMapping("/qm/configservice/checkItem/")
public class CheckItemController {
    // 创建Logger实例
    private static Logger logger = LoggerFactory.getLogger(CheckItemController.class);

    @Autowired
    private CheckItemService checkItemService;
    @Autowired
    private CheckItemDetailService checkItemDetailService;

    @ApiOperation(value = "前端调用接口查询考评项", notes = "qm_configservice查询考评项", response = CheckItemServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "queryCheckItem", threadPoolKey = "queryCheckItemThread", fallbackMethod = "fallbackQueryCheckItem", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/queryCheckItem", method = RequestMethod.GET)
    public CheckItemServiceResponse queryCheckItem(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        CheckItemResponse checkItemResponse = new CheckItemResponse();
        CheckItemServiceResponse checkItemServiceResponse = new CheckItemServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            checkItemResponse = checkItemService.queryCheckItem(reqParams, start, limit);
        } catch (Exception e) {
            logger.error("考评项数据查询异常", e);
            checkItemResponse.setRspcode(WebUtil.EXCEPTION);
            checkItemResponse.setRspdesc("考评项数据查询异常!");
        }
        checkItemServiceResponse.setResponse(checkItemResponse);
        return checkItemServiceResponse;
    }

    public CheckItemServiceResponse fallbackQueryCheckItem(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        logger.info("考评项数据查询出错啦！");
        logger.error("");
        return new CheckItemServiceResponse();
    }

    @ApiOperation(value = "前端调用接口新增考评项", notes = "qm_configservice新增考评项", response = CheckItemServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "createCheckItem", threadPoolKey = "createCheckItemThread", fallbackMethod = "fallbackCreateCheckItem", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public CheckItemServiceResponse createCheckItem(@RequestBody CheckItem checkItem) throws Exception {
        CheckItemResponse checkItemResponse = new CheckItemResponse();
        CheckItemServiceResponse checkItemServiceResponse = new CheckItemServiceResponse();
        try {
            checkItemResponse = checkItemService.createCheckItem(checkItem);
        } catch (Exception e) {
            logger.error("考评项数据新增异常", e);
            checkItemResponse.setRspcode(WebUtil.EXCEPTION);
            checkItemResponse.setRspdesc("考评项数据新增异常!");
        }
        checkItemServiceResponse.setResponse(checkItemResponse);
        return checkItemServiceResponse;
    }

    public CheckItemServiceResponse fallbackCreateCheckItem(@RequestBody CheckItem checkItem) throws Exception {
        logger.info("考评项数据新增出错啦！");
        logger.error("");
        return new CheckItemServiceResponse();
    }

    @ApiOperation(value = "前端调用接口修改考评项", notes = "qm_configservice修改考评项", response = CheckItemServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "updateCheckItem", threadPoolKey = "updateCheckItemThread", fallbackMethod = "fallbackUpdateCheckItem", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public CheckItemServiceResponse updateCheckItem(@RequestBody CheckItem checkItem) throws Exception {
        CheckItemResponse checkItemResponse = new CheckItemResponse();
        CheckItemServiceResponse checkItemServiceResponse = new CheckItemServiceResponse();
        try {
            checkItemResponse = checkItemService.updateCheckItem(checkItem);
        } catch (Exception e) {
            logger.error("考评项数据更新异常", e);
            checkItemResponse.setRspcode(WebUtil.EXCEPTION);
            checkItemResponse.setRspdesc("考评项数据更新异常!");
        }
        checkItemServiceResponse.setResponse(checkItemResponse);
        return checkItemServiceResponse;
    }

    public CheckItemServiceResponse fallbackUpdateCheckItem(@RequestBody CheckItem checkItem) throws Exception {
        logger.info("考评项数据更新出错啦！");
        logger.error("");
        return new CheckItemServiceResponse();
    }

    @ApiOperation(value = "前端调用接口删除考评项", notes = "qm_configservice删除考评项", response = CheckItemServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "deleteCheckItem", threadPoolKey = "deleteCheckItemThread", fallbackMethod = "fallbackDeleteCheckItem", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/{delArr}", method = RequestMethod.DELETE)
    public CheckItemServiceResponse deleteCheckItem(@PathVariable("delArr") String delArr) throws Exception {
        CheckItemResponse checkItemResponse = new CheckItemResponse();
        CheckItemServiceResponse checkItemServiceResponse = new CheckItemServiceResponse();
        List<String> idlList = Arrays.asList(delArr.split(","));
        try {
            String rspCode = WebUtil.SUCCESS;
            List<String> realDelIdList = new ArrayList<>();   //实际需要删除的所有考评项ID集合
            //查询所有要删除的考评项id
            for (String checkItemId : idlList
            ) {
                Map<String, String> params = new HashMap<String, String>();
                params.put("parentCheckItemId", checkItemId);

                checkItemResponse = checkItemService.queryCheckItem(params, 0, 0);

                rspCode = checkItemResponse.getRspcode();
                if (null != checkItemResponse.getData() && checkItemResponse.getData().size() > 0) {
                    for (CheckItem checkItem : checkItemResponse.getData()
                    ) {
                        realDelIdList.add(checkItem.getCheckItemId());
                    }
                }
                if (rspCode.equals(WebUtil.EXCEPTION)) {
                    checkItemResponse.setRspcode(WebUtil.FAIL);
                    checkItemResponse.setRspdesc("删除失败");
                    break;
                }
            }
            realDelIdList.addAll(idlList);
            HashSet<String> set = new HashSet<>(realDelIdList);
            realDelIdList.clear();
            realDelIdList.addAll(set);
            if (!rspCode.equals(WebUtil.EXCEPTION)) {
                checkItemResponse = checkItemService.deleteCheckItem(realDelIdList);
            }
        } catch (Exception e) {
            logger.error("考评项数据删除异常", e);
            checkItemResponse.setRspcode(WebUtil.EXCEPTION);
            checkItemResponse.setRspdesc("考评项数据删除异常!");
        }
        checkItemServiceResponse.setResponse(checkItemResponse);
        return checkItemServiceResponse;
    }

    public CheckItemServiceResponse fallbackDeleteCheckItem(@RequestParam(name = "delArr") String delArr) throws Exception {
        logger.info("考评项数据删除出错啦！");
        logger.error("");
        return new CheckItemServiceResponse();
    }

    @ApiOperation(value = "前端调用接口查询考评项详情", notes = "qm_configservice查询考评项详情", response = CheckItemDetailServiceResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 401, message = "服务器认证失败"),
            @ApiResponse(code = 403, message = "资源不存在"),
            @ApiResponse(code = 404, message = "传入的参数无效"),
            @ApiResponse(code = 500, message = "服务器出现异常错误")})
    @HystrixCommand(groupKey = "qm_configservice ", commandKey = "queryCheckItemDetail", threadPoolKey = "queryCheckItemDetailThread", fallbackMethod = "fallbackQueryCheckItemDetail", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "2000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "200")})
    @RequestMapping(value = "/queryCheckItemDetail", method = RequestMethod.GET)
    public CheckItemDetailServiceResponse queryCheckItemDetail(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        CheckItemDetailResponse checkItemDetailResponse = new CheckItemDetailResponse();
        CheckItemDetailServiceResponse checkItemDetailServiceResponse = new CheckItemDetailServiceResponse();
        Map reqParams = JSONObject.parseObject(params);
        try {
            checkItemDetailResponse = checkItemDetailService.queryCheckItemDetail(reqParams, start, limit);
        } catch (Exception e) {
            logger.error("考评项详情数据查询异常", e);
            checkItemDetailResponse.setRspcode(WebUtil.EXCEPTION);
            checkItemDetailResponse.setRspdesc("考评项详情数据查询异常!");
        }
        checkItemDetailServiceResponse.setResponse(checkItemDetailResponse);
        return checkItemDetailServiceResponse;
    }

    public CheckItemDetailServiceResponse fallbackQueryCheckItemDetail(@RequestParam(name = "params") String params, @RequestParam(name = "start") int start, @RequestParam(name = "pageNum") int limit) throws Exception {
        logger.info("考评项详情数据查询出错啦！");
        logger.error("");
        return new CheckItemDetailServiceResponse();
    }
}
