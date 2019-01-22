package com.asiainfo.qm.execution.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.execution.service.WrkfmDetailService;
import com.asiainfo.qm.execution.vo.WrkfmDetailResponse;
import com.asiainfo.qm.manage.common.restClient.RestClient;
import com.asiainfo.qm.manage.util.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger = LoggerFactory.getLogger(WrkfmDetailServiceImpl.class);

    @Override
    public WrkfmDetailResponse queryWrkfmDetail(Map params) throws Exception {
        WrkfmDetailResponse wrkfmDetailResponse = new WrkfmDetailResponse();
        try {
            String provCode = params.get("provCode").toString();
            String wrkfmId = params.get("wrkfmId").toString();
            String url = WebUtil.WRKFM_URL + "/tcwf/detail/getDetailMess?provCode=" + provCode + "&wrkfmId=" + wrkfmId;
            RestClient restClient = new RestClient();
            JSONObject rsp = (JSONObject) restClient.callRemoteServicetWithHeader(url, HttpMethod.POST, null, JSONObject.class, null, "1");
            if (rsp.getInteger("status").toString().equals("0")) {
                if (rsp.getJSONObject("rsp").getJSONObject("data") != null) {
                    JSONObject data = rsp.getJSONObject("rsp").getJSONObject("data");
                    wrkfmDetailResponse.setData(data);
                    wrkfmDetailResponse.setRspcode(WebUtil.SUCCESS);
                } else {
                    wrkfmDetailResponse.setRspcode(WebUtil.FAIL);
                    if (rsp.getJSONObject("rsp").getJSONObject("rspDesc") != null) {
                        wrkfmDetailResponse.setRspdesc(rsp.getJSONObject("rsp").getJSONObject("rspDesc").toString());
                    } else {
                        wrkfmDetailResponse.setRspdesc("工单详情查询失败！");
                    }
                }
            } else {
                wrkfmDetailResponse.setRspcode(WebUtil.FAIL);
                wrkfmDetailResponse.setRspdesc("工单详情服务调用失败！");
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
            String url = WebUtil.WRKFM_URL + "/tcwf/detail/procProceLocus";
            RestClient restClient = new RestClient();
            JSONObject rsp = (JSONObject) restClient.callRemoteServicetWithHeader(url, HttpMethod.POST, params, JSONObject.class, null, "1");
            if (rsp.getInteger("status").toString().equals("0")) {
                if (rsp.getJSONObject("rsp").getJSONArray("datas") != null) {
                    JSONArray data = rsp.getJSONObject("rsp").getJSONArray("datas");
                    wrkfmDetailResponse.setDatas(data);
                    wrkfmDetailResponse.setRspcode(WebUtil.SUCCESS);
                } else {
                    wrkfmDetailResponse.setRspcode(WebUtil.FAIL);
                    if (rsp.getJSONObject("rsp").getJSONObject("rspDesc") != null) {
                        wrkfmDetailResponse.setRspdesc(rsp.getJSONObject("rsp").getJSONObject("rspDesc").toString());
                    } else {
                        wrkfmDetailResponse.setRspdesc("工单轨迹查询失败！");
                    }
                }
            } else {
                wrkfmDetailResponse.setRspcode(WebUtil.FAIL);
                wrkfmDetailResponse.setRspdesc("工单轨迹服务调用失败！");
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
            String url = WebUtil.WRKFM_URL + "/tcwf/detail/handingLog?provCode=" + provCode + "&wrkfmId=" + wrkfmId;
            RestClient restClient = new RestClient();
            JSONObject rsp = (JSONObject) restClient.callRemoteServicetWithHeader(url, HttpMethod.POST, null, JSONObject.class, null, "1");
            if (rsp.getInteger("status").toString().equals("0")) {
                if (rsp.getJSONObject("rsp").getJSONObject("data") != null) {
                    JSONObject data = rsp.getJSONObject("rsp").getJSONObject("data");
                    wrkfmDetailResponse.setData(data);
                    wrkfmDetailResponse.setRspcode(WebUtil.SUCCESS);
                } else {
                    wrkfmDetailResponse.setRspcode(WebUtil.FAIL);
                    if (rsp.getJSONObject("rsp").getJSONObject("rspDesc") != null) {
                        wrkfmDetailResponse.setRspdesc(rsp.getJSONObject("rsp").getJSONObject("rspDesc").toString());
                    } else {
                        wrkfmDetailResponse.setRspdesc("内外部回复查询失败！");
                    }
                }
            } else {
                wrkfmDetailResponse.setRspcode(WebUtil.FAIL);
                wrkfmDetailResponse.setRspdesc("内外部回复服务调用失败！");
            }
        } catch (Exception e) {
            logger.error("内外部回复查询异常", e);
            wrkfmDetailResponse.setRspcode(WebUtil.EXCEPTION);
            wrkfmDetailResponse.setRspdesc("内外部回复查询异常");
        }
        return wrkfmDetailResponse;
    }

    @Override
    public WrkfmDetailResponse getHistoryProProce(Map params) throws Exception {
        WrkfmDetailResponse wrkfmDetailResponse = new WrkfmDetailResponse();
        try {
            String url = WebUtil.WRKFM_URL + "/tcwf/detail/historyProProce";
            RestClient restClient = new RestClient();
            JSONObject rsp = (JSONObject) restClient.callRemoteServicetWithHeader(url, HttpMethod.POST, params, JSONObject.class, null, "1");
            if (rsp.getInteger("status").toString().equals("0")) {
                if (rsp.getJSONObject("rsp").getJSONArray("datas") != null) {
                    JSONArray data = rsp.getJSONObject("rsp").getJSONArray("datas");
                    wrkfmDetailResponse.setDatas(data);
                    wrkfmDetailResponse.setRspcode(WebUtil.SUCCESS);
                } else {
                    wrkfmDetailResponse.setRspcode(WebUtil.FAIL);
                    if (rsp.getJSONObject("rsp").getJSONObject("rspDesc") != null) {
                        wrkfmDetailResponse.setRspdesc(rsp.getJSONObject("rsp").getJSONObject("rspDesc").toString());
                    } else {
                        wrkfmDetailResponse.setRspdesc("工单历史查询失败！");
                    }
                }
            } else {
                wrkfmDetailResponse.setRspcode(WebUtil.FAIL);
                wrkfmDetailResponse.setRspdesc("工单历史服务调用失败！");
            }
        } catch (Exception e) {
            logger.error("工单历史查询异常", e);
            wrkfmDetailResponse.setRspcode(WebUtil.EXCEPTION);
            wrkfmDetailResponse.setRspdesc("工单历史查询异常");
        }
        return wrkfmDetailResponse;
    }
}
