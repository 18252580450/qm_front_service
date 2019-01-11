package com.asiainfo.qm.manage.service.impl;

import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.dao.CheckTemplateMapper;
import com.asiainfo.qm.manage.dao.TplOpLogMapper;
import com.asiainfo.qm.manage.domain.CheckTemplate;
import com.asiainfo.qm.manage.domain.CheckTemplateExample;
import com.asiainfo.qm.manage.domain.TplOpLog;
import com.asiainfo.qm.manage.service.CheckTemplateService;
import com.asiainfo.qm.manage.service.TplOpLogService;
import com.asiainfo.qm.manage.util.DateUtil;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.CheckTemplateResponse;
import com.asiainfo.qm.manage.vo.TplOpLogResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.poi.ss.formula.functions.T;
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
public class TplOPLogServiceImpl implements TplOpLogService {

	private static Logger logger = LoggerFactory.getLogger(TplOPLogServiceImpl.class);

	@Autowired
	private TplOpLogMapper tplOpLogMapper;

	@Autowired
	private SequenceUtils sequenceUtils;

//	@Override
//	public CheckTemplateResponse action(CheckTemplate checkTemplate) throws Exception {
//		CheckTemplateResponse checkTemplateResponse = new CheckTemplateResponse();
//		try {
//			int result = checkTemplateMapper.updateByPrimaryKey(checkTemplate);
//			if(result > 0){
//				checkTemplateResponse.setRspcode(WebUtil.SUCCESS);
//				checkTemplateResponse.setRspdesc("修改模板状态成功");
//			}else {
//				checkTemplateResponse.setRspcode(WebUtil.FAIL);
//				checkTemplateResponse.setRspdesc("修改模板状态失败");
//			}
//		}catch (Exception e){
//			e.printStackTrace();
//			logger.error("修改模板状态异常",e);
//			checkTemplateResponse.setRspcode(WebUtil.EXCEPTION);
//			checkTemplateResponse.setRspdesc("修改模板状态异常");
//		}
//		return checkTemplateResponse;
//	}

//
	@Override
	public TplOpLogResponse insertTplOpLog(TplOpLog tplOpLog) throws Exception{
		TplOpLogResponse tplOpLogResponse = new TplOpLogResponse();
		try {
			tplOpLog.setTenantId("10010000");
			tplOpLog.setCrtTime(DateUtil.getCurrontTime());
			tplOpLog.setOperateTime(DateUtil.getCurrontTime());
			tplOpLog.setOperateId(String.valueOf(sequenceUtils.getSequence("t_qm_tpl_op_log")));
			int result = tplOpLogMapper.insertSelective(tplOpLog);
			if(result > 0){
				tplOpLogResponse.setRspcode(WebUtil.SUCCESS);
//				tplOpLogResponse.setRspdesc("新增操作日志成功");
			}else {
				tplOpLogResponse.setRspcode(WebUtil.FAIL);
//				tplOpLogResponse.setRspdesc("新增操作日志失败");
			}
		}catch (Exception e){
			e.printStackTrace();
//			logger.error("新增操作日志异常",e);
			tplOpLogResponse.setRspcode(WebUtil.EXCEPTION);
//			tplOpLogResponse.setRspdesc("新增操作日志异常");
		}
		return  tplOpLogResponse;
	}
}
