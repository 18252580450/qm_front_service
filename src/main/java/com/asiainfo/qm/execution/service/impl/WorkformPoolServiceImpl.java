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
    public WorkformPoolResponse selectByParams(Map params, int start, int limit) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        WorkformPoolResponse workformPoolResponse = null;
        WorkformPoolExample workformPoolExample = new WorkformPoolExample();
        try {
            WorkformPoolExample.Criteria criteria= workformPoolExample.createCriteria();//在运行时动态生成查询语句
            if (null != params.get("wrkfmShowSwftno") && !"".equals(params.get("wrkfmShowSwftno"))) {
                criteria.andWrkfmShowSwftnoEqualTo((String) params.get("wrkfmShowSwftno"));
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
            if (null != params.get("checkLink") && !"".equals(params.get("checkLink"))) {
                criteria.andCheckLinkEqualTo((String) params.get("checkLink"));
            }
            if (null != params.get("checkStaffName") && !"".equals(params.get("checkStaffName"))) {
                criteria.andCheckStaffNameEqualTo((String) params.get("checkStaffName"));
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
//            角色权限：1.话务员只能查询被质检人是自己的信息
//                    2.质检员只能查询质检人是自己的信息
//                    3.管理员可以查询所有的信息
            String permission = "";//用户权限(根据用户权限表获得)
            String staffId ="";//用户Id（前台传递过来的参数）
            if (0 != limit) {
                PageHelper.offsetPage(start, limit);
                List<WorkformPool> list = workformPoolMapper.selectByExample(workformPoolExample);

                List<WorkformPool> listNew = permiFilter(permission,staffId,list);//过滤

                Page<WorkformPool> pagelist = (Page)listNew;
                workformPoolResponse = new WorkformPoolResponse(pagelist);
            } else {
                workformPoolResponse = new WorkformPoolResponse();
                List<WorkformPool> list = workformPoolMapper.selectByExample(workformPoolExample);

                List<WorkformPool> listNew = permiFilter(permission,staffId,list);//过滤

                workformPoolResponse.setData(listNew);
            }

            if(null != workformPoolResponse.getData() && workformPoolResponse.getData().size() > 0){
                workformPoolResponse.setRspcode(WebUtil.SUCCESS);
                workformPoolResponse.setRspdesc("查询成功");
            }else {
                workformPoolResponse.setRspcode(WebUtil.FAIL);
                workformPoolResponse.setRspdesc("无数据");
            }
        }catch (Exception e){
            logger.error("查询异常",e);
            workformPoolResponse.setRspcode(WebUtil.EXCEPTION);
            workformPoolResponse.setRspdesc("查询异常");
        }
        return workformPoolResponse;
    }

    public List<WorkformPool> permiFilter(String permission,String staffId,List<WorkformPool> list){
        List<WorkformPool> listPerm = new ArrayList<>();

        if(permission.equals("checked")){//话务员只能查询被质检人是自己的信息
            for (WorkformPool workformPool : list) {
                if(workformPool.getCheckedStaffId().equals(staffId)){
                    listPerm.add(workformPool);
                }
            }
        }else if(permission.equals("check")){//质检员只能查询质检人是自己的信息
            for (WorkformPool workformPool : list) {
                if(workformPool.getCheckStaffId().equals(staffId)){
                    listPerm.add(workformPool);
                }
            }
        }else{//管理员可以查询所有的信息
            listPerm = list;
        }
        return listPerm;
    }

    @Override
    public WorkformPoolResponse deleteItems(List<String> ids) throws Exception {
        WorkformPoolResponse workformPoolResponse = new WorkformPoolResponse();
        try {
            WorkformPoolExample example = new WorkformPoolExample();
            WorkformPoolExample.Criteria criteria= example.createCriteria();
            criteria.andWrkfmShowSwftnoNotIn(ids);
            int result = workformPoolMapper.deleteByExample(example);
            if(result > 0){
                workformPoolResponse.setRspcode(WebUtil.SUCCESS);
                workformPoolResponse.setRspdesc("删除质检池数据成功");
            }else {
                workformPoolResponse.setRspcode(WebUtil.FAIL);
                workformPoolResponse.setRspdesc("删除质检池数据失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("删除质检池数据异常",e);
            workformPoolResponse.setRspcode(WebUtil.EXCEPTION);
            workformPoolResponse.setRspdesc("删除质检池数据异常");
        }
        return workformPoolResponse;
    }

    @Override
    public WorkformPoolResponse update(@Param("list")List<String> list) throws Exception{
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
    public WorkformPoolResponse updateCheck(List<Map> list) throws Exception{
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

    @Override
    public WorkformPoolResponse updateWorkFormPool(WorkformPool workformPool) throws Exception {
        WorkformPoolResponse workFormPoolResponse = new WorkformPoolResponse();
        try {
            int result = workformPoolMapper.updateByWorkFormId(workformPool);
            if (result > 0) {
                workFormPoolResponse.setRspcode(WebUtil.SUCCESS);
                workFormPoolResponse.setRspdesc("更新成功");
            } else {
                workFormPoolResponse.setRspcode(WebUtil.FAIL);
                workFormPoolResponse.setRspdesc("更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("质检池更新异常", e);
            workFormPoolResponse.setRspcode(WebUtil.EXCEPTION);
            workFormPoolResponse.setRspdesc("质检池更新异常");
        }
        return workFormPoolResponse;
    }

    @Override
    public WorkformPoolResponse recheckUpdate(WorkformPool workformPool) throws Exception {
        WorkformPoolResponse workformPoolResponse = new WorkformPoolResponse();
        try {
            int result = workformPoolMapper.recheckUpdate(workformPool);
            if (result > 0) {
                workformPoolResponse.setRspcode(WebUtil.SUCCESS);
                workformPoolResponse.setRspdesc("更新成功");
            } else {
                workformPoolResponse.setRspcode(WebUtil.FAIL);
                workformPoolResponse.setRspdesc("更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("质检池更新异常", e);
            workformPoolResponse.setRspcode(WebUtil.EXCEPTION);
            workformPoolResponse.setRspdesc("质检池更新异常");
        }
        return workformPoolResponse;
    }
}
