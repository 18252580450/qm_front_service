package com.asiainfo.qm.manage.util;

import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by shiying on 2019/2/15.
 */
@Component
public class FileUtils {

    /**
     * 根据Url下载文件
     * @param urlStr
     * @throws IOException
     */
    public static String  downLoadFromUrl(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(3*1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //得到输入流
        InputStream inputStream = conn.getInputStream();
        //获取数组
        byte[] getData = readInputStream(inputStream);

        //文件保存位置
        File saveDir = new File(HttpConstants.HttpParams.LOCAL_PATH);
        if(!saveDir.exists()){
            saveDir.mkdir();
        }
        String fileName = urlStr.substring(urlStr.lastIndexOf("/"));
        File file = new File(saveDir + File.separator + fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if(fos!=null){
            fos.close();
        }
        if(inputStream!=null){
            inputStream.close();
        }
        System.out.println("info:" + url + " download success");
        return fileName;
    }

    /**
     * 从输入流中获取字节数组
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

    public static void main(String[] args) throws Exception{
        String file = downLoadFromUrl("http://221.226.14.187:48989/dcmsRecord_yx/doublingRecord/record/0251210001/" +
                "Agent/20190220/TEL-01058514085_1012_20190220080226.wav");
        System.out.println("new filename :"+file);
    }
}
