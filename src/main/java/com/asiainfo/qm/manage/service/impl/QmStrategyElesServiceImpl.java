package com.asiainfo.qm.manage.service.impl;

import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.dao.QmStrategyElementMapper;
import com.asiainfo.qm.manage.dao.QmStrategyElementRelMapper;
import com.asiainfo.qm.manage.domain.QmStrategyElement;
import com.asiainfo.qm.manage.domain.QmStrategyElementExample;
import com.asiainfo.qm.manage.domain.QmStrategyElementRel;
import com.asiainfo.qm.manage.domain.QmStrategyElementRelExample;
import com.asiainfo.qm.manage.service.QmStrategyElesService;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.QmStrategyElesResponse;
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
 *
 */
@Service
public class QmStrategyElesServiceImpl implements QmStrategyElesService {

	private static Logger logger = LoggerFactory.getLogger(QmStrategyElesServiceImpl.class);

	@Autowired
	private QmStrategyElementMapper qmStrategyElementMapper;

	@Autowired
	private QmStrategyElementRelMapper qmStrategyElementRelMapper;

	@Autowired
	private SequenceUtils sequenceUtils;

	@Override
	public QmStrategyElesResponse selectByParams(Map params,int start,int limit) throws Exception  {
		QmStrategyElesResponse qmStrategyElesResponse = null;
		QmStrategyElementExample example = new QmStrategyElementExample();
		try {
			QmStrategyElementExample.Criteria criteria= example.createCriteria();
			criteria.andTenantIdEqualTo((String) params.get("tenantId"));
			if(null != params.get("paramsTypeId")&& !"".equals(params.get("paramsTypeId"))){
				criteria.andParamsTypeIdEqualTo((String) params.get("paramsTypeId"));
			}
			if(0 != limit) {
				PageHelper.offsetPage(start, limit);
				List<QmStrategyElement> list = qmStrategyElementMapper.selectByExample(example);
				Page<QmStrategyElement> pagelist = (Page) list;
				qmStrategyElesResponse = new QmStrategyElesResponse(pagelist);
			}else {
				qmStrategyElesResponse = new QmStrategyElesResponse();
				List<QmStrategyElement> list = qmStrategyElementMapper.selectByExample(example);
				qmStrategyElesResponse.setData(list);
			}

			if(null != qmStrategyElesResponse.getData() && qmStrategyElesResponse.getData().size() > 0){
				qmStrategyElesResponse.setRspcode(WebUtil.SUCCESS);
				qmStrategyElesResponse.setRspdesc("查询成功");
			}else {
				qmStrategyElesResponse.setRspcode(WebUtil.FAIL);
				qmStrategyElesResponse.setRspdesc("无数据");
			}
		}catch (Exception e){
			logger.error("查询异常",e);
			qmStrategyElesResponse.setRspcode(WebUtil.EXCEPTION);
			qmStrategyElesResponse.setRspdesc("查询异常");
		}
		return qmStrategyElesResponse;
	}

	@Override
	public QmStrategyElesResponse deleteByIds(List<String> ids) throws Exception {
		QmStrategyElesResponse qmStrategyElesResponse = new QmStrategyElesResponse();
		try {
			for(int i = 0;i<ids.size();i++){
				QmStrategyElementRelExample elementExample = new QmStrategyElementRelExample();
				QmStrategyElementRelExample.Criteria criteria = elementExample.createCriteria();
				criteria.andElementIdEqualTo(ids.get(i));
				List<QmStrategyElementRel> rels = qmStrategyElementRelMapper.selectByExample(elementExample);
				if(rels.size() > 0){
					qmStrategyElesResponse.setRspcode(WebUtil.FAIL);
					qmStrategyElesResponse.setRspdesc("元素正被使用，无法删除");
				}else {
					QmStrategyElementExample example = new QmStrategyElementExample();
					QmStrategyElementExample.Criteria criteria1 = example.createCriteria();
					criteria1.andElementIdIn(ids);
					int result = qmStrategyElementMapper.deleteByExample(example);
					if(result > 0){
						qmStrategyElesResponse.setRspcode(WebUtil.SUCCESS);
						qmStrategyElesResponse.setRspdesc("删除成功");
					}else {
						qmStrategyElesResponse.setRspcode(WebUtil.FAIL);
						qmStrategyElesResponse.setRspdesc("删除失败");
					}
				}
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("删除异常",e);
			qmStrategyElesResponse.setRspcode(WebUtil.EXCEPTION);
			qmStrategyElesResponse.setRspdesc("删除异常");
		}
		return qmStrategyElesResponse;
	}

	@Override
	public QmStrategyElesResponse addQmStrategyEles(QmStrategyElement qmStrategyEles) throws Exception {
		QmStrategyElesResponse qmStrategyElesResponse = new QmStrategyElesResponse();
		try {
			qmStrategyEles.setElementId(String.valueOf(sequenceUtils.getSequence("t_qm_strategy_element")));
			int result = qmStrategyElementMapper.insertSelective(qmStrategyEles);
			if(result > 0){
				qmStrategyElesResponse.setRspcode(WebUtil.SUCCESS);
				qmStrategyElesResponse.setRspdesc("新增成功");
			}else {
				qmStrategyElesResponse.setRspcode(WebUtil.FAIL);
				qmStrategyElesResponse.setRspdesc("新增失败");
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("新增异常",e);
			qmStrategyElesResponse.setRspcode(WebUtil.EXCEPTION);
			qmStrategyElesResponse.setRspdesc("新增异常");
		}
		return  qmStrategyElesResponse;
	}

	@Override
	public QmStrategyElesResponse updateQmStrategyEles(QmStrategyElement qmStrategyEles) throws Exception {
		QmStrategyElesResponse qmStrategyElesResponse = new QmStrategyElesResponse();
		try {
			QmStrategyElementRelExample elementExample = new QmStrategyElementRelExample();
			QmStrategyElementRelExample.Criteria criteria = elementExample.createCriteria();
			criteria.andElementIdEqualTo(qmStrategyEles.getElementId());
			List<QmStrategyElementRel> rels = qmStrategyElementRelMapper.selectByExample(elementExample);
			if(rels.size() > 0){
				qmStrategyElesResponse.setRspcode(WebUtil.FAIL);
				qmStrategyElesResponse.setRspdesc("该元素正被使用，无法更新");
			}else {
				int result = qmStrategyElementMapper.updateByPrimaryKey(qmStrategyEles);
				if(result > 0){
					qmStrategyElesResponse.setRspcode(WebUtil.SUCCESS);
					qmStrategyElesResponse.setRspdesc("更新成功");
				}else {
					qmStrategyElesResponse.setRspcode(WebUtil.FAIL);
					qmStrategyElesResponse.setRspdesc("更新失败");
				}
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("更新异常",e);
			qmStrategyElesResponse.setRspcode(WebUtil.EXCEPTION);
			qmStrategyElesResponse.setRspdesc("更新异常");
		}
		return  qmStrategyElesResponse;
	}

	@Override
	public QmStrategyElesResponse getStrategyElesById(String id) throws Exception {
		QmStrategyElesResponse qmStrategyElesResponse = new QmStrategyElesResponse();

		try {
			QmStrategyElement qmStrategyEles = qmStrategyElementMapper.selectByPrimaryKey(id);
			if(null != qmStrategyEles){
				List<QmStrategyElement> list = new ArrayList<QmStrategyElement>();
				list.add(qmStrategyEles);
				qmStrategyElesResponse.setData(list);
				qmStrategyElesResponse.setRspcode(WebUtil.SUCCESS);
				qmStrategyElesResponse.setRspdesc("查询成功");
			}
		}catch (Exception e){
			e.printStackTrace();
			logger.error("查询异常",e);
			qmStrategyElesResponse.setRspcode(WebUtil.EXCEPTION);
			qmStrategyElesResponse.setRspdesc("查询异常");
		}
		return  qmStrategyElesResponse;
	}


}
