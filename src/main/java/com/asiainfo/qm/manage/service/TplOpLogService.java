package com.asiainfo.qm.manage.service;

import com.asiainfo.qm.manage.domain.CheckTemplate;
import com.asiainfo.qm.manage.domain.TplOpLog;
import com.asiainfo.qm.manage.vo.CheckTemplateResponse;
import com.asiainfo.qm.manage.vo.TplOpLogResponse;

import java.util.Map;

public interface TplOpLogService {

	TplOpLogResponse insertTplOpLog(TplOpLog tplOpLog)throws Exception;
}
	