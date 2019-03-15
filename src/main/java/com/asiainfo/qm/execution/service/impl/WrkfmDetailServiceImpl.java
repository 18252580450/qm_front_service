package com.asiainfo.qm.execution.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.execution.service.WrkfmDetailService;
import com.asiainfo.qm.execution.vo.WrkfmDetailResponse;
import com.asiainfo.qm.manage.common.restClient.RestClient;
import com.asiainfo.qm.manage.util.HttpConstants;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.Attach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2018-12-30 17:31
 * @ Description：${description}
 */
@Service
public class WrkfmDetailServiceImpl implements WrkfmDetailService {

    @Autowired
    private RestClient restClient;

    private static Logger logger = LoggerFactory.getLogger(WrkfmDetailServiceImpl.class);

    @Override
    public WrkfmDetailResponse queryWrkfmDetail(Map params) throws Exception {
        WrkfmDetailResponse wrkfmDetailResponse = new WrkfmDetailResponse();
        try {
            String provCode = params.get("provCode").toString();
            String wrkfmId = params.get("wrkfmId").toString();
            String url = HttpConstants.HttpParams.WRKFM_URL + "/tcwf/detail/getDetailMess?provCode=" + provCode + "&wrkfmId=" + wrkfmId;
            JSONObject rspRet = (JSONObject) restClient.callRemoteServicetWithHeader(url, HttpMethod.POST, null, JSONObject.class, null, "1");
            if (rspRet.getString("status").equals(HttpConstants.HttpParams.INT_SUCCESS_CODE)) {
                JSONObject rsp = rspRet.getJSONObject("rsp");
                if (rsp.getString("rspCode").equals(WebUtil.SUCCESS)) {
                    if (rsp.getJSONObject("data") != null) {
                        JSONObject data = rsp.getJSONObject("data");
                        wrkfmDetailResponse.setData(data);
                        wrkfmDetailResponse.setRspcode(WebUtil.SUCCESS);
                    } else {
                        wrkfmDetailResponse.setRspcode(WebUtil.FAIL);
                        wrkfmDetailResponse.setRspdesc("无数据");
                    }
                } else {
                    wrkfmDetailResponse.setRspcode(WebUtil.FAIL);
                    if (rsp.getString("rspDesc") != null) {
                        wrkfmDetailResponse.setRspdesc(rsp.getString("rspDesc").toString());
                    } else {
                        wrkfmDetailResponse.setRspdesc("工单详情查询失败！");
                    }
                }
            } else {
                wrkfmDetailResponse.setRspcode(WebUtil.FAIL);
                wrkfmDetailResponse.setRspdesc("工单详情服务调用失败！" + rspRet.getString("msg"));
            }
        } catch (Exception e) {
            logger.error("工单详情查询异常", e);
            wrkfmDetailResponse.setRspcode(WebUtil.EXCEPTION);
            wrkfmDetailResponse.setRspdesc("工单详情查询异常");
        }
        return wrkfmDetailResponse;
    }

    @Override
    public WrkfmDetailResponse getProcProceLocus(Map params) throws Exception {
        WrkfmDetailResponse wrkfmDetailResponse = new WrkfmDetailResponse();
        try {
            String url = HttpConstants.HttpParams.WRKFM_URL + "/tcwf/detail/procProceLocus";
            JSONObject rspRet = (JSONObject) restClient.callRemoteServicetWithHeader(url, HttpMethod.POST, params, JSONObject.class, null, "1");
            if (rspRet.getString("status").equals(HttpConstants.HttpParams.INT_SUCCESS_CODE)) {
                JSONObject rsp = rspRet.getJSONObject("rsp");
                if (rsp.getString("rspCode").equals(WebUtil.SUCCESS)) {
                    if (rsp.getJSONArray("datas") != null) {
                        JSONArray data = rsp.getJSONArray("datas");
                        wrkfmDetailResponse.setDatas(data);
                        wrkfmDetailResponse.setRspcode(WebUtil.SUCCESS);
                    } else {
                        wrkfmDetailResponse.setRspcode(WebUtil.FAIL);
                        wrkfmDetailResponse.setRspdesc("无数据");
                    }
                } else {
                    wrkfmDetailResponse.setRspcode(WebUtil.FAIL);
                    if (rsp.getString("rspDesc") != null) {
                        wrkfmDetailResponse.setRspdesc(rsp.getString("rspDesc").toString());
                    } else {
                        wrkfmDetailResponse.setRspdesc("工单轨迹查询失败！");
                    }
                }
            } else {
                wrkfmDetailResponse.setRspcode(WebUtil.FAIL);
                wrkfmDetailResponse.setRspdesc("工单轨迹服务调用失败！" + rspRet.getString("msg"));
            }
        } catch (Exception e) {
            logger.error("工单轨迹查询异常", e);
            wrkfmDetailResponse.setRspcode(WebUtil.EXCEPTION);
            wrkfmDetailResponse.setRspdesc("工单轨迹查询异常");
        }
        return wrkfmDetailResponse;
    }

    @Override
    public WrkfmDetailResponse getHandingLog(Map params) throws Exception {
        WrkfmDetailResponse wrkfmDetailResponse = new WrkfmDetailResponse();
        try {
            String provCode = params.get("provCode").toString();
            String wrkfmId = params.get("wrkfmId").toString();
            String url = HttpConstants.HttpParams.WRKFM_URL + "/tcwf/detail/handingLog?provCode=" + provCode + "&wrkfmId=" + wrkfmId;
            JSONObject rspRet = (JSONObject) restClient.callRemoteServicetWithHeader(url, HttpMethod.POST, null, JSONObject.class, null, "1");
            if (rspRet.getString("status").equals(HttpConstants.HttpParams.INT_SUCCESS_CODE)) {
                JSONObject rsp = rspRet.getJSONObject("rsp");
                if (rsp.getString("rspCode").equals(WebUtil.SUCCESS)) {
                    if (rsp.getJSONObject("data") != null) {
                        JSONObject data = rsp.getJSONObject("data");
                        wrkfmDetailResponse.setData(data);
                        wrkfmDetailResponse.setRspcode(WebUtil.SUCCESS);
                    } else {
                        wrkfmDetailResponse.setRspcode(WebUtil.FAIL);
                        wrkfmDetailResponse.setRspdesc("无数据");
                    }
                } else {
                    wrkfmDetailResponse.setRspcode(WebUtil.FAIL);
                    if (rsp.getString("rspDesc") != null) {
                        wrkfmDetailResponse.setRspdesc(rsp.getString("rspDesc").toString());
                    } else {
                        wrkfmDetailResponse.setRspdesc("内外部回复查询失败！");
                    }
                }
            } else {
                wrkfmDetailResponse.setRspcode(WebUtil.FAIL);
                wrkfmDetailResponse.setRspdesc("内外部回复服务调用失败！" + rspRet.getString("msg"));
            }
        } catch (Exception e) {
            logger.error("内外部回复查询异常", e);
            wrkfmDetailResponse.setRspcode(WebUtil.EXCEPTION);
            wrkfmDetailResponse.setRspdesc("内外部回复查询异常");
        }
        return wrkfmDetailResponse;
    }

    @Override
    public WrkfmDetailResponse getRecordList(Map params) throws Exception {
        WrkfmDetailResponse wrkfmDetailResponse = new WrkfmDetailResponse();
        try {
            String url = HttpConstants.HttpParams.WRKFM_URL + "/tcwf/queryRecord/queryRecordList";
            JSONObject rspRet = (JSONObject) restClient.callRemoteServicetWithHeader(url, HttpMethod.POST, params, JSONObject.class, null, "1");
            if (rspRet.getString("status").equals(HttpConstants.HttpParams.INT_SUCCESS_CODE)) {
                JSONObject rsp = rspRet.getJSONObject("rsp");
                if (rsp.getString("rspCode").equals(WebUtil.SUCCESS)) {
                    if (rsp.getJSONArray("datas") != null) {
                        JSONArray data = rsp.getJSONArray("datas");
                        wrkfmDetailResponse.setDatas(data);
                        wrkfmDetailResponse.setRspcode(WebUtil.SUCCESS);
                    } else {
                        wrkfmDetailResponse.setRspcode(WebUtil.FAIL);
                        wrkfmDetailResponse.setRspdesc("无数据");
                    }
                    Object total = rsp.getJSONObject("attach").get("total");
                    wrkfmDetailResponse.setAttach(new Attach(total != null ? Long.parseLong(total.toString()) : 0L));
                } else {
                    wrkfmDetailResponse.setRspcode(WebUtil.FAIL);
                    if (rsp.getString("rspDesc") != null) {
                        wrkfmDetailResponse.setRspdesc(rsp.getString("rspDesc").toString());
                    } else {
                        wrkfmDetailResponse.setRspdesc("接触记录查询失败！");
                    }
                }
            } else {
                wrkfmDetailResponse.setRspcode(WebUtil.FAIL);
                wrkfmDetailResponse.setRspdesc("接触记录服务调用失败！" + rspRet.getString("msg"));
            }
        } catch (Exception e) {
            logger.error("接触记录查询异常", e);
            wrkfmDetailResponse.setRspcode(WebUtil.EXCEPTION);
            wrkfmDetailResponse.setRspdesc("接触记录查询异常");
        }
        return wrkfmDetailResponse;
    }

    @Override
    public WrkfmDetailResponse getHistoryProProce(Map params) throws Exception {
        WrkfmDetailResponse wrkfmDetailResponse = new WrkfmDetailResponse();
        try {
            String url = HttpConstants.HttpParams.WRKFM_URL + "/tcwf/detail/historyProProce";
            JSONObject rspRet = (JSONObject) restClient.callRemoteServicetWithHeader(url, HttpMethod.POST, params, JSONObject.class, null, "1");
            if (rspRet.getString("status").equals(HttpConstants.HttpParams.INT_SUCCESS_CODE)) {
                JSONObject rsp = rspRet.getJSONObject("rsp");
                if (rsp.getString("rspCode").equals(WebUtil.SUCCESS)) {
                    if (rsp.getJSONArray("datas") != null) {
                        JSONArray data = rsp.getJSONArray("datas");
                        wrkfmDetailResponse.setDatas(data);
                        wrkfmDetailResponse.setRspcode(WebUtil.SUCCESS);
                    } else {
                        wrkfmDetailResponse.setRspcode(WebUtil.FAIL);
                        wrkfmDetailResponse.setRspdesc("无数据");
                    }
                    Object total = rsp.getJSONObject("attach").get("total");
                    wrkfmDetailResponse.setAttach(new Attach(total != null ? Long.parseLong(total.toString()) : 0L));
                } else {
                    wrkfmDetailResponse.setRspcode(WebUtil.FAIL);
                    if (rsp.getString("rspDesc") != null) {
                        wrkfmDetailResponse.setRspdesc(rsp.getString("rspDesc").toString());
                    } else {
                        wrkfmDetailResponse.setRspdesc("工单历史查询失败！");
                    }
                }
            } else {
                wrkfmDetailResponse.setRspcode(WebUtil.FAIL);
                wrkfmDetailResponse.setRspdesc("工单历史服务调用失败！" + rspRet.getString("msg"));
            }
        } catch (Exception e) {
            logger.error("工单历史查询异常", e);
            wrkfmDetailResponse.setRspcode(WebUtil.EXCEPTION);
            wrkfmDetailResponse.setRspdesc("工单历史查询异常");
        }
        return wrkfmDetailResponse;
    }
}
