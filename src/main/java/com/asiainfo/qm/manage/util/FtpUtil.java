package com.asiainfo.qm.manage.util;

import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.MalformedURLException;

@Component
public class FtpUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(FtpUtil.class);

    //ftp服务器地址
    @Value("${ftp.hostname}")
    private String hostname;
    //ftp端口号
    @Value("${ftp.port}")
    private String port;
    //ftp登录账号
    @Value("${ftp.username}")
    private String username;
    //ftp登录密码
    @Value("${ftp.password}")
    private String password;
    @Autowired
    private SequenceUtils sequenceUtils;

    /**
     * 初始化ftp服务器
     */
    public FTPClient getFtpClient() {
        FTPClient ftpClient = new FTPClient();
        ftpClient.setControlEncoding("utf-8");
        try {
            LOGGER.info("connecting...ftp服务器:" + hostname + ":" + port);
            ftpClient.connect(hostname, Integer.parseInt(port)); // 连接ftp服务器
            ftpClient.login(username, password); // 登录ftp服务器
            int replyCode = ftpClient.getReplyCode(); // 是否成功登录服务器
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                LOGGER.error("connect failed...ftp服务器:" + hostname + ":" + port);
            }
            LOGGER.info("connect successfu...ftp服务器:" + hostname + ":" + port);
        } catch (MalformedURLException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return ftpClient;
    }


    /**
     * 上传文件
     *
     * @param pathname    ftp服务保存地址
     * @param fileName    上传到ftp的文件名
     * @param inputStream 输入文件流
     * @return
     */
    public boolean uploadFile(FTPClient ftpClient, String pathname, String fileName, InputStream inputStream) {
        boolean flag = false;
        try {
            if (ftpClient.isConnected()) {
                LOGGER.info("开始上传文件:" + fileName);
                ftpClient.setFileType(ftpClient.BINARY_FILE_TYPE);
//                ftpClient.makeDirectory(pathname);
                ftpClient.changeWorkingDirectory(pathname);
                //设置为被动模式(如上传文件夹成功，不能上传文件，注释这行，否则报错refused:connect  )
                ftpClient.enterLocalPassiveMode();
                ftpClient.storeFile(fileName, inputStream);
                inputStream.close();
                ftpClient.logout();
                flag = true;
                LOGGER.info(fileName + "文件上传成功");
            } else {
                LOGGER.error("FTP连接未建立成功");
            }
        } catch (Exception e) {
            LOGGER.error(fileName + "上传文件失败");
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
            closeFtpClient(ftpClient);
            closeStream(inputStream);
        }
        return flag;
    }

    //改变目录路径
    public boolean changeWorkingDirectory(FTPClient ftpClient, String directory) {
        boolean flag = true;
        try {
            flag = ftpClient.changeWorkingDirectory(directory);
            if (flag) {
                LOGGER.info("进入文件夹" + directory + " 成功！");

            } else {
                LOGGER.info("进入文件夹" + directory + " 失败！开始创建文件夹");
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return flag;
    }

    //创建多层目录文件，如果有ftp服务器已存在该文件，则不创建，如果无，则创建
    public boolean CreateDirecroty(FTPClient ftpClient, String remote) throws IOException {
        boolean success = true;
        String directory = remote;
        if (!remote.endsWith(File.separator)) {
            directory = directory + File.separator;
        }
        // 如果远程目录不存在，则递归创建远程服务器目录
        if (!directory.equalsIgnoreCase(File.separator) && !changeWorkingDirectory(ftpClient, new String(directory))) {
            int start = 0;
            int end = 0;
            if (directory.startsWith(File.separator)) {
                start = 1;
            } else {
                start = 0;
            }
            end = directory.indexOf(File.separator, start);
            String path = "";
            StringBuilder paths = new StringBuilder();
            while (true) {
                String subDirectory = new String(remote.substring(start, end).getBytes("GBK"), "iso-8859-1");
                path = path + File.separator + subDirectory;
                if (!existFile(ftpClient, path)) {
                    if (makeDirectory(ftpClient, subDirectory)) {
                        changeWorkingDirectory(ftpClient, subDirectory);
                    } else {
                        LOGGER.error("创建目录[" + subDirectory + "]失败");
                        changeWorkingDirectory(ftpClient, subDirectory);
                    }
                } else {
                    changeWorkingDirectory(ftpClient, subDirectory);
                }
                paths.append(File.separator).append(subDirectory);
                start = end + 1;
                end = directory.indexOf(File.separator, start);
                // 检查所有目录是否创建完毕
                if (end <= start) {
                    break;
                }
            }
        }
        return success;
    }

    //判断ftp服务器文件是否存在
    public boolean existFile(FTPClient ftpClient, String path) throws IOException {
        boolean flag = false;
        FTPFile[] ftpFileArr = ftpClient.listFiles(path);
        if (ftpFileArr.length > 0) {
            flag = true;
        }
        return flag;
    }

    //创建目录
    public boolean makeDirectory(FTPClient ftpClient, String dir) {
        boolean flag = true;
        try {
            flag = ftpClient.makeDirectory(dir);
            if (flag) {
                LOGGER.info("创建文件夹" + dir + " 成功！");

            } else {
                LOGGER.info("创建文件夹" + dir + " 失败！");
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return flag;
    }

    /**
     * 下载文件 *
     *
     * @param pathname  FTP服务器文件目录 *
     * @param filename  文件名称 *
     * @param localpath 下载后的文件路径 *
     * @return
     */
    public boolean downloadFile(FTPClient ftpClient, String pathname, String filename, String localpath) {
        boolean flag = false;
        OutputStream os = null;
        try {
            System.out.println("开始下载文件");
            //切换FTP目录
            ftpClient.changeWorkingDirectory(pathname);
            FTPFile[] ftpFiles = ftpClient.listFiles();
            for (FTPFile file : ftpFiles) {
                if (filename.equalsIgnoreCase(file.getName())) {
                    File localFile = new File(localpath + File.separator + file.getName());
                    os = new FileOutputStream(localFile);
                    ftpClient.retrieveFile(file.getName(), os);
                    os.close();
                }
            }
            ftpClient.logout();
            flag = true;
            LOGGER.info("下载文件成功");
        } catch (Exception e) {
            LOGGER.error("下载文件失败");
            LOGGER.error(e.getMessage(), e);
        } finally {
            closeFtpClient(ftpClient);
            closeStream(os);
        }
        return flag;
    }

    /**
     * 下载文件 *
     *
     * @param pathname FTP服务器文件目录 *
     * @param pathname 文件名称 *
     * @param filename 下载后的文件路径 *
     * @return
     */
    public InputStream download(FTPClient ftpClient, String pathname, String filename) {
        //pathname = "abc/def";
        InputStream InputStream = null;
        try {
            //切换FTP目录
            //ftpClient.changeWorkingDirectory(pathname);
            ftpClient.changeWorkingDirectory("ngkm");
            FTPFile[] ftpFiles = ftpClient.listFiles();
            for (FTPFile file : ftpFiles) {
                if (filename.equalsIgnoreCase(file.getName())) {
                    InputStream = ftpClient.retrieveFileStream(file.getName());
                }
            }
        } catch (Exception e) {
            LOGGER.error("下载文件失败");
            LOGGER.error(e.getMessage(), e);
        }
        return InputStream;
    }

    /**
     * 删除文件 *
     *
     * @param pathname FTP服务器保存目录 *
     * @param filename 要删除的文件名称 *
     * @return
     */
    public boolean deleteFile(String pathname, String filename) {
        boolean flag = false;
        FTPClient ftpClient = getFtpClient();
        try {
            LOGGER.info("开始删除文件");
            if (ftpClient.isConnected()) {
                //切换FTP目录
                ftpClient.changeWorkingDirectory(pathname);
                ftpClient.dele(filename);
                ftpClient.logout();
                flag = true;
                LOGGER.info("删除文件成功");
            } else {
                LOGGER.info("删除文件失败");
            }
        } catch (Exception e) {
            LOGGER.error("删除文件失败");
            LOGGER.error(e.getMessage(), e);
        } finally {
            closeFtpClient(ftpClient);
        }
        return flag;
    }

    public void closeFtpClient(FTPClient ftpClient) {
        if (ftpClient.isConnected()) {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
    }

    public void closeStream(Closeable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            } catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
    }
}
