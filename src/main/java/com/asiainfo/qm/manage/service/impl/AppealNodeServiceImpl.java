package com.asiainfo.qm.manage.service.impl;

import com.asiainfo.qm.manage.dao.AppealNodeMapper;
import com.asiainfo.qm.manage.domain.AppealNode;
import com.asiainfo.qm.manage.domain.AppealNodeExample;
import com.asiainfo.qm.manage.service.AppealNodeService;
import com.asiainfo.qm.manage.util.WebUtil;
import com.asiainfo.qm.manage.vo.AppealNodeResponse;
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
        return null;
    }

    @Override
    public AppealNodeResponse addAppealNode(List<AppealNode> appealNodeList) throws Exception {
        AppealNodeResponse appealNodeResponse = new AppealNodeResponse();
        try{
            int result = 0;
            for (AppealNode appealNode : appealNodeList
            ) {
                result = appealNodeMapper.insertSelective(appealNode);
                if (result == 0) {
                    break;
                }
            }
            if(result > 0){
                appealNodeResponse.setRspcode(WebUtil.SUCCESS);
                appealNodeResponse.setRspdesc("节点新增成功");
            }else {
                appealNodeResponse.setRspcode(WebUtil.FAIL);
                appealNodeResponse.setRspdesc("节点新增失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("申诉节点新增异常",e);
            appealNodeResponse.setRspcode(WebUtil.EXCEPTION);
            appealNodeResponse.setRspdesc("申诉节点新增异常");
        }
        return appealNodeResponse;
    }

    @Override
    public AppealNodeResponse updateAppealNode(AppealNode appealNode) throws Exception {
        return null;
    }

    @Override
    public AppealNodeResponse deleteAppealNode(List<String> nodeList) throws Exception {
        AppealNodeResponse appealNodeResponse = new AppealNodeResponse();
        try {
            AppealNodeExample example = new AppealNodeExample();
            AppealNodeExample.Criteria criteria= example.createCriteria();
            //删除子节点
            criteria.andProcessIdIn(nodeList);
            int result = appealNodeMapper.deleteByExample(example);

            if(result > 0){
                appealNodeResponse.setRspcode(WebUtil.SUCCESS);
                appealNodeResponse.setRspdesc("删除成功");
            }else {
                appealNodeResponse.setRspcode(WebUtil.FAIL);
                appealNodeResponse.setRspdesc("删除失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("子节点删除异常",e);
            appealNodeResponse.setRspcode(WebUtil.EXCEPTION);
            appealNodeResponse.setRspdesc("子节点删除异常");
        }
        return appealNodeResponse;
    }
}
