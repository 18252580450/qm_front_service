package com.asiainfo.qm.manage.service.impl;

import com.asiainfo.qm.manage.dao.CheckItemMapper;
import com.asiainfo.qm.manage.domain.CheckItem;
import com.asiainfo.qm.manage.domain.CheckItemExample;
import com.asiainfo.qm.manage.service.CheckItemService;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.CheckItemResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：dingzc.
 * @ Date       ：Created in 14:22 2018/11/1
 * @ Description：${description}
 */
@Service
public class CheckItemServiceImpl implements CheckItemService {

    private static Logger logger = LoggerFactory.getLogger(CheckItemServiceImpl.class);

    @Autowired
    private CheckItemMapper checkItemMapper;

    @Override
    public CheckItemResponse queryCheckItem(Map params, int start, int limit) throws Exception {
        CheckItemResponse checkItemResponse = null;
        CheckItemExample example = new CheckItemExample();
        try{
            CheckItemExample.Criteria criteria = example.createCriteria();
            if(null != params.get("parentCheckItemId") && !"".equals(params.get("parentCheckItemId"))){
                criteria.andParentCheckitemIdEqualTo((String)params.get("parentCheckItemId"));
            }
            if(null != params.get("checkItemName") && !"".equals(params.get("checkItemName"))){
                criteria.andCheckitemNameLike("%"+(String)params.get("checkItemName")+"%");
            }
            if(null != params.get("tenantId") && !"".equals(params.get("tenantId"))){
                criteria.andTenantIdEqualTo((String)params.get("tenantId"));
            }
            if(null != params.get("checkItemType") && !"".equals(params.get("checkItemType"))){
                criteria.andCheckitemTypeEqualTo((String)params.get("checkItemType"));
            }
            PageHelper.offsetPage(start, limit);
            List<CheckItem> list = checkItemMapper.selectByExample(example);
            Page<CheckItem> pagelist = (Page)list;
            checkItemResponse = new CheckItemResponse(pagelist);

            if(null != checkItemResponse.getData() && checkItemResponse.getData().size() > 0){
                for (CheckItem item : checkItemResponse.getData()) {
                    if (null != item.getCheckitemType() && item.getCheckitemType().equals("0")){
                        item.setCheckitemType("语音考核项");
                    }
                    if (null != item.getCheckitemType() && item.getCheckitemType().equals("1")){
                        item.setCheckitemType("工单考核项");
                    }
                    if (null != item.getCheckitemType() && item.getCheckitemType().equals("2")){
                        item.setCheckitemType("电商平台考核项");
                    }
                    if (null != item.getCheckitemType() && item.getCheckitemType().equals("3")){
                        item.setCheckitemType("互联网考核项");
                    }
                }
                checkItemResponse.setRspcode(WebUtil.SUCCESS);
                checkItemResponse.setRspdesc("查询成功");
            }else {
                checkItemResponse.setRspcode(WebUtil.FAIL);
                checkItemResponse.setRspdesc("无数据");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("考评项查询异常",e);
            checkItemResponse.setRspcode(WebUtil.EXCEPTION);
            checkItemResponse.setRspdesc("考评项查询异常");
        }
        return checkItemResponse;
    }

    @Override
    public CheckItemResponse addCheckItem(Map params) throws Exception {
        return null;
    }

    @Override
    public CheckItemResponse editCheckItem(Map params) throws Exception {
        return null;
    }

    @Override
    public CheckItemResponse deleteCheckItem(List<String> idList) throws Exception {
        return null;
    }

    @Override
    public CheckItemResponse copyCheckItem(Map params) throws Exception {
        return null;
    }

    @Override
    public CheckItemResponse pasteCheckItem(Map params) throws Exception {
        return null;
    }
}

