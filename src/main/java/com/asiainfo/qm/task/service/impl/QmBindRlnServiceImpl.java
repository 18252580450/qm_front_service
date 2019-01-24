package com.asiainfo.qm.task.service.impl;

import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.task.dao.QmBindRlnMapper;
import com.asiainfo.qm.task.domain.QmBindRln;
import com.asiainfo.qm.task.domain.QmBindRlnKey;
import com.asiainfo.qm.task.service.QmBindRlnService;
import com.asiainfo.qm.task.vo.QmBindRlnResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：wangcheng.
 * @ Date       ：Created in 14:22 2019/1/16
 * @ Description：${description}
 */
@Service
public class QmBindRlnServiceImpl implements QmBindRlnService {

    private static Logger logger = LoggerFactory.getLogger(QmBindRlnServiceImpl.class);

    @Autowired
    private QmBindRlnMapper qmBindRlnMapper;

    @Autowired
    private SequenceUtils sequenceUtils;

    @Override
    public QmBindRlnResponse deleteByIds(List<Map<String,Object>> list) throws Exception {
        QmBindRlnResponse qmBindRlnResponse = new QmBindRlnResponse();
        try {
            int result = qmBindRlnMapper.deleteByIds(list);
            if(result > 0){
                qmBindRlnResponse.setRspcode(WebUtil.SUCCESS);
                qmBindRlnResponse.setRspdesc("删除成功");
            }else {
                qmBindRlnResponse.setRspcode(WebUtil.FAIL);
                qmBindRlnResponse.setRspdesc("删除失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("删除异常",e);
            qmBindRlnResponse.setRspcode(WebUtil.EXCEPTION);
            qmBindRlnResponse.setRspdesc("删除异常");
        }
        return qmBindRlnResponse;
    }

    @Override
    public QmBindRlnResponse selectByPrimaryKey(QmBindRlnKey qmBindRlnKey){
        QmBindRlnResponse qmBindRlnResponse = new QmBindRlnResponse();
        try {
            int result = qmBindRlnMapper.selectByPrimaryKey(qmBindRlnKey);
            if(result > 0){
                qmBindRlnResponse.setRspcode(WebUtil.SUCCESS);
                qmBindRlnResponse.setRspdesc("查询成功");
            }else {
                qmBindRlnResponse.setRspcode(WebUtil.FAIL);
                qmBindRlnResponse.setRspdesc("查询失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("查询异常",e);
            qmBindRlnResponse.setRspcode(WebUtil.EXCEPTION);
            qmBindRlnResponse.setRspdesc("查询异常");
        }
        return qmBindRlnResponse;
    }
}

