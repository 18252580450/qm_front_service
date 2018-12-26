package com.asiainfo.qm.execution.service.impl;

import com.asiainfo.qm.execution.dao.AppealDealMapper;
import com.asiainfo.qm.execution.domain.AppealDeal;
import com.asiainfo.qm.execution.domain.UnionAppealDeal;
import com.asiainfo.qm.execution.service.AppealDealService;
import com.asiainfo.qm.execution.vo.AppealDealResponse;
import com.asiainfo.qm.execution.domain.AppealDealExample;
import com.asiainfo.qm.manage.util.WebUtil;
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
 * @ Date       ：Created in 2018-12-21 14:23
 * @ Description：${description}
 */
@Service
public class AppealDealServiceImpl implements AppealDealService {

    private static Logger logger = LoggerFactory.getLogger(AppealDealServiceImpl.class);

    @Autowired
    private AppealDealMapper appealDealMapper;

    @Override
    public AppealDealResponse queryAppeal(Map params, int start, int limit) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        AppealDealResponse appealDealResponse = null;
        AppealDealExample example = new AppealDealExample();
        String staffId = "";
        if (null != params.get("staffId") && !"".equals(params.get("staffId"))) {
            staffId = (String) params.get("staffId");
        }
        try {
            AppealDealExample.Criteria criteria = example.createCriteria();
            if (null != params.get("checkType") && !"".equals(params.get("checkType"))) {
                criteria.andCheckTypeEqualTo((String) params.get("checkType"));
            }
            if (null != params.get("touchId") && !"".equals(params.get("touchId"))) {
                criteria.andTouchIdEqualTo((String) params.get("touchId"));
            }
            if (null != params.get("inspectionId") && !"".equals(params.get("inspectionId"))) {
                criteria.andInspectionIdEqualTo((String) params.get("inspectionId"));
            }
            if (null != params.get("appealId") && !"".equals(params.get("appealId"))) {
                criteria.andAppealIdEqualTo((String) params.get("appealId"));
            }
            if (null != params.get("appealStaffId") && !"".equals(params.get("appealStaffId"))) {
                criteria.andAppealStaffIdEqualTo((String) params.get("appealStaffId"));
            }
            if (null != params.get("appealTimeBegin") && !"".equals(params.get("appealTimeBegin")) && null != params.get("appealTimeEnd") && !"".equals(params.get("appealTimeEnd"))) {
                criteria.andAppealTimeBetween(sdf.parse((String) params.get("appealTimeBegin")), sdf.parse((String) params.get("appealTimeEnd")));
            }
            List<UnionAppealDeal> list = appealDealMapper.unionSelectByExample(example);
            //根据质检员id筛选
            List<UnionAppealDeal> resultList = new Page<>();
            for (UnionAppealDeal appealDeal : list
            ) {
                if (!staffId.equals("") && !appealDeal.getUserId().equals(staffId)) {
                    continue;
                }
                resultList.add(appealDeal);
            }
            if (0 != limit) {
                PageHelper.offsetPage(start, limit);
                Page<UnionAppealDeal> pagelist = (Page) resultList;
                appealDealResponse = new AppealDealResponse(pagelist);
            } else {
                appealDealResponse = new AppealDealResponse();
                appealDealResponse.setData(resultList);
            }

            if (null != appealDealResponse.getData() && appealDealResponse.getData().size() > 0) {
                appealDealResponse.setRspcode(WebUtil.SUCCESS);
                appealDealResponse.setRspdesc("查询成功");
            } else {
                appealDealResponse.setRspcode(WebUtil.FAIL);
                appealDealResponse.setRspdesc("无数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("申诉流程查询异常", e);
            appealDealResponse.setRspcode(WebUtil.EXCEPTION);
            appealDealResponse.setRspdesc("申诉流程查询异常");
        }
        return appealDealResponse;
    }

    @Override
    public AppealDealResponse createAppeal(AppealDeal appealDeal) throws Exception {
        AppealDealResponse appealDealResponse = new AppealDealResponse();
        try {
            int result = appealDealMapper.insertSelective(appealDeal);
            if (result > 0) {
                appealDealResponse.setRspcode(WebUtil.SUCCESS);
                appealDealResponse.setRspdesc("提交成功");
            } else {
                appealDealResponse.setRspcode(WebUtil.FAIL);
                appealDealResponse.setRspdesc("提交失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("申诉提交异常", e);
            appealDealResponse.setRspcode(WebUtil.EXCEPTION);
            appealDealResponse.setRspdesc("申诉提交异常");
        }
        return appealDealResponse;
    }

    @Override
    public AppealDealResponse updateAppeal(AppealDeal appealDeal) throws Exception {
        AppealDealResponse appealDealResponse = new AppealDealResponse();
        try {
            int result = appealDealMapper.updateByPrimaryKeySelective(appealDeal);
            if (result > 0) {
                appealDealResponse.setRspcode(WebUtil.SUCCESS);
                appealDealResponse.setRspdesc("提交成功");
            } else {
                appealDealResponse.setRspcode(WebUtil.FAIL);
                appealDealResponse.setRspdesc("提交失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("审批异常", e);
            appealDealResponse.setRspcode(WebUtil.EXCEPTION);
            appealDealResponse.setRspdesc("审批异常");
        }
        return appealDealResponse;
    }

    @Override
    public AppealDealResponse deleteAppeal(List<String> idList) throws Exception {
        return null;
    }
}
