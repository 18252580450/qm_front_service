package com.asiainfo.qm.manage.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.dao.TemplateDetailMapper;
import com.asiainfo.qm.manage.dao.TplOpLogMapper;
import com.asiainfo.qm.manage.domain.*;
import com.asiainfo.qm.manage.service.AddCheckTemplateService;
import com.asiainfo.qm.manage.service.CheckItemService;
import com.asiainfo.qm.manage.util.DateUtil;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.TemplateDetailResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：wangcheng.
 * @ Date       ：Created in 14:22 2018/11/1
 * @ Description：${description}
 */
@Service
public class AddCheckTemplateServiceImpl implements AddCheckTemplateService {

    private static Logger logger = LoggerFactory.getLogger(AddCheckTemplateServiceImpl.class);

    @Autowired
    private TemplateDetailMapper templateDetailMapper;
    @Autowired
    private TplOpLogMapper tplOpLogMapper;
    @Autowired
    private SequenceUtils sequenceUtils;

    @Override
    public TemplateDetailResponse insertTempDetail(List<TemplateDetail> list) throws Exception{
        String flag = "0";//操作结果标识（默认成功）
        int result = 0;
        TemplateDetailResponse templateDetailResponse = new TemplateDetailResponse();
        try {
            for(TemplateDetail t : list) {//循环插入
                t.setCrtTime(DateUtil.getCurrontTime());
                result =  templateDetailMapper.insertSelective(t);
            }
            if(result > 0){
                templateDetailResponse.setRspcode(WebUtil.SUCCESS);
                templateDetailResponse.setRspdesc("新增成功");
            }else {
                flag = "1";
                templateDetailResponse.setRspcode(WebUtil.FAIL);
                templateDetailResponse.setRspdesc("新增失败");
            }
        }catch (Exception e){
            flag = "1";
            e.printStackTrace();
            logger.error("新增异常",e);
            templateDetailResponse.setRspcode(WebUtil.EXCEPTION);
            templateDetailResponse.setRspdesc("新增异常");
        }finally {//日志
            Map map = new HashMap();
            map.put("operateStaffId", list.get(0).getCreateStaffId());
            map.put("templateId",list.get(0).getTemplateId());
            map.put("operateType","0");
            map.put("reserve1",flag);
            addTplOpLog(map);
        }
        return  templateDetailResponse;
    }

    @Override
    public TemplateDetailResponse selectByParams(Map params, int start, int limit) throws Exception{
        TemplateDetailResponse templateDetailResponse = null;
        TemplateDetailExample example = new TemplateDetailExample();
        try {
            TemplateDetailExample.Criteria criteria= example.createCriteria();//在运行时动态生成查询语句
            if(null != params.get("templateId")&& !"".equals(params.get("templateId"))){
                criteria.andTemplateIdEqualTo((String) params.get("templateId"));
            }
            if(0 != limit) {
                PageHelper.offsetPage(start, limit);
                List<TemplateDetail> list = templateDetailMapper.selectByExample(example);
                Page<TemplateDetail> pagelist = (Page)list;
                templateDetailResponse = new TemplateDetailResponse(pagelist);
            }else {
                templateDetailResponse = new TemplateDetailResponse();
                List<TemplateDetail> list = templateDetailMapper.selectByExample(example);
                templateDetailResponse.setData(list);
            }

            if(null != templateDetailResponse.getData() && templateDetailResponse.getData().size() > 0){
                templateDetailResponse.setRspcode(WebUtil.SUCCESS);
                templateDetailResponse.setRspdesc("查询成功");
            }else {
                templateDetailResponse.setRspcode(WebUtil.FAIL);
                templateDetailResponse.setRspdesc("无数据");
            }
        }catch (Exception e){
            logger.error("查询异常",e);
            templateDetailResponse.setRspcode(WebUtil.EXCEPTION);
            templateDetailResponse.setRspdesc("查询异常");
        }
        return templateDetailResponse;
    }

    @Override
    public TemplateDetailResponse deleteByIds(List<String> ids) throws Exception {
        String flag = "0";//操作结果标识（默认成功）
        TemplateDetailResponse templateDetailResponse = new TemplateDetailResponse();
        try {
            int result = templateDetailMapper.deleteDetail(ids);
            if(result > 0){
                templateDetailResponse.setRspcode(WebUtil.SUCCESS);
                templateDetailResponse.setRspdesc("删除成功");
            }else {
                flag = "1";
                templateDetailResponse.setRspcode(WebUtil.FAIL);
                templateDetailResponse.setRspdesc("删除失败");
            }
        }catch (Exception e){
            flag = "1";
            e.printStackTrace();
            logger.error("删除异常",e);
            templateDetailResponse.setRspcode(WebUtil.EXCEPTION);
            templateDetailResponse.setRspdesc("删除异常");
        }finally {//日志
            for(int i=0;i<ids.size();i++){
                Map map = new HashMap();
                map.put("operateStaffId", net.sf.json.JSONObject.fromObject(ids.get(i)).get("operateId"));
                map.put("templateId",net.sf.json.JSONObject.fromObject(ids.get(i)).get("templateId"));
                map.put("operateType","2");
                map.put("reserve1",flag);
                addTplOpLog(map);
            }
        }
        return templateDetailResponse;
    }
    @Override
    public TemplateDetailResponse update(List<Map> list) throws Exception{
        String flag = "0";//操作结果标识（默认成功）
        TemplateDetailResponse templateDetailResponse = new TemplateDetailResponse();
        int result = 0;
        try {
            for(Map map : list) {//循环更新
                result = templateDetailMapper.update(map);
            }
            if (result > 0) {
                templateDetailResponse.setRspcode(WebUtil.SUCCESS);
                templateDetailResponse.setRspdesc("操作成功");
            } else {
                flag = "1";
                templateDetailResponse.setRspcode(WebUtil.FAIL);
                templateDetailResponse.setRspdesc("操作失败");
            }
        } catch (Exception e) {
            flag = "1";
            e.printStackTrace();
            logger.error("操作异常", e);
            templateDetailResponse.setRspcode(WebUtil.EXCEPTION);
            templateDetailResponse.setRspdesc("操作异常");
        }finally {//日志
                Map map = new HashMap();
                map.put("operateStaffId", list.get(0).get("reserve1"));
                map.put("templateId",list.get(0).get("templateId"));
                map.put("operateType","1");
                map.put("reserve1",flag);
                addTplOpLog(map);
        }
        return templateDetailResponse;
    }

    @Override
    public TemplateDetailResponse deleteByPrimaryKey(TemplateDetailKey templateDetailKey) throws Exception{
        String flag = "0";//操作结果标识（默认成功）
        TemplateDetailResponse templateDetailResponse = new TemplateDetailResponse();
        try {
            int result = templateDetailMapper.deleteByPrimaryKey(templateDetailKey);
            if(result > 0){
                templateDetailResponse.setRspcode(WebUtil.SUCCESS);
                templateDetailResponse.setRspdesc("删除成功");
            }else {
                flag = "1";
                templateDetailResponse.setRspcode(WebUtil.FAIL);
                templateDetailResponse.setRspdesc("删除失败");
            }
        }catch (Exception e){
            flag = "1";
            e.printStackTrace();
            logger.error("删除异常",e);
            templateDetailResponse.setRspcode(WebUtil.EXCEPTION);
            templateDetailResponse.setRspdesc("删除异常");
        }finally {//日志
            Map map = new HashMap();
            map.put("operateStaffId", templateDetailKey.getReserve1());
            map.put("templateId",templateDetailKey.getTemplateId());
            map.put("operateType","2");
            map.put("reserve1",flag);
            addTplOpLog(map);
        }
        return templateDetailResponse;
    }

    @Override
    public TemplateDetailResponse selectByPrimaryKey(TemplateDetailKey templateDetailKey){
        TemplateDetailResponse templateDetailResponse = new TemplateDetailResponse();
        try {
            List<TemplateDetail> list = templateDetailMapper.selectByPrimaryKey(templateDetailKey);
            if(list.size() > 0){
                templateDetailResponse.setRspcode(WebUtil.SUCCESS);
                templateDetailResponse.setRspdesc("查询成功");
            }else {
                templateDetailResponse.setRspcode(WebUtil.FAIL);
                templateDetailResponse.setRspdesc("查询失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("查询异常",e);
            templateDetailResponse.setRspcode(WebUtil.EXCEPTION);
            templateDetailResponse.setRspdesc("查询异常");
        }
        return templateDetailResponse;
    }

    public void addTplOpLog(Map map)throws Exception{
        TplOpLog tplOpLog = new TplOpLog();
        tplOpLog.setOperateTime(DateUtil.getCurrontTime());//操作时间
        tplOpLog.setOperateStaffId((String) map.get("operateStaffId"));//操作工号
        tplOpLog.setTemplateId((String) map.get("templateId"));//考评模板编码
        tplOpLog.setOperateType((String) map.get("operateType"));//操作类型
        tplOpLog.setReserve1((String) map.get("reserve1"));//操作结果标识
        tplOpLog.setTenantId("10010000");//租户ID
        tplOpLog.setOperateId(String.valueOf(sequenceUtils.getSequence("t_qm_tpl_op_log")));
        tplOpLogMapper.insertSelective(tplOpLog);
    }
}

