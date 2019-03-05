package com.asiainfo.qm.task.service.impl;

import com.asiainfo.qm.manage.dao.QmStrategyElementRelMapper;
import com.asiainfo.qm.manage.dao.QmStrategyMapper;
import com.asiainfo.qm.manage.domain.QmStrategy;
import com.asiainfo.qm.manage.domain.QmStrategyElementRel;
import com.asiainfo.qm.manage.domain.QmStrategyElementRelExample;
import com.asiainfo.qm.manage.util.DateUtil;
import com.asiainfo.qm.manage.util.DateUtils;
import com.asiainfo.qm.task.dao.QmVoiceMapper;
import com.asiainfo.qm.task.dao.QmWorkformMapper;
import com.asiainfo.qm.task.domain.QmVoice;
import com.asiainfo.qm.task.domain.QmVoiceExample;
import com.asiainfo.qm.task.domain.QmWorkform;
import com.asiainfo.qm.task.domain.QmWorkformExample;
import com.asiainfo.qm.task.service.IAutoExtractCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shiying on 2018/12/21.
 */
@Service
public class AutoExtractCommonServiceImpl implements IAutoExtractCommonService {
    @Autowired
    private QmVoiceMapper qmVoiceMapper;
    @Autowired
    private QmWorkformMapper qmWorkformMapper;
    @Autowired
    private QmStrategyMapper qmStrategyMapper;
    @Autowired
    private QmStrategyElementRelMapper qmStrategyElementRelMapper;

    public List<QmVoice> selectExtractVoiceInfo(Map params) throws Exception{
        List<QmVoice> list = new ArrayList<>();
//        1、根据策略ID和计划ID联表查询策略元素和策略计划关系表，查出需抽取的数据源表名称，
//           以及策略元素字段名，类型,值等信息
        String pId = (String)params.get("pId");
        List<String> staffIds = (List<String>)params.get("staffIds");
        List<String> departIds = (List<String>)params.get("departIds");
        QmStrategy qmStrategy = qmStrategyMapper.selectByPrimaryKey(pId);
        QmStrategyElementRelExample qmStrategyElementRelExample = new QmStrategyElementRelExample();
        QmStrategyElementRelExample.Criteria criteria = qmStrategyElementRelExample.createCriteria();
        criteria.andPIdEqualTo(pId);
        List<QmStrategyElementRel> qmStrategyElementRels = qmStrategyElementRelMapper.selectByExample(qmStrategyElementRelExample);
//        2、拼接sql语句
        Integer limit = (Integer)params.get("limit");
        //如需分表查询  可拼接表后缀
        String tableName = qmStrategy.getParamsTypeId();
        StringBuilder sql = builderSql(qmStrategyElementRels);
//        3、执行sql语句将查询出来的数据返回
        QmVoiceExample example = new QmVoiceExample();
        QmVoiceExample.Criteria criteria1 = example.createCriteria();
        if(staffIds.size()>0){
            criteria1.andStaffIdIn(staffIds);
        }
        if(departIds.size()>0){
            criteria1.andDepartIdIn(departIds);
        }
        Class<?> criteriaCls = QmVoiceExample.Criteria.class;
        Class<?> superclass = criteriaCls.getSuperclass();
        Method addCriterion = superclass.getDeclaredMethod("addCriterion", String.class);
        addCriterion.setAccessible(true);
        addCriterion.invoke(criteria1, sql.toString());
        list = qmVoiceMapper.selectByExampleForAutoExract(tableName,example, limit);
        return list;
    }

    @Override
    public List<QmWorkform> selectExtractWorkformInfo(Map params) throws Exception {
        List<QmWorkform> list = new ArrayList<>();
//        1、根据策略ID和计划ID联表查询策略元素和策略计划关系表，查出需抽取的数据源表名称，
//           以及策略元素字段名，类型,值等信息
        String pId = (String)params.get("pId");
        List<String> staffIds = (List<String>)params.get("staffIds");
        List<String> departIds = (List<String>)params.get("departIds");
        QmStrategy qmStrategy = qmStrategyMapper.selectByPrimaryKey(pId);
        QmStrategyElementRelExample qmStrategyElementRelExample = new QmStrategyElementRelExample();
        QmStrategyElementRelExample.Criteria criteria = qmStrategyElementRelExample.createCriteria();
        criteria.andPIdEqualTo(pId);
        List<QmStrategyElementRel> qmStrategyElementRels = qmStrategyElementRelMapper.selectByExample(qmStrategyElementRelExample);
//        2、拼接sql语句
        Integer limit = (Integer)params.get("limit");
        //如需分表查询  可拼接表后缀
        String tableName = qmStrategy.getParamsTypeId();
        StringBuilder sql = builderSql(qmStrategyElementRels);
//        3、执行sql语句将查询出来的数据返回
        QmWorkformExample example = new QmWorkformExample();
        QmWorkformExample.Criteria criteria1 = example.createCriteria();
        if(staffIds.size()>0){
            criteria1.andArcStaffIdIn(staffIds);
        }
        if(departIds.size()>0){
            criteria1.andArcStaffDeptIdIn(departIds);
        }
        Class<?> criteriaCls = QmWorkformExample.Criteria.class;
        Class<?> superclass = criteriaCls.getSuperclass();
        Method addCriterion = superclass.getDeclaredMethod("addCriterion", String.class);
        addCriterion.setAccessible(true);
        addCriterion.invoke(criteria1, sql.toString());
        list = qmWorkformMapper.selectByExampleForAutoExract(tableName,example, limit);
        return list;
    }

    private StringBuilder builderSql(List<QmStrategyElementRel> rels) throws Exception{
        StringBuilder sql = new StringBuilder(" 1=1 ");
        for(int i = 0;i<rels.size();i++){
            QmStrategyElementRel rel = rels.get(i);
            sql.append(" " + rel.getRtype() + " ");
            //是否区间值  0：否 1：是
            if(rel.getOperator().equals("between")){
                int value1Index = rel.getElementValue1().indexOf("@");
                if(value1Index >= 0){
                    String d = rel.getElementValue1().substring(0,value1Index).equals("")?"0":rel.getElementValue1().substring(0,value1Index);
                    String cur = DateUtils.getCurrentDateString("YYYY-MM-dd") + rel.getElementValue1().substring(value1Index + 1);
                    Date currentDate = DateUtil.getBeforeAfterDate(cur, Integer.parseInt(d));
                    Timestamp currentDate1 = DateUtils.paraseSqlTimestamp(DateUtil.date2String(currentDate), DateUtils.DATE_FORMAT_A_YYYYMMDDHHMMSS);
                    sql.append(rel.getElementCode()).append(" between '").append(currentDate1).append("'");
                }else{
                    sql.append(rel.getElementCode()).append(" between ").append(rel.getElementValue1());
                }
                int value2Index = rel.getElementValue2().indexOf("@");
                if(value2Index >= 0){
                    String d = rel.getElementValue2().substring(0,value2Index).equals("")?"0":rel.getElementValue2().substring(0,value2Index);
                    String cur = DateUtils.getCurrentDateString("YYYY-MM-dd") + rel.getElementValue2().substring(value2Index + 1);
                    Date currentDate = DateUtil.getBeforeAfterDate(cur, Integer.parseInt(d));
                    Timestamp currentDate1 = DateUtils.paraseSqlTimestamp(DateUtil.date2String(currentDate), DateUtils.DATE_FORMAT_A_YYYYMMDDHHMMSS);
                    sql.append(" and '").append(currentDate1).append("'");
                }else{
                    sql.append(" and ").append(rel.getElementValue2());
                }
            }else if(rel.getOperator().equals("in")){
                sql.append(rel.getElementCode()).append(" in(");
                sql.append(rel.getElementValue1()).append(") ");
            }else{
                sql.append(rel.getElementCode()).append(" " + rel.getOperator());
                sql.append(rel.getElementValue1());
            }
        }
        return sql;
    }
}
