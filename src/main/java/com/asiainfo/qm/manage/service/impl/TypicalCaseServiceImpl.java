package com.asiainfo.qm.manage.service.impl;

import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.dao.TypicalCaseMapper;
import com.asiainfo.qm.manage.domain.TypicalCaseExample;
import com.asiainfo.qm.manage.domain.TypicalCase;
import com.asiainfo.qm.manage.service.TypicalCaseService;
import com.asiainfo.qm.manage.util.Constants;
import com.asiainfo.qm.manage.util.DateUtil;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.TypicalCaseResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 2019-04-09 11:07
 * @ Description：${description}
 */
@Service
public class TypicalCaseServiceImpl implements TypicalCaseService {

    private static Logger logger = LoggerFactory.getLogger(TypicalCaseServiceImpl.class);

    @Autowired
    private TypicalCaseMapper typicalCaseMapper;

    @Autowired
    private SequenceUtils sequenceUtils;

    @Override
    public TypicalCaseResponse queryTypicalCase(Map params, int start, int limit) throws Exception {
        TypicalCaseResponse typicalCaseResponse = null;
        TypicalCaseExample example = new TypicalCaseExample();
        try {
            TypicalCaseExample.Criteria criteria = example.createCriteria();
            if (null != params.get("checkType") && !"".equals(params.get("checkType"))) {
                criteria.andCheckTypeEqualTo((String) params.get("checkType"));
            }
            if (null != params.get("caseType") && !"".equals(params.get("caseType"))) {
                criteria.andCaseTypeEqualTo((String) params.get("caseType"));
            }

            if (0 != limit) {
                PageHelper.offsetPage(start, limit);
                List<TypicalCase> list = typicalCaseMapper.selectByCaseType(example);
                Page<TypicalCase> pagelist = (Page) list;
                typicalCaseResponse = new TypicalCaseResponse(pagelist);
            } else {
                typicalCaseResponse = new TypicalCaseResponse();
                List<TypicalCase> list = typicalCaseMapper.selectByCaseType(example);
                typicalCaseResponse.setData(list);
            }

            if (null != typicalCaseResponse.getData() && typicalCaseResponse.getData().size() > 0) {
                typicalCaseResponse.setRspcode(WebUtil.SUCCESS);
                typicalCaseResponse.setRspdesc("查询成功");
            } else {
                typicalCaseResponse.setRspcode(WebUtil.FAIL);
                typicalCaseResponse.setRspdesc("无数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("典型案例查询异常", e);
            typicalCaseResponse.setRspcode(WebUtil.EXCEPTION);
            typicalCaseResponse.setRspdesc("典型案例查询异常");
        }
        return typicalCaseResponse;
    }

    @Override
    public TypicalCaseResponse queryTypicalCaseDetail(Map params, int start, int limit) throws Exception {
        TypicalCaseResponse typicalCaseResponse = null;
        TypicalCaseExample example = new TypicalCaseExample();
        try {
            TypicalCaseExample.Criteria criteria = example.createCriteria();
            if (null != params.get("checkType") && !"".equals(params.get("checkType"))) {
                criteria.andCheckTypeEqualTo((String) params.get("checkType"));
            }
            if (null != params.get("caseType") && !"".equals(params.get("caseType"))) {
                criteria.andCaseTypeEqualTo((String) params.get("caseType"));
            }
            List<TypicalCase> list = new ArrayList<>();
            if (0 != limit) {
                PageHelper.offsetPage(start, limit);
                if (params.get("checkType").equals(Constants.QM_CHECK_TYPE.VOICE)) {
                    list = typicalCaseMapper.voiceUnionSelectByExample(example);
                } else if (params.get("checkType").equals(Constants.QM_CHECK_TYPE.ORDER)) {
                    list = typicalCaseMapper.orderUnionSelectByExample(example);
                }
                Page<TypicalCase> pagelist = (Page) list;
                typicalCaseResponse = new TypicalCaseResponse(pagelist);
            } else {
                typicalCaseResponse = new TypicalCaseResponse();
                if (params.get("checkType").equals(Constants.QM_CHECK_TYPE.VOICE)) {
                    list = typicalCaseMapper.voiceUnionSelectByExample(example);
                } else if (params.get("checkType").equals(Constants.QM_CHECK_TYPE.ORDER)) {
                    list = typicalCaseMapper.orderUnionSelectByExample(example);
                }
                typicalCaseResponse.setData(list);
            }

            if (null != typicalCaseResponse.getData() && typicalCaseResponse.getData().size() > 0) {
                typicalCaseResponse.setRspcode(WebUtil.SUCCESS);
                typicalCaseResponse.setRspdesc("查询成功");
            } else {
                typicalCaseResponse.setRspcode(WebUtil.FAIL);
                typicalCaseResponse.setRspdesc("无数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("典型案例查询异常", e);
            typicalCaseResponse.setRspcode(WebUtil.EXCEPTION);
            typicalCaseResponse.setRspdesc("典型案例查询异常");
        }
        return typicalCaseResponse;
    }

    @Override
    public TypicalCaseResponse addTypicalCase(TypicalCase typicalCase) throws Exception {
        TypicalCaseResponse typicalCaseResponse = new TypicalCaseResponse();
        TypicalCaseExample example = new TypicalCaseExample();
        //案例id
        String caseId = String.valueOf(sequenceUtils.getSequence("t_qm_typical_case"));
        try {
            TypicalCaseExample.Criteria criteria = example.createCriteria();
//            criteria.andInspectionIdEqualTo(typicalCase.getInspectionId());
            criteria.andTouchIdEqualTo(typicalCase.getTouchId());
            criteria.andCaseTypeEqualTo(typicalCase.getCaseType());
            List<TypicalCase> list = typicalCaseMapper.selectByCaseType(example);
            if (null != list && list.size() > 0) {
                typicalCaseResponse.setRspcode(WebUtil.FAIL);
                typicalCaseResponse.setRspdesc("已添加至典型案例！请勿重复添加");  //同个案例同个类型只能添加一次
                return typicalCaseResponse;
            }
            typicalCase.setCaseId(caseId);
            typicalCase.setCreateTime(DateUtil.getCurrontTime());
            int result = typicalCaseMapper.insertSelective(typicalCase);
            if (result > 0) {
                typicalCaseResponse.setRspcode(WebUtil.SUCCESS);
                typicalCaseResponse.setRspdesc("添加成功");
            } else {
                typicalCaseResponse.setRspcode(WebUtil.FAIL);
                typicalCaseResponse.setRspdesc("添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("典型案例添加异常", e);
            typicalCaseResponse.setRspcode(WebUtil.EXCEPTION);
            typicalCaseResponse.setRspdesc("典型案例添加异常");
        }
        return typicalCaseResponse;
    }

    @Override
    public TypicalCaseResponse deleteTypicalCase(String type, List<String> idList) throws Exception {
        TypicalCaseResponse checkItemResponse = new TypicalCaseResponse();
        try {
            TypicalCaseExample example = new TypicalCaseExample();
            TypicalCaseExample.Criteria criteria = example.createCriteria();
            if (type.equals("0")) {  //删除指定类型案例
                criteria.andCaseTypeIn(idList);
            } else if (type.equals("1")) {  //删除具体案例
                criteria.andCaseIdIn(idList);
            }

            int result = typicalCaseMapper.deleteByExample(example);
            if (result > 0) {
                checkItemResponse.setRspcode(WebUtil.SUCCESS);
                checkItemResponse.setRspdesc("删除成功");
            } else {
                checkItemResponse.setRspcode(WebUtil.FAIL);
                checkItemResponse.setRspdesc("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("案例删除异常", e);
            checkItemResponse.setRspcode(WebUtil.EXCEPTION);
            checkItemResponse.setRspdesc("案例删除异常");
        }
        return checkItemResponse;
    }
}
