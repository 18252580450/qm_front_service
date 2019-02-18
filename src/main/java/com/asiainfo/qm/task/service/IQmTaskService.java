package com.asiainfo.qm.task.service;

/**
 * Created by shiying on 2019/1/14.
 */
public interface IQmTaskService {

    public boolean doSynchroVoices (int pageNum);

    public boolean downloadRecordFiles();

    public boolean queryScore() throws Exception;
}
