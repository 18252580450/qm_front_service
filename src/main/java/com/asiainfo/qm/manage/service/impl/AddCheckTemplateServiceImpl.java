package com.asiainfo.qm.manage.service.impl;

import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.dao.TemplateDetailMapper;
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
    private SequenceUtils sequenceUtils;

//    @Override
//    public List<CheckItem> queryCheckItem(Map params) throws Exception {
//        CheckItemExample example = new CheckItemExample();
//
//            CheckItemExample.Criteria criteria = example.createCriteria();
//            if(null != params.get("tenantId") && !"".equals(params.get("tenantId"))){
//                criteria.andTenantIdEqualTo((String)params.get("tenantId"));
//            }
//            List<CheckItem> list = checkItemMapper.selectByExample(example);
//
//        return list;
//    }

    @Override
    public TemplateDetailResponse insertTempDetail(List<TemplateDetail> list) throws Exception{
        int result = 0;
        TemplateDetailResponse templateDetailResponse = new TemplateDetailResponse();
        try {
            for(TemplateDetail t : list) {//循环插入
                t.setCrtTime(DateUtil.getCurrontTime());
                result =  templateDetailMapper.insertSelective(t);
            }
//            int result = templateDetailMapper.insertSelective(templateDetail);
            if(result > 0){
                templateDetailResponse.setRspcode(WebUtil.SUCCESS);
                templateDetailResponse.setRspdesc("新增成功");
            }else {
                templateDetailResponse.setRspcode(WebUtil.FAIL);
                templateDetailResponse.setRspdesc("新增失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("新增异常",e);
            templateDetailResponse.setRspcode(WebUtil.EXCEPTION);
            templateDetailResponse.setRspdesc("新增异常");
        }
        return  templateDetailResponse;
    }

    @Override
    public TemplateDetailResponse selectByParams(Map params, int start, int limit) throws Exception{
        TemplateDetailResponse templateDetailResponse = null;
        TemplateDetailExample example = new TemplateDetailExample();
        try {
            TemplateDetailExample.Criteria criteria= example.createCriteria();//在运行时动态生成查询语句
			criteria.andTenantIdEqualTo((String) params.get("tenantId"));
            if(null != params.get("templateId")&& !"".equals(params.get("templateId"))){
//                JSONObject jsonObject = (JSONObject) params.get("templateId");
//                criteria.andTemplateIdEqualTo(jsonObject.getString("templateId"));
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
        TemplateDetailResponse templateDetailResponse = new TemplateDetailResponse();
        try {
            TemplateDetailExample example = new TemplateDetailExample();
            TemplateDetailExample.Criteria criteria= example.createCriteria();
            criteria.andTemplateIdIn(ids);
            int result = templateDetailMapper.deleteByExample(example);
            if(result > 0){
                templateDetailResponse.setRspcode(WebUtil.SUCCESS);
                templateDetailResponse.setRspdesc("删除成功");
            }else {
                templateDetailResponse.setRspcode(WebUtil.FAIL);
                templateDetailResponse.setRspdesc("删除失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("删除异常",e);
            templateDetailResponse.setRspcode(WebUtil.EXCEPTION);
            templateDetailResponse.setRspdesc("删除异常");
        }
        return templateDetailResponse;
    }
    @Override
    public TemplateDetailResponse update(List<Map> list) throws Exception{
        TemplateDetailResponse templateDetailResponse = new TemplateDetailResponse();
        int result = 0;
        try {
            for(Map map : list) {//循环更新
                result = templateDetailMapper.update(map);
            }
//            int result = templateDetailMapper.update(list);
            if (result > 0) {
                templateDetailResponse.setRspcode(WebUtil.SUCCESS);
                templateDetailResponse.setRspdesc("操作成功");
            } else {
                templateDetailResponse.setRspcode(WebUtil.FAIL);
                templateDetailResponse.setRspdesc("操作失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("操作异常", e);
            templateDetailResponse.setRspcode(WebUtil.EXCEPTION);
            templateDetailResponse.setRspdesc("操作异常");
        }
        return templateDetailResponse;
    }

    @Override
    public TemplateDetailResponse deleteByPrimaryKey(TemplateDetailKey templateDetailKey) throws Exception{
        TemplateDetailResponse templateDetailResponse = new TemplateDetailResponse();
        try {
            int result = templateDetailMapper.deleteByPrimaryKey(templateDetailKey);
            if(result > 0){
                templateDetailResponse.setRspcode(WebUtil.SUCCESS);
                templateDetailResponse.setRspdesc("删除成功");
            }else {
                templateDetailResponse.setRspcode(WebUtil.FAIL);
                templateDetailResponse.setRspdesc("删除失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("删除异常",e);
            templateDetailResponse.setRspcode(WebUtil.EXCEPTION);
            templateDetailResponse.setRspdesc("删除异常");
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
}

