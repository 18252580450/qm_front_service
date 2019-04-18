package com.asiainfo.qm.execution.service.impl;

import com.asiainfo.qm.execution.dao.VoicePoolMapper;
import com.asiainfo.qm.execution.domain.VoicePool;
import com.asiainfo.qm.execution.domain.VoicePoolExample;
import com.asiainfo.qm.execution.service.VoicePoolService;
import com.asiainfo.qm.execution.vo.VoicePoolResponse;
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
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：wangcheng.
 * @ Date       ：Created in 14:22 2018/12/11
 * @ Description：${description}
 */
@Service
public class VoicePoolServiceImpl implements VoicePoolService {

    private static Logger logger = LoggerFactory.getLogger(VoicePoolServiceImpl.class);

    @Autowired
    private VoicePoolMapper voicePoolMapper;

    @Autowired
    private SequenceUtils sequenceUtils;

    @Override
    public VoicePoolResponse selectByParams(Map params, int start, int limit) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        VoicePoolResponse voicePoolResponse = null;
        VoicePoolExample example = new VoicePoolExample();
        try {
            VoicePoolExample.Criteria criteria = example.createCriteria();//在运行时动态生成查询语句
            if (null != params.get("touchId") && !"".equals(params.get("touchId"))) {
                criteria.andTouchIdLike("%" + (String) params.get("touchId") + "%");  //模糊查询
            }
            if (null != params.get("planId") && !"".equals(params.get("planId"))) {
                criteria.andPlanIdEqualTo((String) params.get("planId"));
            }
            if (null != params.get("isOperate") && !"".equals(params.get("isOperate"))) {
                criteria.andIsOperateEqualTo((String) params.get("isOperate"));
            }
            if (null != params.get("userPermission") && !"".equals(params.get("userPermission")) && (params.get("userPermission")).equals("checker")) {//查询质检员是本身和未分配质检员的数据
                if (!"0".equals(params.get("isOperate"))) {//质检员选择全部显示自己信息和未分配数据，选择已分配显示自己的数据
                    criteria.andCheckStaffIdEqualTo((String) params.get("checkStaffId"));
                    if (!"1".equals(params.get("isOperate"))) {//显示自己信息和未分配数据
                        VoicePoolExample.Criteria criteria2 = example.createCriteria();//在运行时动态生成查询语句
                        criteria2.andCheckStaffIdIsNull();
                        example.or(criteria2);//and和or联合查询
                    }
                } else {//质检员角色选择未分配,显示未分配数据
                    criteria.andCheckStaffIdIsNull();
                }
            } else { //管理员
                if (null != params.get("checkStaffId") && !"".equals(params.get("checkStaffId"))) {
                    criteria.andCheckStaffIdEqualTo((String) params.get("checkStaffId"));
                }
            }
            if (null != params.get("checkedStaffId") && !"".equals(params.get("checkedStaffId"))) {
                criteria.andCheckedStaffIdEqualTo((String) params.get("checkedStaffId"));
            }
            if (null != params.get("hungupType") && !"".equals(params.get("hungupType"))) {
                criteria.andHungupTypeEqualTo((String) params.get("hungupType"));
            }
            if (null != params.get("extractBeginTime") && !"".equals(params.get("extractBeginTime")) && null != params.get("extractEndTime") && !"".equals(params.get("extractEndTime"))) {
                criteria.andCheckedTimeBetween(sdf.parse((String) params.get("extractBeginTime")), sdf.parse((String) params.get("extractEndTime")));
            }
            if (null != params.get("callType") && !"".equals(params.get("callType"))) {
                criteria.andCallTypeEqualTo((String) params.get("callType"));
            }
            if (null != params.get("srvReqstTypeId") && !"".equals(params.get("srvReqstTypeId"))) {
                criteria.andSrvReqstTypeIdEqualTo((String) params.get("srvReqstTypeId"));
            }
            //质检状态，区分已质检和未质检数据
            if (null != params.get("poolStatus") && !"".equals(params.get("poolStatus"))) {
                criteria.andPoolStatusEqualTo(Integer.parseInt((String) params.get("poolStatus")));
            }
            //排序（默认按抽取时间降序）
            if (null != params.get("orderMethod") && !"".equals(params.get("orderMethod"))) {
                example.setOrderByClause("OPERATE_TIME desc");
            } else {
                example.setOrderByClause("CHECKED_TIME desc");
            }
            if (0 != limit) {
                PageHelper.offsetPage(start, limit);
                List<VoicePool> list = voicePoolMapper.selectByExample(example);
                Page<VoicePool> pagelist = (Page) list;
                voicePoolResponse = new VoicePoolResponse(pagelist);
            } else {
                voicePoolResponse = new VoicePoolResponse();
                List<VoicePool> list = voicePoolMapper.selectByExample(example);
                voicePoolResponse.setData(list);
            }
            if (null != voicePoolResponse.getData() && voicePoolResponse.getData().size() > 0) {
                voicePoolResponse.setRspcode(WebUtil.SUCCESS);
                voicePoolResponse.setRspdesc("查询成功");
            } else {
                voicePoolResponse.setRspcode(WebUtil.FAIL);
                voicePoolResponse.setRspdesc("无数据");
            }
        } catch (Exception e) {
            logger.error("查询异常", e);
            voicePoolResponse.setRspcode(WebUtil.EXCEPTION);
            voicePoolResponse.setRspdesc("查询异常");
        }
        return voicePoolResponse;
    }

    @Override
    public VoicePoolResponse update(@Param("list") List<String> list) throws Exception {
        VoicePoolResponse voicePoolResponse = new VoicePoolResponse();
        try {
            int result = voicePoolMapper.update(list);
            if (result > 0) {
                voicePoolResponse.setRspcode(WebUtil.SUCCESS);
                voicePoolResponse.setRspdesc("操作成功");
            } else {
                voicePoolResponse.setRspcode(WebUtil.FAIL);
                voicePoolResponse.setRspdesc("操作失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("操作异常", e);
            voicePoolResponse.setRspcode(WebUtil.EXCEPTION);
            voicePoolResponse.setRspdesc("操作异常");
        }
        return voicePoolResponse;
    }

    @Override
    public VoicePoolResponse updateCheck(List<Map> list) throws Exception {
        VoicePoolResponse voicePoolResponse = new VoicePoolResponse();
        try {
            int result = voicePoolMapper.updateCheck(list);
            if (result > 0) {
                voicePoolResponse.setRspcode(WebUtil.SUCCESS);
                voicePoolResponse.setRspdesc("操作成功");
            } else {
                voicePoolResponse.setRspcode(WebUtil.FAIL);
                voicePoolResponse.setRspdesc("操作失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("操作异常", e);
            voicePoolResponse.setRspcode(WebUtil.EXCEPTION);
            voicePoolResponse.setRspdesc("操作异常");
        }
        return voicePoolResponse;
    }
}

