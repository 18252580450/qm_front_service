package com.asiainfo.qm.execution.service.impl;

import com.asiainfo.qm.execution.domain.QmWorkForm;
import com.asiainfo.qm.execution.service.QmWorkformService;
import com.asiainfo.qm.execution.vo.QmWorkformResponse;
import com.asiainfo.qm.task.domain.QmWorkformExample;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.task.dao.QmWorkformMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2019-03-20 20:06
 * @ Description：${description}
 */

@Service
public class QmWorkformServiceImpl implements QmWorkformService {

    private static Logger logger = LoggerFactory.getLogger(QmWorkformServiceImpl.class);
    @Autowired
    private QmWorkformMapper qmWorkformMapper;

    @Override
    public QmWorkformResponse queryWorkForm(Map params, int start, int limit) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        QmWorkformResponse qmWorkformResponse = null;
        try {
            QmWorkForm qmWorkForm = new QmWorkForm();
            if (null != params.get("wrkfmShowSwftno") && !"".equals(params.get("wrkfmShowSwftno"))) {
                qmWorkForm.setWrkfmShowSwftno((String) params.get("wrkfmShowSwftno"));
            }
            if (null != params.get("acptStaffId") && !"".equals(params.get("acptStaffId"))) {
                qmWorkForm.setAcptStaffId((String) params.get("acptStaffId"));
            }
            if (null != params.get("arcBeginTime") && !"".equals(params.get("arcBeginTime")) && null != params.get("arcEndTime") && !"".equals(params.get("arcEndTime"))) {
                qmWorkForm.setArcBeginTime((String) params.get("arcBeginTime"));
                qmWorkForm.setArcEndTime((String) params.get("arcEndTime"));
            }
            if (null != params.get("custName") && !"".equals(params.get("custName"))) {
                qmWorkForm.setCustName((String) params.get("custName"));
            }
            if (null != params.get("custNum") && !"".equals(params.get("custNum"))) {
                qmWorkForm.setCustNum((String) params.get("custNum"));
            }

            if (0 != limit) {
                PageHelper.offsetPage(start, limit);
                List<QmWorkForm> list = qmWorkformMapper.queryBeyondPlanWorkForm(qmWorkForm);
                Page<QmWorkForm> pagelist = (Page) list;
                qmWorkformResponse = new QmWorkformResponse(pagelist);
            } else {
                qmWorkformResponse = new QmWorkformResponse();
                List<QmWorkForm> list = qmWorkformMapper.queryBeyondPlanWorkForm(qmWorkForm);
                qmWorkformResponse.setData(list);
            }

            if (null != qmWorkformResponse.getData() && qmWorkformResponse.getData().size() > 0) {
                qmWorkformResponse.setRspcode(WebUtil.SUCCESS);
                qmWorkformResponse.setRspdesc("查询成功");
            } else {
                qmWorkformResponse.setRspcode(WebUtil.FAIL);
                qmWorkformResponse.setRspdesc("无数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("工单查询异常", e);
            qmWorkformResponse.setRspcode(WebUtil.EXCEPTION);
            qmWorkformResponse.setRspdesc("工单查询异常");
        }
        return qmWorkformResponse;
    }
}
