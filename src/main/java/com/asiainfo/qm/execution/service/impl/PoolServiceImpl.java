package com.asiainfo.qm.execution.service.impl;

import com.asiainfo.qm.execution.dao.PoolMapper;
import com.asiainfo.qm.execution.domain.Pool;
import com.asiainfo.qm.execution.domain.PoolExample;
import com.asiainfo.qm.execution.service.PoolService;
import com.asiainfo.qm.execution.vo.PoolResponse;
import com.asiainfo.qm.execution.vo.PoolServiceResponse;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.domain.TemplateDetail;
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
 * @ Date       ：Created in 14:22 2018/11/1
 * @ Description：${description}
 */
@Service
public class PoolServiceImpl implements PoolService {

    private static Logger logger = LoggerFactory.getLogger(PoolServiceImpl.class);

    @Autowired
    private PoolMapper poolMapper;

    @Autowired
    private SequenceUtils sequenceUtils;

    @Override
    public PoolResponse selectByParams(Map params, int start, int limit) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        PoolResponse poolResponse = null;
        PoolExample example = new PoolExample();
        try {
            PoolExample.Criteria criteria= example.createCriteria();//在运行时动态生成查询语句
            if (null != params.get("workformId") && !"".equals(params.get("workformId"))) {
                criteria.andWorkformIdEqualTo((String) params.get("workformId"));
            }
            if (null != params.get("planId") && !"".equals(params.get("planId"))) {
                criteria.andPlanIdEqualTo((String) params.get("planId"));
            }
            if (null != params.get("srvReqstTypeId") && !"".equals(params.get("srvReqstTypeId"))) {
                criteria.andSrvReqstTypeIdEqualTo((String) params.get("srvReqstTypeId"));
            }
            if (null != params.get("poolStatus") && !"".equals(params.get("poolStatus"))) {
                criteria.andPoolStatusEqualTo((String) params.get("poolStatus"));
            }
            if (null != params.get("checkLink") && !"".equals(params.get("checkLink"))) {
                criteria.andCheckLinkEqualTo((String) params.get("checkLink"));
            }
            if (null != params.get("operateStaffId") && !"".equals(params.get("operateStaffId"))) {
                criteria.andOperateStaffIdEqualTo((String) params.get("operateStaffId"));
            }
            if (null != params.get("planStartTime") && !"".equals(params.get("planStartTime")) && null != params.get("planEndTime") && !"".equals(params.get("planEndTime"))) {
                criteria.andCrtTimeBetween(sdf.parse((String) params.get("planStartTime")), sdf.parse((String) params.get("planEndTime")));
            }
            if (null != params.get("distStartTime") && !"".equals(params.get("distStartTime")) && null != params.get("distEndTime") && !"".equals(params.get("distEndTime"))) {
                criteria.andOperateTimeBetween(sdf.parse((String) params.get("distStartTime")), sdf.parse((String) params.get("distEndTime")));
            }

            if (0 != limit) {
                PageHelper.offsetPage(start, limit);
                List<Pool> list = poolMapper.selectByExample(example);
                Page<Pool> pagelist = (Page)list;
                poolResponse = new PoolResponse(pagelist);
            } else {
                poolResponse = new PoolResponse();
                List<Pool> list = poolMapper.selectByExample(example);
                poolResponse.setData(list);
            }

            if(null != poolResponse.getData() && poolResponse.getData().size() > 0){
                poolResponse.setRspcode(WebUtil.SUCCESS);
                poolResponse.setRspdesc("查询成功");
            }else {
                poolResponse.setRspcode(WebUtil.FAIL);
                poolResponse.setRspdesc("无数据");
            }
        }catch (Exception e){
            logger.error("查询异常",e);
            poolResponse.setRspcode(WebUtil.EXCEPTION);
            poolResponse.setRspdesc("查询异常");
        }
        return poolResponse;
    }

    @Override
    public PoolResponse deleteItems(List<String> ids) throws Exception {
        PoolResponse poolResponse = new PoolResponse();
        try {
            PoolExample example = new PoolExample();
            PoolExample.Criteria criteria= example.createCriteria();
            criteria.andPlanIdIn(ids);
            int result = poolMapper.deleteByExample(example);
            if(result > 0){
                poolResponse.setRspcode(WebUtil.SUCCESS);
                poolResponse.setRspdesc("删除质检池数据成功");
            }else {
                poolResponse.setRspcode(WebUtil.FAIL);
                poolResponse.setRspdesc("删除质检池数据失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("删除质检池数据异常",e);
            poolResponse.setRspcode(WebUtil.EXCEPTION);
            poolResponse.setRspdesc("删除质检池数据异常");
        }
        return poolResponse;
    }
}

