package com.asiainfo.qm.manage.util;

/**
 * Created by shiying on 2019/1/29.
 */
public class HttpConstants {

    public interface HttpParams{
        String  URI = "http://221.226.14.187:48989";
        //接口调用成功编码
        String CODE_SUCCESS = "0";
        //企业ID
        String ENT_ID = "0251210001";
        //明细数据查询
        String SESSION_DETAIL_QUERY = "/standardInterface_yx/mvc/sessionDetail/query";
        //录音数据查询
        String RECORD_DETAIL_QUERY = "/standardInterface_yx/mvc/recordDetail/query";
        //满意度数据查询
        String TSRVA_DETAIL_QUERY = "/standardInterface_yx/mvc/tsrvaDetail/query";
        //录音文件远程地址
        String REMOTE_PATH = "http://221.226.14.187:48989/dcmsRecord_yx/doublingRecord/";
        //本地物理路径
        String LOCAL_PATH = "/root/ctcqm/files/";
//        String LOCAL_PATH = "E:\\logs";
        //本地远程路径
        String NEW_REMOTE_PATH = "http://203.57.228.52:9002";
        //虚拟组人员接口
        String VIRTUAL_GROUP_PERSONAL_SERVLET = "http://203.57.226.107:3506/VirtualGroupPersonalServlet";
        //虚拟组列表接口
        String VIRTUAL_GROUP_SERVLET = "http://203.57.226.107:3505/VirtualGroupServlet";
        //工单接口
        String WRKFM_URL = "http://203.57.227.53:8082";
    }
}
