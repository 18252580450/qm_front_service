package com.asiainfo.qm.manage.util;

/**
 * Created by shiying on 2019/1/29.
 */
public class HttpConstants {

    public interface HttpParams{
        String  URI = "http://221.226.14.187:48989";  //青牛
        //接口调用成功编码
        String CODE_SUCCESS = "0";
        //企业ID
        String ENT_ID = "0251210001";
        //
        String TENANT_ID = "10010000";

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
        //ftp服务器录音保存地址
        String FTP_RECORD_PATH = "/home/ftpuser/record_file/";
        //ftp服务器远程访问地址
        String FTP_REMOTE_PATH = "http://10.150.20.28:80/record_file/";
//        String LOCAL_PATH = "E:\\logs";
        //本地远程路径
        String NEW_REMOTE_PATH = "http://203.57.228.52:9002";
        //虚拟组人员接口
        String VIRTUAL_GROUP_PERSONAL_SERVLET = "http://203.57.226.107:3506/VirtualGroupPersonalServlet";
//        String VIRTUAL_GROUP_PERSONAL_SERVLET = "http://10.150.20.26:3506/VirtualGroupPersonalServlet"; //内网
        //虚拟组列表接口
        String VIRTUAL_GROUP_SERVLET = "http://203.57.226.107:3505/VirtualGroupServlet";
//        String VIRTUAL_GROUP_SERVLET = "http://10.150.20.26:3505/VirtualGroupServlet"; //内网
        //工单接口
        String WRKFM_URL = "http://203.57.227.53:8082/tcwfBack";
//        String WRKFM_URL = "http://10.150.20.12:9990/tcwfBack"; //内网
        //工单数据同步接口
        String WRKFM_QUERY = "/tcwf/qualityCheck/getSynchroData";
        //省份编码
        String PROV_CODE = "00030000";
        //工单接口调用成功编码
        String INT_SUCCESS_CODE = "0000";
        //工单调用成功编码
        String SUCCESS_CODE = "1";
    }
}
