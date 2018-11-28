package com.asiainfo.qm.manage.service.impl;

import com.asiainfo.qm.manage.dao.AppealNodeMapper;
import com.asiainfo.qm.manage.domain.AppealNode;
import com.asiainfo.qm.manage.domain.AppealNodeExample;
import com.asiainfo.qm.manage.service.AppealNodeService;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.AppealNodeResponse;
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
 * @ Date       ：Created in 17:23 2018/11/8
 * @ Description：${description}
 */
@Service
public class AppealNodeServiceImpl implements AppealNodeService {

    private static Logger logger = LoggerFactory.getLogger(AppealNodeServiceImpl.class);

    @Autowired
    private AppealNodeMapper appealNodeMapper;

    @Override
    public AppealNodeResponse queryAppealNode(Map params, int start, int limit) throws Exception {
        AppealNodeResponse appealNodeResponse = null;
        AppealNodeExample example = new AppealNodeExample();
        try {
            AppealNodeExample.Criteria criteria = example.createCriteria();
            if (null != params.get("processId") && !"".equals(params.get("processId"))) {
                criteria.andProcessIdEqualTo((String) params.get("processId"));
            }

            if (0 != limit) {
                PageHelper.offsetPage(start, limit);
                List<AppealNode> list = appealNodeMapper.selectByExample(example);
                Page<AppealNode> pagelist = (Page) list;
                appealNodeResponse = new AppealNodeResponse(pagelist);
            } else {
                appealNodeResponse = new AppealNodeResponse();
                List<AppealNode> list = appealNodeMapper.selectByExample(example);
                appealNodeResponse.setData(list);
            }

            if (null != appealNodeResponse.getData() && appealNodeResponse.getData().size() > 0) {
                appealNodeResponse.setRspcode(WebUtil.SUCCESS);
                appealNodeResponse.setRspdesc("查询成功");
            } else {
                appealNodeResponse.setRspcode(WebUtil.FAIL);
                appealNodeResponse.setRspdesc("无数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("申诉节点查询异常", e);
            appealNodeResponse.setRspcode(WebUtil.EXCEPTION);
            appealNodeResponse.setRspdesc("申诉节点查询异常");
        }
        return appealNodeResponse;
    }

    @Override
    public AppealNodeResponse addAppealNode(List<AppealNode> appealNodeList) throws Exception {
        AppealNodeResponse appealNodeResponse = new AppealNodeResponse();
        try {
            int result = 0;
            for (AppealNode appealNode : appealNodeList
            ) {
                result = appealNodeMapper.insertSelective(appealNode);
                if (result == 0) {
                    break;
                }
            }
            if (result > 0) {
                appealNodeResponse.setRspcode(WebUtil.SUCCESS);
                appealNodeResponse.setRspdesc("节点新增成功");
            } else {
                appealNodeResponse.setRspcode(WebUtil.FAIL);
                appealNodeResponse.setRspdesc("节点新增失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("申诉节点新增异常", e);
            appealNodeResponse.setRspcode(WebUtil.EXCEPTION);
            appealNodeResponse.setRspdesc("申诉节点新增异常");
        }
        return appealNodeResponse;
    }

    @Override
    public AppealNodeResponse updateAppealNode(List<AppealNode> appealNodes) throws Exception {
        AppealNodeResponse appealNodeResponse = new AppealNodeResponse();
        try {
            int result = 0;
            for (AppealNode appealNode : appealNodes
            ) {
                result = appealNodeMapper.updateByPrimaryKeySelective(appealNode);
                if (result == 0) {
                    break;
                }
            }
            if (result > 0) {
                appealNodeResponse.setRspcode(WebUtil.SUCCESS);
                appealNodeResponse.setRspdesc("子节点更新成功");
            } else {
                appealNodeResponse.setRspcode(WebUtil.FAIL);
                appealNodeResponse.setRspdesc("子节点更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("子节点更新异常", e);
            appealNodeResponse.setRspcode(WebUtil.EXCEPTION);
            appealNodeResponse.setRspdesc("子节点更新异常");
        }
        return appealNodeResponse;
    }

    @Override
    public AppealNodeResponse deleteAppealNode(List<String> processIdList, List<AppealNode> appealNodes) throws Exception {
        AppealNodeResponse appealNodeResponse = new AppealNodeResponse();
        try {
            int result = 0;

            //根据父流程Id删除子节点
            if (processIdList != null && !processIdList.isEmpty()) {
                AppealNodeExample example = new AppealNodeExample();
                AppealNodeExample.Criteria criteria = example.createCriteria();
                criteria.andProcessIdIn(processIdList);
                result = appealNodeMapper.deleteByExample(example);
            }
            if (appealNodes != null && !appealNodes.isEmpty()) {
                for (AppealNode appealNode : appealNodes
                ) {
                    AppealNodeExample example = new AppealNodeExample();
                    AppealNodeExample.Criteria criteria = example.createCriteria();
//                    criteria = example.createCriteria();
                    criteria.andProcessIdEqualTo(appealNode.getProcessId());
                    criteria.andNodeIdEqualTo(appealNode.getNodeId());
                    criteria.andUserIdEqualTo(appealNode.getUserId());

                    result = appealNodeMapper.deleteByExample(example);
                    if (result == 0) {
                        break;
                    }
                }
            }
            if (result > 0) {
                appealNodeResponse.setRspcode(WebUtil.SUCCESS);
                appealNodeResponse.setRspdesc("删除成功");
            } else {
                appealNodeResponse.setRspcode(WebUtil.FAIL);
                appealNodeResponse.setRspdesc("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("子节点删除异常", e);
            appealNodeResponse.setRspcode(WebUtil.EXCEPTION);
            appealNodeResponse.setRspdesc("子节点删除异常");
        }
        return appealNodeResponse;
    }
}
