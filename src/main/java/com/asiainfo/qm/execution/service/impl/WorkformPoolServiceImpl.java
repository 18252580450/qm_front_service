package com.asiainfo.qm.execution.service.impl;

import com.asiainfo.qm.execution.dao.WorkformPoolMapper;
import com.asiainfo.qm.execution.domain.WorkformPool;
import com.asiainfo.qm.execution.domain.WorkformPoolExample;
import com.asiainfo.qm.execution.service.WorkformPoolService;
import com.asiainfo.qm.execution.vo.WorkformPoolResponse;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.util.WebUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：wangcheng.
 * @ Date       ：Created in 14:22 2018/12/1
 * @ Description：${description}
 */
@Service
public class WorkformPoolServiceImpl implements WorkformPoolService {

    private static Logger logger = LoggerFactory.getLogger(WorkformPoolServiceImpl.class);

    @Autowired
    private WorkformPoolMapper workformPoolMapper;

    @Autowired
    private SequenceUtils sequenceUtils;

    @Override
    public WorkformPoolResponse selectByParams(Map params, int start, int limit) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        WorkformPoolResponse workformPoolResponse = null;
        WorkformPoolExample workformPoolExample = new WorkformPoolExample();
        try {
            WorkformPoolExample.Criteria criteria = workformPoolExample.createCriteria();//在运行时动态生成查询语句
            if (null != params.get("wrkfmShowSwftno") && !"".equals(params.get("wrkfmShowSwftno"))) {
                criteria.andWrkfmShowSwftnoLike("%" + (String) params.get("wrkfmShowSwftno") + "%");  //模糊查询
            }
            if (null != params.get("planId") && !"".equals(params.get("planId"))) {
                criteria.andPlanIdEqualTo((String) params.get("planId"));
            }
            if (null != params.get("srvReqstTypeId") && !"".equals(params.get("srvReqstTypeId"))) {
                criteria.andSrvReqstTypeIdEqualTo((String) params.get("srvReqstTypeId"));
            }
            if (null != params.get("poolStatus") && !"".equals(params.get("poolStatus"))) {
                criteria.andPoolStatusEqualTo(Integer.parseInt((String) params.get("poolStatus")));
            }
            if (null != params.get("isOperate") && !"".equals(params.get("isOperate"))) {
                criteria.andIsOperateEqualTo((String) params.get("isOperate"));
            }
            if (null != params.get("custNum") && !"".equals(params.get("custNum"))) {
                criteria.andCustNumEqualTo((String) params.get("custNum"));
            }
            if (null != params.get("userPermission") && !"".equals(params.get("userPermission")) && (params.get("userPermission")).equals("checker")) {//查询质检员是本身和未分配质检员的数据
                List<String> list = new ArrayList<>();
                list.add((String) params.get("checkStaffId"));
                list.add("");
                criteria.andCheckStaffIdIn(list);
            } else {
                if (null != params.get("checkStaffId") && !"".equals(params.get("checkStaffId"))) {
                    criteria.andCheckStaffIdEqualTo((String) params.get("checkStaffId"));
                }
            }
            if (null != params.get("planStartTime") && !"".equals(params.get("planStartTime")) && null != params.get("planEndTime") && !"".equals(params.get("planEndTime"))) {
                criteria.andCrtTimeBetween(sdf.parse((String) params.get("planStartTime")), sdf.parse((String) params.get("planEndTime")));
            }
            if (null != params.get("planStartTime") && !"".equals(params.get("planStartTime")) && null != params.get("planEndTime") && !"".equals(params.get("planEndTime"))) {
                criteria.andArcTimeBetween(sdf.parse((String) params.get("planStartTime")), sdf.parse((String) params.get("planEndTime")));
            }
            if (null != params.get("operateTimeBegin") && !"".equals(params.get("operateTimeBegin")) && null != params.get("operateTimeEnd") && !"".equals(params.get("operateTimeEnd"))) {
                criteria.andOperateTimeBetween(sdf.parse((String) params.get("operateTimeBegin")), sdf.parse((String) params.get("operateTimeEnd")));
            }

            //排序（默认按抽取时间降序）
            if (null != params.get("orderMethod") && !"".equals(params.get("orderMethod"))) {
                workformPoolExample.setOrderByClause("OPERATE_TIME desc");
            } else {
                workformPoolExample.setOrderByClause("CHECKED_TIME desc");
            }

            if (0 != limit) {
                PageHelper.offsetPage(start, limit);
                List<WorkformPool> list = workformPoolMapper.selectByExample(workformPoolExample);
                for (WorkformPool workformPool : list) {
                    workformPool.setWorkFormId(String.valueOf(workformPool.getWrkfmId()));
                }

                Page<WorkformPool> pagelist = (Page) list;
                workformPoolResponse = new WorkformPoolResponse(pagelist);
            } else {
                workformPoolResponse = new WorkformPoolResponse();
                List<WorkformPool> list = workformPoolMapper.selectByExample(workformPoolExample);
                for (WorkformPool workformPool : list) {
                    workformPool.setWorkFormId(String.valueOf(workformPool.getWrkfmId()));
                }
                workformPoolResponse.setData(list);
            }

            if (null != workformPoolResponse.getData() && workformPoolResponse.getData().size() > 0) {
                workformPoolResponse.setRspcode(WebUtil.SUCCESS);
                workformPoolResponse.setRspdesc("查询成功");
            } else {
                workformPoolResponse.setRspcode(WebUtil.FAIL);
                workformPoolResponse.setRspdesc("无数据");
            }
        } catch (Exception e) {
            logger.error("查询异常", e);
            workformPoolResponse.setRspcode(WebUtil.EXCEPTION);
            workformPoolResponse.setRspdesc("查询异常");
        }
        return workformPoolResponse;
    }

    @Override
    public WorkformPoolResponse update(@Param("list") List<String> list) throws Exception {
        WorkformPoolResponse workformPoolResponse = new WorkformPoolResponse();
        try {
            int result = workformPoolMapper.update(list);
            if (result > 0) {
                workformPoolResponse.setRspcode(WebUtil.SUCCESS);
                workformPoolResponse.setRspdesc("操作成功");
            } else {
                workformPoolResponse.setRspcode(WebUtil.FAIL);
                workformPoolResponse.setRspdesc("操作失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("操作异常", e);
            workformPoolResponse.setRspcode(WebUtil.EXCEPTION);
            workformPoolResponse.setRspdesc("操作异常");
        }
        return workformPoolResponse;
    }

    @Override
    public WorkformPoolResponse updateCheck(List<Map> list) throws Exception {
        WorkformPoolResponse workformPoolResponse = new WorkformPoolResponse();
        try {
            int result = workformPoolMapper.updateCheck(list);
            if (result > 0) {
                workformPoolResponse.setRspcode(WebUtil.SUCCESS);
                workformPoolResponse.setRspdesc("操作成功");
            } else {
                workformPoolResponse.setRspcode(WebUtil.FAIL);
                workformPoolResponse.setRspdesc("操作失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("操作异常", e);
            workformPoolResponse.setRspcode(WebUtil.EXCEPTION);
            workformPoolResponse.setRspdesc("操作异常");
        }
        return workformPoolResponse;
    }
}
