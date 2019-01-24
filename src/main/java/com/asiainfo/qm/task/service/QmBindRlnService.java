package com.asiainfo.qm.task.service;

import com.asiainfo.qm.task.domain.QmBindRlnKey;
import com.asiainfo.qm.task.vo.QmBindRlnResponse;

import java.util.List;
import java.util.Map;


public interface QmBindRlnService {

    QmBindRlnResponse deleteByIds(List<Map<String,Object>> list)throws Exception;

    QmBindRlnResponse selectByPrimaryKey(QmBindRlnKey qmBindRlnKey)throws Exception;

}
