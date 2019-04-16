package com.asiainfo.qm.manage.service.impl;

import com.asiainfo.qm.manage.dao.CheckItemMapper;
import com.asiainfo.qm.manage.domain.CheckItem;
import com.asiainfo.qm.manage.domain.CheckItemExample;
import com.asiainfo.qm.manage.service.CheckItemService;
import com.asiainfo.qm.manage.service.CheckTemplateDetailService;
import com.asiainfo.qm.manage.util.DateUtil;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.CheckItemResponse;
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
    private CheckTemplateDetailService checkTemplateDetailService;

    @Override
    public CheckItemResponse queryCheckItem(Map params, int start, int limit) throws Exception {
        CheckItemResponse checkItemResponse = null;
        CheckItemExample example = new CheckItemExample();
        try {
            CheckItemExample.Criteria criteria = example.createCriteria();
            if (null != params.get("tenantId") && !"".equals(params.get("tenantId"))) {
                criteria.andTenantIdEqualTo((String) params.get("tenantId"));
            }
            //指定父目录
            if (null != params.get("parentCheckItemId") && !"".equals(params.get("parentCheckItemId"))) {
                criteria.andParentCheckItemIdLike((String) params.get("parentCheckItemId") + "%");
            }
            //显示子一级目录
            if (null != params.get("orderNo") && !"".equals(params.get("orderNo"))) {
                criteria.andOrderNoEqualTo(Integer.parseInt(params.get("orderNo").toString()));
            }
            if (null != params.get("checkItemName") && !"".equals(params.get("checkItemName"))) {
                criteria.andCheckItemNameLike("%" + (String) params.get("checkItemName") + "%");
            }
            if (null != params.get("checkItemType") && !"".equals(params.get("checkItemType"))) {
                criteria.andCheckItemTypeEqualTo((String) params.get("checkItemType"));
            }
            if (null != params.get("nodeTypeCode") && !"".equals(params.get("nodeTypeCode"))) {
                criteria.andNodeTypeCodeEqualTo((String) params.get("nodeTypeCode"));
            }

            if (0 != limit) {
                PageHelper.offsetPage(start, limit);
                List<CheckItem> list = checkItemMapper.selectByExample(example);
                Page<CheckItem> pagelist = (Page) list;
                checkItemResponse = new CheckItemResponse(pagelist);
            } else {
                checkItemResponse = new CheckItemResponse();
                List<CheckItem> list = checkItemMapper.selectByExample(example);
                checkItemResponse.setData(list);
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
            //生成考评项id
            String parentId = checkItem.getParentCheckItemId();
            String checkItemId = parentId + "001";  //默认首位插入id
            CheckItemExample example = new CheckItemExample();
            CheckItemExample.Criteria criteria = example.createCriteria();
            criteria.andParentCheckItemIdEqualTo(parentId);
            example.setOrderByClause("CHECK_ITEM_ID ASC");
            List<CheckItem> list = checkItemMapper.selectByExample(example);
            if (!list.isEmpty()) {
                if (list.size() < 999) {
                    String firstId = list.get(0).getCheckItemId();
                    if (firstId.substring(firstId.length() - 3).equals("001")) {  //首个id被占用
                        for (int i = 1; i < list.size(); i++) {
                            long preId = Long.parseLong(list.get(i - 1).getCheckItemId());
                            long nextId = Long.parseLong(list.get(i).getCheckItemId());
                            if (nextId - preId > 1) {
                                checkItemId = String.valueOf(preId + 1);  //中间项插入id
                                break;
                            }
                        }
                        if (checkItemId.substring(checkItemId.length() - 3).equals("001")) {  //列表末端插入id
                            checkItemId = String.valueOf(Long.parseLong(list.get(list.size() - 1).getCheckItemId()) + 1);
                        }
                    }
                } else {
                    checkItemResponse.setRspcode(WebUtil.FAIL);
                    checkItemResponse.setRspdesc("该目录考评项数量超过最大值：999！");
                    return checkItemResponse;
                }
            }
            checkItem.setCreateTime(DateUtil.getCurrontTime());
            checkItem.setCheckItemId(checkItemId);
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
            //查询考评模版有无绑定考评项
            Map<String, List<String>> params = new HashMap<String, List<String>>();
            params.put("nodeIdList", idList);
            TemplateDetailResponse templateDetailResponse = checkTemplateDetailService.queryTemplateDetail(params, 0, 0);
            if (templateDetailResponse.getRspcode().equals(WebUtil.EXCEPTION)) {
                checkItemResponse.setRspcode(WebUtil.FAIL);
                checkItemResponse.setRspdesc("查询考评模版异常");
                return checkItemResponse;
            } else {
                if (templateDetailResponse.getRspcode().equals(WebUtil.SUCCESS)) {
                    checkItemResponse.setRspcode(WebUtil.FAIL);
                    checkItemResponse.setRspdesc("考评项已被绑定，无法删除");
                    return checkItemResponse;
                }
            }
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

