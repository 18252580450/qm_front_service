package com.asiainfo.qm.task.service;

import com.asiainfo.qm.task.domain.QmBindRlnKey;
import com.asiainfo.qm.task.vo.QmBindRlnResponse;

public interface QmBindRlnService {

    QmBindRlnResponse deleteByPrimaryKey(QmBindRlnKey qmBindRlnKey)throws Exception;

    QmBindRlnResponse selectByPrimaryKey(QmBindRlnKey qmBindRlnKey)throws Exception;

    QmBindRlnResponse deleteById(QmBindRlnKey qmBindRlnKey)throws Exception;
}
