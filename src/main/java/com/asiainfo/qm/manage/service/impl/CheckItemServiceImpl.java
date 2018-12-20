package com.asiainfo.qm.manage.service.impl;

import com.asiainfo.qm.manage.common.sequence.SequenceUtils;
import com.asiainfo.qm.manage.dao.CheckItemMapper;
import com.asiainfo.qm.manage.domain.CheckItem;
import com.asiainfo.qm.manage.domain.CheckItemExample;
import com.asiainfo.qm.manage.service.CheckItemService;
import com.asiainfo.qm.manage.util.DateUtil;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.CheckItemResponse;
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
 * @ Author     ：dingzc.
 * @ Date       ：Created in 14:22 2018/11/1
 * @ Description：${description}
 */
@Service
public class CheckItemServiceImpl implements CheckItemService {

    private static Logger logger = LoggerFactory.getLogger(CheckItemServiceImpl.class);

    @Autowired
    private CheckItemMapper checkItemMapper;

    @Autowired
    private SequenceUtils sequenceUtils;

    @Override
    public CheckItemResponse queryCheckItem(Map params, int start, int limit) throws Exception {
        CheckItemResponse checkItemResponse = null;
        String tenantId = "";
        String checkItemName = "";
        String checkItemType = "";
        if (null != params.get("tenantId") && !"".equals(params.get("tenantId"))) {
            tenantId = (String) params.get("tenantId");
        }
        if (null != params.get("checkItemName") && !"".equals(params.get("checkItemName"))) {
            checkItemName = (String) params.get("checkItemName");
        }
        if (null != params.get("checkItemType") && !"".equals(params.get("checkItemType"))) {
            checkItemType = (String) params.get("checkItemType");
        }
        try {
            //指定目录下的所有考评项
            List<CheckItem> rawList = new ArrayList<>();
            //每级目录下子目录id集合
            List<String> catalogIdList = new ArrayList<>();
            if (null != params.get("parentCheckItemId") && !"".equals(params.get("parentCheckItemId"))) {
                catalogIdList.add((String) params.get("parentCheckItemId"));
            }
            //递归查询指定目录下的所有考评项
            while (true) {
                CheckItemExample example = new CheckItemExample();
                CheckItemExample.Criteria criteria = example.createCriteria();
                if (!catalogIdList.isEmpty()) {
                    criteria.andParentCheckItemIdIn(catalogIdList);
                }


                List<CheckItem> list = checkItemMapper.selectByExample(example);
                rawList.addAll(list);
                //针对入参不包含parentCheckItemId的情况
                if (catalogIdList.isEmpty()) {
                    break;
                }
                catalogIdList.clear();
                for (CheckItem item : list
                ) {
                    if (item.getCatalogFlag().equals("0")) {
                        catalogIdList.add(item.getCheckItemId());
                    }
                }
                //子节点没有目录的情况下跳出循环
                if (catalogIdList.isEmpty()) {
                    break;
                }
            }
            //根据搜索条件二次筛选
            List<CheckItem> resultList = new Page<>();
            for (CheckItem checkItem : rawList
            ) {
                if (!tenantId.equals("") && !checkItem.getTenantId().equals(tenantId)) {
                    continue;
                }
                if (!checkItemName.equals("") && !checkItem.getCheckItemName().contains(checkItemName)) {
                    continue;
                }
                if (!checkItemType.equals("") && !checkItem.getCheckItemType().equals(checkItemType)) {
                    continue;
                }
                resultList.add(checkItem);
            }

            if (0 != limit) {
                PageHelper.offsetPage(start, limit);
                Page<CheckItem> pagelist = (Page) resultList;
                checkItemResponse = new CheckItemResponse(pagelist);
            } else {
                checkItemResponse = new CheckItemResponse();
                checkItemResponse.setData(resultList);
            }

            if (null != checkItemResponse.getData() && checkItemResponse.getData().size() > 0) {
                checkItemResponse.setRspcode(WebUtil.SUCCESS);
                checkItemResponse.setRspdesc("查询成功");
            } else {
                checkItemResponse.setRspcode(WebUtil.FAIL);
                checkItemResponse.setRspdesc("无数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("考评项查询异常", e);
            checkItemResponse.setRspcode(WebUtil.EXCEPTION);
            checkItemResponse.setRspdesc("考评项查询异常");
        }
        return checkItemResponse;
    }

    @Override
    public CheckItemResponse createCheckItem(CheckItem checkItem) throws Exception {
        CheckItemResponse checkItemResponse = new CheckItemResponse();
        try {
            checkItem.setCreateTime(DateUtil.getCurrontTime());
            checkItem.setOperateTime(DateUtil.getCurrontTime());
            checkItem.setCheckItemId(String.valueOf(sequenceUtils.getSequence("t_qm_check_item")));
            int result = checkItemMapper.insertSelective(checkItem);
            if (result > 0) {
                checkItemResponse.setRspcode(WebUtil.SUCCESS);
                checkItemResponse.setRspdesc("新增成功");
            } else {
                checkItemResponse.setRspcode(WebUtil.FAIL);
                checkItemResponse.setRspdesc("新增失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("考评项新增异常", e);
            checkItemResponse.setRspcode(WebUtil.EXCEPTION);
            checkItemResponse.setRspdesc("考评项新增异常");
        }
        return checkItemResponse;
    }

    @Override
    public CheckItemResponse updateCheckItem(CheckItem checkItem) throws Exception {
        CheckItemResponse checkItemResponse = new CheckItemResponse();
        try {
            checkItem.setOperateTime(DateUtil.getCurrontTime());
            int result = checkItemMapper.updateByPrimaryKey(checkItem);
            if (result > 0) {
                checkItemResponse.setRspcode(WebUtil.SUCCESS);
                checkItemResponse.setRspdesc("更新成功");
            } else {
                checkItemResponse.setRspcode(WebUtil.FAIL);
                checkItemResponse.setRspdesc("更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("考评项更新异常", e);
            checkItemResponse.setRspcode(WebUtil.EXCEPTION);
            checkItemResponse.setRspdesc("考评项更新异常");
        }
        return checkItemResponse;
    }

    @Override
    public CheckItemResponse deleteCheckItem(List<String> idList) throws Exception {
        CheckItemResponse checkItemResponse = new CheckItemResponse();
        try {
            CheckItemExample example = new CheckItemExample();
            CheckItemExample.Criteria criteria = example.createCriteria();
            criteria.andCheckItemIdIn(idList);
            int result = checkItemMapper.deleteByExample(example);
            if (result > 0) {
                checkItemResponse.setRspcode(WebUtil.SUCCESS);
                checkItemResponse.setRspdesc("删除成功");
            } else {
                checkItemResponse.setRspcode(WebUtil.FAIL);
                checkItemResponse.setRspdesc("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("考评项删除异常", e);
            checkItemResponse.setRspcode(WebUtil.EXCEPTION);
            checkItemResponse.setRspdesc("考评项删除异常");
        }
        return checkItemResponse;
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

