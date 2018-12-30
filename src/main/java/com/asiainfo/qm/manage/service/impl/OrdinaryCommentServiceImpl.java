package com.asiainfo.qm.manage.service.impl;

import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.dao.OrdinaryCommentMapper;
import com.asiainfo.qm.manage.domain.OrdinaryComment;
import com.asiainfo.qm.manage.domain.OrdinaryCommentExample;
import com.asiainfo.qm.manage.domain.StaticParams;
import com.asiainfo.qm.manage.domain.StaticParamsExample;
import com.asiainfo.qm.manage.service.OrdinaryCommentService;
import com.asiainfo.qm.manage.service.StaticParamsService;
import com.asiainfo.qm.manage.util.DateUtil;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.OrdinaryCommentResponse;
import com.asiainfo.qm.manage.vo.StaticParamsResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class OrdinaryCommentServiceImpl implements OrdinaryCommentService {

	private static Logger logger = LoggerFactory.getLogger(OrdinaryCommentServiceImpl.class);

	@Autowired
	private OrdinaryCommentMapper ordinaryCommentMapper;

	@Autowired
	private SequenceUtils sequenceUtils;

	@Override
	public OrdinaryCommentResponse selectByParams(Map params, int start, int limit) throws Exception  {
		OrdinaryCommentResponse ordinaryCommentResponse = null;
		OrdinaryCommentExample example = new OrdinaryCommentExample();
		try {
			OrdinaryCommentExample.Criteria criteria= example.createCriteria();//在运行时动态生成查询语句
//			criteria.andTenantIdEqualTo((String) params.get("tenantId"));
			if(null != params.get("parentCommentId")&& !"".equals(params.get("parentCommentId"))){
				example.createCriteria().andParentCommentIdEqualTo((String) params.get("parentCommentId"));
			}
			if(null != params.get("commentName") && !"".equals(params.get("commentName"))) {
				criteria.andCommentNameEqualTo((String) params.get("commentName"));
			}

			if (0 != limit) {
				PageHelper.offsetPage(start, limit);
				List<OrdinaryComment> list = ordinaryCommentMapper.selectByExample(example);
				Page<OrdinaryComment> pagelist = (Page)list;
				ordinaryCommentResponse = new OrdinaryCommentResponse(pagelist);
			} else {
				ordinaryCommentResponse = new OrdinaryCommentResponse();
				List<OrdinaryComment> list = ordinaryCommentMapper.selectByExample(example);
				ordinaryCommentResponse.setData(list);
			}

			if(null != ordinaryCommentResponse.getData() && ordinaryCommentResponse.getData().size() > 0){
				ordinaryCommentResponse.setRspcode(WebUtil.SUCCESS);
				ordinaryCommentResponse.setRspdesc("查询成功");
			}else {
				ordinaryCommentResponse.setRspcode(WebUtil.FAIL);
				ordinaryCommentResponse.setRspdesc("无数据");
			}
		}catch (Exception e){
			logger.error("查询异常",e);
			ordinaryCommentResponse.setRspcode(WebUtil.EXCEPTION);
			ordinaryCommentResponse.setRspdesc("查询异常");
		}
		return ordinaryCommentResponse;
	}

	@Override
	public OrdinaryCommentResponse deleteByIds(List<String> ids) throws Exception {
		OrdinaryCommentResponse ordinaryCommentResponse = new OrdinaryCommentResponse();
		try {
			OrdinaryCommentExample example = new OrdinaryCommentExample();
			OrdinaryCommentExample.Criteria criteria= example.createCriteria();
			criteria.andCommentIdIn(ids);
			int result = ordinaryCommentMapper.deleteByExample(example);
			if(result > 0){
				ordinaryCommentResponse.setRspcode(WebUtil.SUCCESS);
				ordinaryCommentResponse.setRspdesc("删除成功");
			}else {
				ordinaryCommentResponse.setRspcode(WebUtil.FAIL);
				ordinaryCommentResponse.setRspdesc("删除失败");
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("删除异常",e);
			ordinaryCommentResponse.setRspcode(WebUtil.EXCEPTION);
			ordinaryCommentResponse.setRspdesc("删除异常");
		}
		return ordinaryCommentResponse;
	}

	@Override
	public OrdinaryCommentResponse updateComment(OrdinaryComment ordinaryComment) throws Exception {
		OrdinaryCommentResponse ordinaryCommentResponse = new OrdinaryCommentResponse();
		try {
			ordinaryComment.setModfTime(DateUtil.getCurrontTime());
			ordinaryComment.setOperateStaffId("9527");//修改工号暂时先写死
			int result = ordinaryCommentMapper.updateByPrimaryKey(ordinaryComment);
			if(result > 0){
				ordinaryCommentResponse.setRspcode(WebUtil.SUCCESS);
				ordinaryCommentResponse.setRspdesc("修改成功");
			}else {
				ordinaryCommentResponse.setRspcode(WebUtil.FAIL);
				ordinaryCommentResponse.setRspdesc("修改失败");
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("修改异常",e);
			ordinaryCommentResponse.setRspcode(WebUtil.EXCEPTION);
			ordinaryCommentResponse.setRspdesc("修改异常");
		}
		return ordinaryCommentResponse;
	}

	@Override
	public OrdinaryCommentResponse insertComment(OrdinaryComment ordinaryComment) throws Exception{
		OrdinaryCommentResponse ordinaryCommentResponse = new OrdinaryCommentResponse();
		try {
			ordinaryComment.setCrtTime(DateUtil.getCurrontTime());
			ordinaryComment.setCommentId(String.valueOf(sequenceUtils.getSequence("t_qm_ordinarycomment")));
			int result = ordinaryCommentMapper.insertSelective(ordinaryComment);
			if(result > 0){
				ordinaryCommentResponse.setRspcode(WebUtil.SUCCESS);
				ordinaryCommentResponse.setRspdesc("新增成功");
			}else {
				ordinaryCommentResponse.setRspcode(WebUtil.FAIL);
				ordinaryCommentResponse.setRspdesc("新增失败");
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("新增异常",e);
			ordinaryCommentResponse.setRspcode(WebUtil.EXCEPTION);
			ordinaryCommentResponse.setRspdesc("新增异常");
		}
		return  ordinaryCommentResponse;
	}
}
