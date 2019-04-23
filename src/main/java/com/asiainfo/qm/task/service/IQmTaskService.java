package com.asiainfo.qm.task.service;

/**
 * Created by shiying on 2019/1/14.
 */
public interface IQmTaskService {

    public boolean querySynchroVoices (String startTime,String endTime,int pageNum);

    public boolean downloadRecordFiles(String startTime, String endTime);

    public boolean queryScore(String startTime, String endTime) throws Exception;

    public boolean querySynchroWorkforms(String startTime,String endTime);
}
