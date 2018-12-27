package com.asiainfo.qm.manage.util;

/**
 * create by ld on 2018-08-28 14:34
 */
public class Constants {
    //存放系统常用配置
    public interface SYSTEM_CONFIG {
        String SYSTEM_CONFIG_ERROR = "-9999";//异常
        Integer SYSTEM_CONFIG_SUCCESS = 0;//成功
        //定义环境变量
        String SYSTEM_ENV_MO = "system.env.mo";//系统环境变量控制内容
        String SYSTEM_ENV_DEV = "develop"; //开发环境
        String SYSTEM_ENV_TEST = "test"; //测试环境
        String SYSTEM_ENV_PRODUCT = "product"; //生产环境
    }

    //知识批量采编onest路径
    public interface BATCH_UPLOAD {
        String BATCH_UPLOAD = "batchUpload";
    }

    //记录日志的key
    public interface AMORTIZE_TASK {
        String NGKM_OPER_CLICK_LOG = "NGKM_OPER_CLICK_LOG"; //单次点击明细记录
        String NGKM_OPER_TOTAL_LOG = "NGKM_OPER_TOTAL_LOG"; //总点击量记录
        String NGKM_OPER_SEARCH_LOG = "NGKM_OPER_SEARCH_LOG"; //总点击量记录
    }

    //消息中心topic
    public interface MQ_TOPIC {
        String TEST_TOPIC = "PIC_COMPARE"; //测试用topic
    }

    // redis前缀
    public interface REDIS_KEY_PERFIX {
        //系统参数配置数据
        String NGKM_BASE_SYSCFG = "NGKM_BASE_SYSCFG:";
        //省份、地市组织树
        String NGKM_BASE_SCOPE_MENU = "NGKM_BASE_SCOPE_MENU:";
        //全国地市组织树
        String NGKM_BASE_SCOPE_LIST = "NGKM_BASE_SCOPE_LIST";
        //省份、地市信息
        String NGKM_BASE_SCOPE_INFO = "NGKM_BASE_SCOPE_INFO:";
        //静态数据配置分类
        String NGKM_BASE_STATIC_TYPE = "NGKM_BASE_STATIC_TYPE:";
        //静态数据配置
        String NGKM_BASE_STATIC_INFO = "NGKM_BASE_STATIC_INFO:";
        //门户广告配置数据
        String NGKM_BASE_PORTAL_AD = "NGKM_BASE_PORTAL_AD:";
        //用户收藏分类数据
        String NGKM_USER_FAVORITES_TYPE = "NGKM_USER_FAVORITES_TYPE:";
        //用户收藏条目数据
        String NGKM_USER_FAVORITES_LIST = "NGKM_USER_FAVORITES_LIST:";
        //反馈模板列表
        String NGKM_FDBK_TPL_LIST = "NGKM_FDBK_TPL_LIST";
        //默认模板
        String NGKM_FDBK_TPL_DEFAULT = "NGKM_FDBK_TPL_DEFAULT:";
        //反馈模板列表
        String NGKM_FDBK_TPL_INFO = "NGKM_FDBK_TPL_INFO";
        //接口路由
        String NGKM_INTER_ROUTER = "NGKM_INTER_ROUTER:";
        //外围系统参数转换数据
        String NGKM_CFG_CODE_TRANS_INFO = "NGKM_CFG_CODE_TRANS_INFO:";
        //最新发布知识
        String NGKM_DOC_MANAGE_LATESTPUB = "NGKM_DOC_MANAGE_LATESTPUB:";
        //最近更新
        String NGKM_DOC_MANAGE_LATESTUPDATE = "NGKM_DOC_MANAGE_LATESTUPDATE:";
        //同级知识
        String NGKM_DOC_MANAGE_SAMELEVDOC = "NGKM_DOC_MANAGE_SAMELEVDOC:";
        //知识公共属性
        String NGKM_DOC_MANAGE_DOCDETAILPUBATTR = "NGKM_DOC_MANAGE_DOCDETAILPUBATTR:";
        //NEW知识公共属性
        String NGKM_DOC_MANAGE_NEWDOCDETAILPUBATTR = "NGKM_DOC_MANAGE_NEWDOCDETAILPUBATTR:";
        //分组详情
        String NGKM_DOC_MANAGE_GROUPDETAIL = "NGKM_DOC_MANAGE_GROUPDETAIL:";
        //同级分组
        String NGKM_DOC_MANAGE_SAMELEVGROUP = "NGKM_DOC_MANAGE_SAMELEVGROUP:";
        //同级原子
        String NGKM_DOC_MANAGE_SAMELEVATOM = "NGKM_DOC_MANAGE_SAMELEVATOM:";
        //优先搜索项
        String NGKM_DOC_MANAGE_DOCPRISEARCHITEM = "NGKM_DOC_MANAGE_DOCPRISEARCHITEM:";
        //新优先搜索项
        String NGKM_DOC_MANAGE_NEWDOCPRISEARCHITEM = "NGKM_DOC_MANAGE_NEWDOCPRISEARCHITEM";
        //自定义标签
        String NGKM_DOC_MANAGE_DOCTABINFO = "NGKM_DOC_MANAGE_DOCTABINFO:";
        //某知识下自定义标签列表
        String NGKM_DOC_MANAGE_DOCTABLIST = "NGKM_DOC_MANAGE_DOCTABLIST:";
        //原子详情
        String NGKM_DOC_MANAGE_ATOMDETAIL = "NGKM_DOC_MANAGE_ATOMDETAIL:";
        //知识目录，根据父节点获取子节点
        String NGKM_DOCCATALOG_LIST = "NGKM_DOCCATALOG_LIST:";
        //目录详情
        String NGKM_DOCCATALOG_INFO = "NGKM_DOCCATALOG_INFO:";
        //目录所配置的权限
        String NGKM_DOCCATALOG_ROLE_LIST = "NGKM_DOCCATALOG_ROLE_LIST:";
        //知识关联
        String NGKM_DOC_MANAGE_DOCRELATE = "NGKM_DOC_MANAGE_DOCRELATE";
        //新知识关联
        String NGKM_DOC_MANAGE_NEWDOCRELATE = "NGKM_DOC_MANAGE_NEWDOCRELATE:";
        //日志浏览量缓存
        String NGKM_LOG_CLICK_STATIS = "NGKM_LOG_CLICK_STATIS";
        //知识路径
        String NGKM_DOCCATALOG_KNOWLEDGEPATH = "NGKM_DOCCATALOG_KNOWLEDGEPATH:";
        //知识目录控制信息
        String NGKM_DOCCATALOG_CNTR_INFO = "NGKM_DOCCATALOG_CNTR_INFO:";
        //个性化设置
        String NGKM_SEARCH_PERSONAL = "NGKM_SEARCH_PERSONAL:";
        //热门知识缓存
        String NGKM_HOTKNOWLEDGECODES_COUNT = "NGKM_HOTKNOWLEDGECODES_COUNT:";
        //判断知识是否最新 缓存配置
        String NGKM_NEWKNOWLEDGECODES_DAYS = "NGKM_NEWKNOWLEDGECODES_DAYS:";
        //热门关键词统计缓存
        String NGKM_HOTSEARCHCODES_COUNT = "NGKM_HOTSEARCHCODES_COUNT:";
        //模板信息缓存
        String NGKM_TMPLTINFO = "NGKM_TMPLTINFO:";
        //分组信息缓存
        String NGKM_TMPLT_GROUPS = "NGKM_TMPLT_GROUPS:";
        //原子信息缓存
        String NGKM_TMPLT_KEYS = "NGKM_TMPLT_KEYS:";
        //筛选条件信息缓存
        String NGKM_TMPLT_FILTER = "NGKM_TMPLT_FILTER:";
        //模板父节点下所有分组缓存
        String NGKM_TMPLT_GROUPS_CHILD = "NGKM_TMPLT_GROUPS_CHILD:";
        //分组或筛选条件下所有原子信息缓存
        String NGKM_TMPLT_KEY_OBJREL = "NGKM_TMPLT_KEY_OBJREL:";
        //模板下所有筛选条件缓存
        String NGKM_TMPLT_FILTER_ALL = "NGKM_TMPLT_FILTER_ALL:";
        //知识索引模板配置上信息 缓存
        String NGKM_INDEX_TMPLT_CFG = "NGKM_INDEX_TMPLT_CFG:";
    }

    // session 信息
    public interface NGKM_USER_INFO {
        //用户省份
        String NGKM_USER_PROVNCE = "provnce";
        //用户工号姓名
        String NGKM_USER_STAFFCODE = "staffCode";
        //用户工号姓名
        String NGKM_USER_STAFFNAME = "staffName";
        //用户手机号
        String NGKM_USER_MOBILEPHONE = "mobilePhone";
        //用户组织编码
        String NGKM_USER_ORGAID = "orgaId";
        //用户组织机构
        String NGKM_USER_ORGANAME = "orgaName";
        //用户租户ID
        String NGKM_USER_TENANTID = "tenantId";
        //用户渠道ID
        String NGKM_USER_CHANNELCODE = "channelCode";
        //地域编号
        String NGKM_USER_SCOPE = "scope";

        String NGKM_USER_GROUP = "group";//工作组

        String NGKM_USER_CTIPROVNCEID = "ctiProvnceId";//坐席CTI省份编号

        String NGKM_USER_ROLEIDS = "roleIds";//角色信息

        String NGKM_USER_EDIT_GROUP = "editGroups";//采编组
        String NGKM_USER_CHECK_GROUP = "checkGroups";//审核组
        String NGKM_USER_VIEW_GROUP = "viewGrous";//查看组
        String NGKM_USER_FDBK_GROUP = "fdbkGroups";//反馈处理组

        String TASKINFO = "TASKINFO";//省份调度信息
        // 外围系统真实小工号
        String NGKM_USER_CRM_STAFFID = "crmStaffId";
    }

    // session 信息
    public interface NGKM_ClIENT_INFO {
        String ClIENT_INFO = "CLINET_INFO";

    }

    public interface NGKM_INTERFACE_CODE {
        //统一知识库在ngmtt中的code
        String NGKM_CODE = "245";
        String NGKM_SMS_CODE = "KM_SMS_SEND";
        String NGKM_TOKEN_CODE = "NGKM_TOKEN_CODE";

        //不配置调用全网百应，路由配置省份的字段 为null 或1 调全网百应，为2 调新版搜索引擎
        String PROVINCE_CODE_CONFIG = "PROVINCE_CODE_CONFIG";


        //路由配置接口模块代码;获取接口路由的key（接口模块代码）， 路由的value配置csf的code(接口编码)
        //获取最新知识列表
        String NGKMSEARCH_GETNEWESTKNOWLEDGES_POST = "NGKMSEARCH_GETNEWESTKNOWLEDGES_POST";
        //最近更新知识列表
        String NGKMSEARCH_GETLATESTUPDATEDKNOWLEDGES_POST = "NGKMSEARCH_GETLATESTUPDATEDKNOWLEDGES_POST";
        //热门知识列表
        String NGKMSEARCH_GETHOTKNOWLEDGES_POST = "NGKMSEARCH_GETHOTKNOWLEDGES_POST";
        //推荐业务活动查询
        String NGKMSEARCH_GETRECOMMENDEDKNOWLEDGES_POST = "NGKMSEARCH_GETRECOMMENDEDKNOWLEDGES_POST";
        //查询逻辑树节点（全部）
        String NGKMSEARCH_GETKNOWLEDGEBUSINESSTAGS_POST = "NGKMSEARCH_GETKNOWLEDGEBUSINESSTAGS_POST";
        //查询知识模板列表
        String NGMKSEARCH_GETKNOWLEDGETEMPLATES_POST = "NGMKSEARCH_GETKNOWLEDGETEMPLATES_POST";
        //根据关键词搜索
        String NGKMSEARCH_GETKNOWLEDGESBYKEYWORDS_POST = "NGKMSEARCH_GETKNOWLEDGESBYKEYWORDS_POST";
        //搜索热门搜索词
        String NGKMSEARCH_GETHOTKEYWORDS_POST = "NGKMSEARCH_GETHOTKEYWORDS_POST";
        //根据知识模板展示筛选项
        String NGKMSEARCH_GETTEMPLATEFILTERCONDITION_POST = "NGKMSEARCH_GETTEMPLATEFILTERCONDITION_POST";
        //搜索补全提示词查询
        String NGKMSEARCH_GETSUGGESTIONWORDS_POST = "NGKMSEARCH_GETSUGGESTIONWORDS_POST";
        //基于模板类型的知识列表查询
        String NGKMSEARCH_GETKNOWLEDGESBYTEMPLATE_POST = "NGKMSEARCH_GETKNOWLEDGESBYTEMPLATE_POST";
        //基于逻辑树图的知识列表查询
        String NGKMSEARCH_GETKNOWLEDGESBYBUSINESSTAGID_POST = "NGKMSEARCH_GETKNOWLEDGESBYBUSINESSTAGID_POST";
        //逻辑树节点查询子集
        String NGKMSEARCH_GETTAGS_POST = "NGKMSEARCH_GETTAGS_POST";
        // 逻辑树图路径查询接口
        String NGKMSEARCH_GETTAGBREADCRUMBNAVI_POST = "NGKMSEARCH_GETTAGBREADCRUMBNAVI_POST";
        //全网知识库基于知识id的知识详情查询
        String NGKMSEARCH_GETKNOWLEDGEDETAIL_POST = "NGKMSEARCH_GETKNOWLEDGEDETAIL_POST";
        //全网知识库短信链接生成接口
//      String NGKMSEARCH_GETSMSURL_POST ="NGKMSEARCH_GETSMSURL_POST";

        //最新版本知识ID查询
        String NGKMSEARCH_GETNEWESTKNOWLEDGEVERSIONID_POST = "NGKMSEARCH_GETNEWESTKNOWLEDGEVERSIONID_POST";


        //该员工今天发送相同短信的总条数
        String NGKM_SMS_PERSON_TOTAL = "245002002";
        //每人每天发送短信的总条数
        String NGKM_SMS_ONE_COUNT = "245002001";
        //短信链接访问互联网域代理
        String NGKM_SMS_LINK_PROXY = "245002003";
        //每个地市最多能发布的广告条数
        String NGKM_ADVERT_PUBLISH_COUNT = "245003001";

        //全网知识库配置
        String SYS_ZSK_TYPE = "245001";//类型
        String SYS_ZSK_TYPE_CHANNEL = "245001001";//本渠道
        String SYS_ZSK_TYPE_CHANNEL_APP = "245001002";//应用渠道
        String SYS_ZSK_TYPE_ATTACH_URL = "245001003";//附件URL
        String SYS_ZSK_TYPE_SMS_URL = "245001003";//短信URL
        String API_KEY = "245002005";
        String USER_NAME = "245002004";
        String LOCAL_URL = "245002006";

        //短信路线链接访问互联网域代理
        String NGKM_SMS_PROXY = "245002008";
    }

    //广告管理 信息
    public interface TKM_ADVERT_INFO {
        //发布状态
        String TKM_ADVERT_STATUS_0 = "0"; //未发布
        String TKM_ADVERT_STATUS_1 = "1"; //已发布

    }

    public interface KM_FDBKTPL_INFO {
        String KM_FDBKTPL_STATUS_0 = "0"; //未默认
        String KM_FDBKTPL_STATUS_1 = "1"; //默认
    }

    public interface NGKM_KLG_STATUS_INFO {
        String NGKM_KLG_STATUS_INFO_0 = "0";//未上线
        String NGKM_KLG_STATUS_INFO_1 = "1";//已下线
        String NGKM_KLG_STATUS_INFO_2 = "2";//正常
    }

    // CSF接口编码
    public interface CSF_SERVICE_CODE {
        //静态数据查询
        String NGMTT_QUERYSTATICDATADICTREST_GET = "NGMTT_QUERYSTATICDATADICTREST_GET";
        //系统参数查询
        String NGMTT_QUERYSYSTEMPARAMINFOBYIDREST_GET = "NGMTT_QUERYSYSTEMPARAMINFOBYIDREST_GET";
        //最新知识列表
        String ZSK_GETNEWESTKNOWLEDGES_POST = "ZSK_GETNEWESTKNOWLEDGES_POST";
        String NGKMSEARCH_GETNEWESTKNOWLEDGES_POST = "NGKMSEARCH_GETNEWESTKNOWLEDGES_POST";
        //最近更新知识列表
        String ZSK_GETLATESTUPDATEDKNOWLEDGES_POST = "ZSK_GETLATESTUPDATEDKNOWLEDGES_POST";
        String NGKMSEARCH_GETLATESTUPDATEDKNOWLEDGES_POST = "NGKMSEARCH_GETLATESTUPDATEDKNOWLEDGES_POST";
        //热门知识列表
        String ZSK_GETHOTKNOWLEDGES_POST = "ZSK_GETHOTKNOWLEDGES_POST";
        String NGKMSEARCH_GETHOTKNOWLEDGES_POST = "NGKMSEARCH_GETHOTKNOWLEDGES_POST";
        //推荐业务活动查询
        String ZSK_GETRECOMMENDEDKNOWLEDGES_POST = "ZSK_GETRECOMMENDEDKNOWLEDGES_POST";
        String NGKMSEARCH_GETRECOMMENDEDKNOWLEDGES_POST = "NGKMSEARCH_GETRECOMMENDEDKNOWLEDGES_POST";
        //查询逻辑树节点（全部）
        String ZSK_GETKNOWLEDGEBUSINESSTAGS_POST = "ZSK_GETKNOWLEDGEBUSINESSTAGS_POST";
        String NGKMSEARCH_GETALLBUSINESSTAGS_POST = "NGKMSEARCH_GETALLBUSINESSTAGS_POST";
        //查询知识模板列表
        String ZSK_GETKNOWLEDGETEMPLATES_POST = "ZSK_GETKNOWLEDGETEMPLATES_POST";
        String NGKMSEARCH_GETALLTEMPLATES_POST = "NGKMSEARCH_GETALLTEMPLATES_POST";
        //根据关键词搜索
        String ZSK_GETKNOWLEDGESBYKEYWORDS_POST = "ZSK_GETKNOWLEDGESBYKEYWORDS_POST";
        String NGKMSEARCH_GETKNOWLEDGESBYKEYWORDS_POST = "NGKMSEARCH_GETKNOWLEDGESBYKEYWORDS_POST";
        //搜索热门搜索词
        String ZSK_GETHOTKEYWORDS_POST = "ZSK_GETHOTKEYWORDS_POST";
        String NGKMSEARCH_GETHOTKEYWORDS_POST = "NGKMSEARCH_GETHOTKEYWORDS_POST";
        //根据知识模板展示筛选项
        String ZSK_GETTEMPLATEFILTERCONDITION_POST = "ZSK_GETTEMPLATEFILTERCONDITION_POST";
        String NGKMSEARCH_GETTEMPLATEFILTERINFOS_POST = "NGKMSEARCH_GETTEMPLATEFILTERINFOS_POST";
        //搜索补全提示词查询
        String ZSK_GETSUGGESTIONWORDS_POST = "ZSK_GETSUGGESTIONWORDS_POST";
        String NGKMSEARCH_GETSUGGESTIONWORDS_POST = "NGKMSEARCH_GETSUGGESTIONWORDS_POST";

        //基于模板类型的知识列表查询
        String ZSK_GETKNOWLEDGESBYTEMPLATE_POST = "ZSK_GETKNOWLEDGESBYTEMPLATE_POST";
        //发布公告
        String NGANOCE_OUTSYSTEMSENDANOCE_POST = "NGANOCE_OUTSYSTEMSENDANOCE_POST";
        String NGKMSEARCH_GETKNOWLEDGESBYTEMPLATE_POST = "NGKMSEARCH_GETKNOWLEDGESBYTEMPLATE_POST";

        //调用GIS平台接口
        String CMOSGIS_GEOCODER_POST = "CMOSGIS_GEOCODER_POST";

        //基于逻辑树图的知识列表查询
        String ZSK_GETKNOWLEDGESBYBUSINESSTAGID_POST = "ZSK_GETKNOWLEDGESBYBUSINESSTAGID_POST";
        String NGKMSEARCH_GETKNOWLEDGESBYBUSINESSTAGID_POST = "NGKMSEARCH_GETKNOWLEDGESBYBUSINESSTAGID_POST";
        //逻辑树节点查询子集
        String ZSK_GETTAGS_POST = "ZSK_GETTAGS_POST";
        String NGKMSEARCH_GETCHILDNODESBYPARENTNODE_POST = "NGKMSEARCH_GETCHILDNODESBYPARENTNODE_POST";
        // 逻辑树图路径查询接口
        String ZSK_GETTAGBREADCRUMBNAVI_POST = "ZSK_GETTAGBREADCRUMBNAVI_POST";
        String NGKMSEARCH_GETTAGBREADCRUMBNAVIBYTAGID_POST = "NGKMSEARCH_GETTAGBREADCRUMBNAVIBYTAGID_POST";
        //全网知识库基于知识id的知识详情查询
        String ZSK_GETKNOWLEDGEDETAIL_POST = "ZSK_GETKNOWLEDGEDETAIL_POST";
        String NGKMSEARCH_GETKNOWLEDGEDETAILSBYID_POST = "NGKMSEARCH_GETKNOWLEDGEDETAILSBYID_POST";
        //全网知识库短信链接生成接口
        String ZSK_GETSMSURL_POST = "ZSK_GETSMSURL_POST";

        //最新版本知识ID查询
        String ZSK_GETNEWESTKNOWLEDGEVERSIONID_POST = "ZSK_GETNEWESTKNOWLEDGEVERSIONID_POST";
        String NGKMSEARCH_GETNEWESTKNOWLEDGEVERSIONIDBYKBID_POST = "NGKMSEARCH_GETNEWESTKNOWLEDGEVERSIONIDBYKBID_POST";

        //搜索引擎提供的接口
        String NGKMSEARCH_BUSIDELDOCUMENTBYIDINTERSERVICE_POST = "NGKMSEARCH_BUSIDELDOCUMENTBYIDINTERSERVICE_POST"; //删除索引接口
        String NGKMSEARCH_BUSISEARCHERINTERSERVICE_POST = "NGKMSEARCH_BUSISEARCHERINTERSERVICE_POST"; //搜索引擎统一查询接口
        String NGKMSEARCH_BUSISUGGESTSEARCHERINTERSERVICE_POST = "NGKMSEARCH_BUSISUGGESTSEARCHERINTERSERVICE_POST"; //统一查询接口(搜索建议词)
        String NGKMSEARCH_BUSIAGGRATIONSEARCHERINTERSERVICE_POST = "NGKMSEARCH_BUSIAGGRATIONSEARCHERINTERSERVICE_POST"; //统一查询接口(热门词汇)
        String NGKMSEARCH_BUSIINDEXERORUPDATERINTERSERVICE_POST = "NGKMSEARCH_BUSIINDEXERORUPDATERINTERSERVICE_POST"; //创建或更新索引接口

        //从分析平台获取热门知识(临时使用，需要修改)
        String WEBLOG_HOTKNOWLEDGECOUNT_GET = "WEBLOG_HOTKNOWLEDGECOUNT_GET";//热门知识统计
        String WEBLOG_HOTSERARCHCOUNT_GET = "WEBLOG_HOTSERARCHCOUNT_GET";//热门搜索词统计

        //调用ngmtt获取权限
        String NGMTT_GETUSERFUNCTIONPERMLISTREST_GET = "NGMTT_GETUSERFUNCTIONPERMLISTREST_GET";

        //根据新员工Id获取省端系统老员工id
        String NGMTT_QUERYORIGSTAFFIDBYNEWSTAFFID_GET = "NGMTT_QUERYORIGSTAFFIDBYNEWSTAFFID_GET";

        //短信平台长链接转短链接
        String SMS_URL_SHORTURL_POST = "SMS_URL_SHORTURL_POST";

        //根据工号查询调度单信息 cti用
        String NGMTT_QUERYTASKINFOBYSTAFFID_GET = "NGMTT_QUERYTASKINFOBYSTAFFID_GET";
    }

    // 系统参数编码
    public interface SYS_PARAM_CODE {
        String CRMPFCORE_CRMPF_BUSI_PHONEAREAQURY_GET = "CRMPFCORE_CRMPF_BUSI_PHONEAREAQURY_GET";
        String COUNTY_CODE = "000";
    }

    // 默认系统参数值
    public interface SYS_PARAM_DEFALUT {
        String TKM_ACCESS_CHNL_ID = "1";//来访渠道（全网知识库为本系统定义的固定来访渠道）；
        String TKM_APPLYCATION_CHNL_ID = "3";//知识应用渠道（全网知识库为本系统定义的固定知识应用渠道）；

    }

    //知识反馈信息
    public interface TKM_FEEDBACK_INFO {
        //反馈处理状态
        String TKM_FEEDBACK_STATUS_1 = "1";//未处理
        String TKM_FEEDBACK_STATUS_2 = "2";//已采纳
        String TKM_FEEDBACK_STATUS_3 = "3";//未采纳
        String TKM_FEEDBACK_STATUS_4 = "4";//确认中

        //反馈类型
        String TKM_FEEDBACK_TYPE_1 = "1";//知识反馈
        String TKM_FEEDBACK_TYPE_2 = "2";//搜索反馈

        //是否采纳
        String TKM_FEEDBACK_REPLY_TYPE_Y = "1";//采纳
        String TKM_FEEDBACK_REPLY_TYPE_N = "2";//不采纳

        //个人反馈信息查询，前台传入的值
        String TKM_FEEDBACK_STATUS_ALL = "0";//查询全部
        String TKM_FEEDBACK_STATUS_WAIT = "1";//查询未处理反馈
        String TKM_FEEDBACK_STATUS_ACCEPT = "2";//查询已采纳的反馈
        String TKM_FEEDBACK_STATUS_REJECT = "3";//查询未采纳的反馈
        String TKM_FEEDBACK_STATUS_CLAIM = "4";//查询确认中的反馈
    }

    //知识反馈信息 二阶段
    public interface TKM_FDBK_INFO {
        //反馈处理状态
        String TKM_FEEDBACK_STATUS_1 = "1";//待审核
        String TKM_FEEDBACK_STATUS_2 = "2";//未处理
        String TKM_FEEDBACK_STATUS_3 = "3";//确认中
        String TKM_FEEDBACK_STATUS_4 = "4";//未采纳
        String TKM_FEEDBACK_STATUS_5 = "5";//已采纳
        String TKM_FEEDBACK_STATUS_6 = "6";//驳回

        //反馈处理结果
        String TKM_FEEDBACK_RESULT_TYPE_1 = "1";//待认领
        String TKM_FEEDBACK_RESULT_TYPE_2 = "2";//已认领

        //反馈处理隐藏
        String TKM_FEEDBACK_HIDE_0 = "0";//未隐藏
        String TKM_FEEDBACK_HIDE_1 = "1";//隐藏

        //反馈类型
        String TKM_FEEDBACK_TYPE_1 = "1";//知识反馈
        String TKM_FEEDBACK_TYPE_2 = "2";//搜索反馈

        //已读未读标志
        String TKM_FEEDBACK_NOREAD = "0";//未读
        String TKM_FEEDBACK_HASREAD = "1";//已读

        //个人反馈信息查询，前台传入的值
        String TKM_FEEDBACK_STATUS_ALL = "0";//查询全部
        String TKM_FEEDBACK_STATUS_FINISH = "1";//查询已完成反馈
        String TKM_FEEDBACK_STATUS_UNFINISHED = "2";//查询未完成的反馈
        //班长审核信息查询，前台传入的值
        String TKM_FEEDBACK_STATUS_UNCHECKED = "3";//待审核
        String TKM_FEEDBACK_STATUS_CHECKED = "4";//已审核

    }

    //地市等级
    public interface DISTRICT_HRCY_INFO {
        String CITY_LEVEL = "3"; //地市等级
        String PROV_LEVEL = "2"; //省份等级
        String COUNTRY_LEVEL = "1"; //国家等级
    }

    //转换数据表
    public interface TKM_CFG_CODE_TRANS {
        //发布状态
        String INVKDIRCTNCD_LOCAL = "1"; //本地调用远程
        String INVKDIRCTNCD_REMOTE = "2"; //远程调用本地

        //外围系统编码
        String SYS_CODE_ZSK = "zsk"; //全网知识库
        String SYS_CODE_NGMTT = "NGMTT";//租户管理系统
        String SYS_CODE_NGCS = "NGCS";//ngcs
        String SYS_CODE_NGMS = "NGMS";//ngcs

        //数据类型
        String CONFIG_CODE_DSPSWORKGRP = "dspsWorkGrp";//反馈处理组
        String CONFIG_CODE_ORGENCODING = "organEncoding";//组织机构
        String CONFIG_OTHER_AREA_VALUE = "00000";//省份信息为其他对应的值
        String CONFIG_LOCATION_ID = "locationID";
        String CONFIG_SCOPE = "scope";
        String CONFIG_CODE_NGMSREGION = "ngmsRegion";
        String CONFIG_SCOPE_AREA = "areaCode";
    }

    //地市信息表
    public interface TKM_DISTRICT_CFG {
        //发布状态
        short HRCY_SEQNO_COUNTRY = 1; //地域级别 国家
        short HRCY_SEQNO_PROVINCE = 2; //地域级别 省
        short HRCY_SEQNO_CITY = 3; //地域级别 市

    }

    //转换数据表
    public interface TKM_SYS_PARAM {
        //统一知识库在ngmtt中的code
        String NGKM_CODE = "245";

        //全网知识库配置
        String SYS_ZSK_TYPE = "245001";//类型
        String SYS_ZSK_TYPE_CHANNEL = "245001001";//本渠道
        String SYS_ZSK_TYPE_CHANNEL_APP = "245001002";//应用渠道
        String SYS_ZSK_TYPE_ATTACH_URL = "245001003";//附件URL
        String SYS_ZSK_TYPE_SMS_URL = "245001003";//短信URL

        //20180107 add for 2rd 全网知识库配置
        String SYS_ZSK_TYPE_CHANNEL_SEC = "245004003";//二阶段本渠道


    }

    /**
     * 导出文件限制
     *
     * @author ZSL
     */
    public interface EXPORT_FILE_LIMIT {

        /**
         * 最大导出记录数
         */
        int MAX_RECORDS = 50000;
        /**
         * 每页最多查询数据记录条数
         */
        int PAGE_SIZE = 5000;

    }

    //知识状态代码
    public interface NGKM_KNOWLEDGE_STATE {
        String KLG_STATE_NEW_EDIT = "1E";//新建待发布
        String KLG_STATE_NEW_APPROVE = "1A";//新建待审核
        String KLG_STATE_NEW_PUBLISH = "1P";//新建已发布
        String KLG_STATE_UPDATE_EDIT = "2E";//更新待发布
        String KLG_STATE_UPDATE_APPROVE = "2A";//更新待审核
        String KLG_STATE_UPDATE_PUBLISH = "2P";//更新已发布
        String KLG_STATE_DELETE_EDIT = "3E";//删除待发布
        String KLG_STATE_DELETE_APPROVE = "3A";//删除待审核
        String KLG_STATE_DELETE = "D";//回收站
        String KLG_STATE_DELETE_L = "DL";//彻底删除
        String KLG_STATE_PRE = "PR";//预采编知识
    }

    public interface NGKM_APPROVETASK_STATE {
        String TSK_STSCD_NOAPPROVE = "A1";
        String TSK_STSCD_APPROVE = "A2";
        String TSK_STSCD_HASAPPROVE = "A3";
        String TSK_RSLTCD_APPROVE = "1";
        String TSK_RSLTCD_REJECT = "2";
        String EMAPV_NODE_STSCD_TODO = "0";
        String EMAPV_NODE_STSCD_APPROVE = "1";
        String EMAPV_NODE_STSCD_REJECT = "2";
    }

    public interface NGKM_KNOWLEDGE_RELATION_TYPE {
        String KLG_RELATION_DOUBLE_CONNECT = "1";//双向关联知识
        String KLG_RELATION_SINGLE_CONNECT = "2";//单向关联知识
        String KLG_RELATION_DOUBLE_GROUP = "3";//双向关联系列
        String KLG_RELATION_SINGLE_GROUP = "4";//单项关联系列
        String KLG_RELATION_CONFILICT_CONNECT = "5";//互斥关联系列
        String KLG_RELATION_MESSAGE = "6";//短信
        String KLG_RELATION_FILE = "7";//附件关联
        String KLG_RELATION_IVR = "8";//
        String KLG_RELATION_TAB = "9";//自定义页签
    }

    //分组和原子关系类型
    public interface NGKM_GROUP_ATOM_RELATION_TYPE {
        String GROUP_ATOM_RELATION_TYPE = "1";//分组原子关系
    }

    public interface NGKM_SUPR_GRPNG_LEVEL {
        Long LEVEL_FIRST = 0L;
    }

    //历史知识显示状态
    public interface TKM_DOC_VERSION_ISDISPLAY {
        String HIDE = "0"; //隐藏
        String SHOW = "1"; //显示
    }

    //原子参数类型代码
    public interface NGKM_ATOM_PARAM_TYPE {
        String STRING_TYPE = "1";//字符串
        String RADIO_TYPE = "2";//单选
        String CHECKBOX_TYPE = "3";//多选
        String RICH = "4";//富文本
        String TIME_PERIOD_TYPE = "5";//时间
        String DATE_TYPE = "6";//日期类型
        String TIME_DATE_TYPE = "7";//日期时间类型
        String RELATE_KNWLG = "8";//关系知识类型
        String MEMORY = "9";//内存类型
        String FILE_TYPE = "10";//附件
        String DATA_UNIT = "11";//数据单元
        String PRICETIME_TYPE = "12";//价格/时间
        String PIC_TYPE = "13";//图片类型
        String LONGITUDEANDLATITUDE_TYPE = "14";//经纬度
        String RELATE_SERIES = "15";//关系系列类型
        String REGN_TYPE = "16";//地域类型
    }

    //参数价格时间类型单位
    public interface NGKM_ATOM_PARAM_PRICEORTIMETYPE_WKUNIT {
        String YUAN_MINUTE = "1"; //元/分钟
        String YUAN_HOUR = "2";   //元/小时
        String YUAN_DAY = "3";   //元/天
        String YUAN_MONTH = "4";   //元/月
        String YUAN_QUARTER = "5";   //元/季度
        String YUAN_HALF_YEAR = "6";   //元/半年
        String YUAN_YEAR = "7";   //元/年
        String YUAN_2YEAR = "8";   //元/两年
        String YUAN_3YEAR = "9";   //元/三年
        String YUAN_PERIOD = "10";   //元/账期
    }

    //内存类型单位
    public interface NGKM_ATOM_PARAM_RAMTYPE_WKUNIT {
        String KB = "1";//kb
        String MB = "2";//mb
        String GB = "3";//gb
        String TB = "4";//tb
        String B = "5";//b
    }

    public interface NGKM_FDBK_CFG_WKUNTT {
        String HOUR = "1";
        String MINUTE = "2";
    }


    //操作状态代码
    public interface NGKM_KNOWLEDGE_OPERSTATE {
        String SUCCESS = "0";//成功
        String FAILED = "1";//失败
    }

    //操作类型类型代码
    public interface NGKM_KNOWLEDGE_OPERTYPE {
        String INSERT = "1";//新增
        String UPDATE = "2";//发起更新
        String DELETE = "3";//删除
        String REVERT = "4";//撤回
        String REJECT = "5";//驳回
        String PASS = "6";//审核通过
        String REVISE = "7";//修改草稿
        String SUBMIT = "8";//提交
        String RESTORE = "9";//还原
        String COMPLETE_DELETE = "10";//彻底删除
    }

    //工作组相关
    public interface NGKM_STAFF_GROUPS {
        String PREFIX = "000245"; //前缀
        String COUNTRY_CODE = "000"; //国家代码
        String VIEW = "000";//查看组后缀
        String EDIT = "001";//采编组后缀
        String CHECK = "002";//审核组后缀
        String FDBK = "003";//反馈组后缀
    }

    //推荐知识相关
    public interface NGKM_RECOMMEND_KNLG_GROUPS {
        String KLG_STATE_RECOM__BUSINESS = "1";//推荐业务
        String KLG_STATE_RECOM_ACTIVITIES = "2";//推荐活动
    }

    public interface NGKM_PRE_GATHR_KNWLG_TYPE {
        String NGKM_NORMAL_KNWLG_TYPE = "1";//普通知识
        String NGKM_PRE_GATHR_KNWLG_TYPE = "2";//预采编知识
    }

    //时间类型单位
    public interface NGKM_ATOM_PARAM_TIMES_WKUNIT {
        String SECOND = "1";//秒
        String MINUTE = "2";//分钟
        String HOUR = "3";//小时
        String DAY = "4";//天
        String MONTH = "5";//月
        String QUARTER = "6";//季度
        String HALF_YEAR = "7";//半年
        String YEAR = "8";//年
        String TWO_YEAR = "9";//两年
        String THREE_YEAR = "10";//三年
    }

    public interface NGKM_ATOM_ISSEARCH_FIELD {
        String BOSSCODE = "bossCode";
        String BOSSNAME = "bossName";
        String ENDTIME = "endTime";
        String SIMPLEINTRO = "simpleIntro";
        String STARTTIME = "startTime";
        String OPENSTATE = "openState";
        String CONTINENT = "continent";
    }

    public interface DATA_DICTIONARY {
        String TEMPLET_CHNL = "NGKM.TEMPLET.CHNL";
    }

    //模板原子隐藏标志
    public interface NGKM_TMPLT_HIDE_FLAG {
        String SHOW = "0";
        String HIDE = "1";
    }

    //模板状态
    public interface NGKM_TMPLT_STS_CD {
        String HIDE = "2";
        String NORMAL = "1";//正常
        String REMOVED = "0";//删除状态
    }

    public interface NGKM_TMPLT_GRPNG_FILTER_STS_CD {
        String NORMAL = "1";//正常
        String REMOVED = "0";//删除状态
    }

    /**
     * 模板分组、筛选条件与原子的对应关系表
     */
    public interface NGKM_TMPLT_KEY_OBJ_REL {
        //分组对应关系
        String GROUPS = "1";
        //筛选条件
        String FILTER = "2";
    }

    public interface NGKM_TMPLT_KEYEXT_STS_CD {
        //正常
        String NORMAL = "1";
        //删除状态
        String REMOVED = "0";
    }

    //模板原子必填标志
    public interface NGKM_TMPLT_REQUIRE_FLAG {
        String NOT_REQUIRE = "0";
        String REQUIRE = "1";
    }

    //模板原子必填标志
    public interface NGKM_TMPLT_KEYS_HIDE {
        String NOT_HIDE = "0";
        String HIDE = "1";
    }

    //模板原子删除状态
    public interface NGKM_TMPLT_ATOM_STS_CD {
        String NORMAL = "1";//正常
        String REMOVED = "0";//删除状态
    }

    public interface NGKM_CHNL_CODE {
        String CUSTOMERSERVICE = "1";
    }

    //最新知识定义距离当前几天内为最新知识
    public interface NGKM_NEWEST_KNOWLEDGE_DAY_CODE {
        String KNOWLEDGE_DAYS = "245004001";
    }

    //个性化设置信息
    public interface TKM_SEARCH_DESINGER {
        //状态
        String TKM_SEARCH_SCENE = "scene"; //场景
        String TKM_SEARCH_URTS = "urts"; //默认页签
        String TKM_SEARCH_TITLE = "title";//搜索题头配置

        //参数类型
        String TKM_PARMA_TYPE_1 = "1";
        String TKM_PARMA_TYPE_2 = "2";
        String TKM_PARAM_TYPE_3 = "3";

    }

    //原子索引
    public interface NGKM_TASK_TYPE {
        String DELETE_CACHE = "1";//删除缓存
        String ALL_KNWLG_INDEX = "2";//全量知识索引
        String TMPLT_KNWLG_INDEX = "3";//模板知识索引
        String SINGLE_KNWLG_INDEX = "4";//单个知识索引
        String ALL_ATOM_INDEX = "5";//全量原子索引
        String TMPLT_ATOM_INDEX = "6";//模板原子索引
        String SINGLE_ATOM_INDEX = "7";//单个原子索引
        String REGN_KNWLG_INDEX = "8";//单个原子索引
        String REGN_ATOM_INDEX = "9";//单个原子索引
        String SCAN_EXPR_KNWLG = "10";//扫描过期知识
        String UPDATE_TMPLT_INDEX = "11";//知识模板修改时刷新原子参数类型  与手动采用模板刷新原子区分开
        String UPDATE_TMPLT_KNWLG = "12";//知识模板修改时刷新知识参数类型  与手动采用模板刷新知识区分开


        //String KNWLG_UNION_INDEX = "13";//知识索引稽核
        //String ATOM_UNION_INDEX = "14";//原子索引稽核
        String CREATE_CONSULT_DATA_INDEX = "15";//咨询表记录索引
        String CREATE_CONSULT_INDEX = "16";//咨询表索引

        String KNWLG_UNION_ALL_INDEX = "19";//全量知识索引稽核
        String KNWLG_UNION_REGN_INDEX = "17";//地域知识索引稽核
        String KNWLG_UNION_TMPLT_INDEX = "18";//模板知识索引稽核

        String KNWLG_BRWS_PRIV = "20";//地区知识权限任务
        String TMPLT_BRWS_PRIV = "21";//模板知识权限任务
        String SINGLE_BRWS_PRIV = "22";//单个知识权限任务
        String PUS_BRWS_PRIV_MOVE = "23";//发布知识权限拆分
        String EDIT_BRWS_PRIV_MOVE = "24";//草稿权限
    }

    //知识发布任务状态
    public interface NGKM_PUS_TASK_TYPE {
        Byte KNWLG_ADD = 1;//新增
        Byte KNWLG_UPDATE = 2;//更新
        Byte KNWLG_DELETE = 3;//删除
        Byte ONLY_KNWLG_INDEX = 4;//只刷新知识索引
        Byte RELEAT_KNWLG_CACHE = 5;//采编知识时  刷新关联知识缓存
        Byte TMPLT_UPDATE = 6;//模板更新  刷新模板下的知识索引
    }

    //任务关联对象类型
    public interface NGKM_TASK_OBJ_TYPE_CD {
        Byte KNWLG = 1;//关联知识
        Byte TMPLT_KNWLG = 2;//关联模板
    }

    //任务状态
    public interface NGKM_TASK_STATE {
        Byte NOT_BEGIN = 0;//未开始
        Byte RUNNING = 1;//执行中
        Byte END_SUCCESS = 2;//成功结束
        Byte END_FAILED = 3;//失败结束
    }

    //搜索关键词知识-生失效按钮状态
    public interface NGKM_SEARCH_EFF_EXP_STATE_BTN {
        String KEYWORDS_EE_BTN_TYPE_1 = "1";//1-全部
        String KEYWORDS_EE_BTN_TYPE_2 = "2";//2-正常
        String KEYWORDS_EE_BTN_TYPE_3 = "3";//3-已下线
        String KEYWORDS_EE_BTN_TYPE_4 = "4";//4-未上线
    }

    //搜索关键词知识-区域按钮状态
    public interface NGKM_SEARCH_AREA_BTN {
        String KEYWORDS_AREA_BTN_TYPE_1 = "1";//1-全部
        String KEYWORDS_AREA_BTN_TYPE_2 = "2";//2-全国
        String KEYWORDS_AREA_BTN_TYPE_3 = "3";//3-省份
        String KEYWORDS_AREA_BTN_TYPE_4 = "4";//4-地市
    }

    //搜索关键词知识-搜索范围类型
    public interface NGKM_SEARCH_KM_TITLE_TYPE {
        String KEYWORDS_TITLE_TYPE_1 = "1";//1-标题
        String KEYWORDS_TITLE_TYPE_2 = "2";//2-全文
        String KEYWORDS_TITLE_TYPE_3 = "3";//3-搜索含有图片知识
        String KEYWORDS_TITLE_TYPE_4 = "4";//4-搜索含有音视频知识
        String KEYWORDS_TITLE_TYPE_5 = "5";//5-根据模板Id搜索相关知识
    }

    //搜索关键词知识-查询字段的权重 数值越大 优先查询
    public interface NGKM_SEARCH_KM_FILED_WEIGHT_TYPE {
        int KEYWORDS_FILED_WEIGHT_1 = 10;
        int KEYWORDS_FILED_WEIGHT_2 = 8;
        int KEYWORDS_FILED_WEIGHT_3 = 5;
        int KEYWORDS_FILED_WEIGHT_4 = 1;
    }

    //搜索关键词知识-过滤文本类型-参数中无附件、图片类型标示
    public interface NGKM_NO_SEARCH_KM_FILED {
        String KEYWORDS_NO_SERACH_FILED_TYPE = "1#2#3#4#5#6#7#8#9#11#12#14#15#16";
    }

    //搜索关键词知识-筛选条件类型
    public interface NGKM_SEARCH_KM_FILTER_CONDS_TYPE {
        String SINGLESELECT = "1";//1-单选radio
        String MUTILSELECT = "2";//2-多选checkbox
        String RANGESELECT = "3";//3-区间range
        String DISTRICT = "4";//4-联动区域select
    }

    //搜索关键词知识-流量单位枚举类型 b-5
    public interface NGKM_SEARCH_KM_DATA_TRAFFIC_TYPE {
        String B_UNIT = "5";//b-对应的枚举类型
    }

    //搜索关键词知识-参数编码
    public interface NGKM_SEARCH_KM_PARAM_CODE {
        String COUNTY_CODE = "000";//国家编码
        String DATE_FORMAT_YYYYMMDD = "yyyy-MM-dd";//时间格式
    }

    //搜索关键词知识-区域级别
    public interface NGKM_SEARCH_KM_AREA_LEVEL {
        String AREA_LEVEL_1 = "1";//级别全国
        String AREA_LEVEL_2 = "2";//级别为省or直辖市
        String AREA_LEVEL_3 = "3";//级别为市or直辖市地区
    }


    //任务接收人员类型
    public interface NGKM_RCVPRSN_TYPE {
        String USER = "1";//人员类型
        String REGN = "2";//地区类型
    }

    //任务状态代码
    public interface NGKM_TASK_STSCD {
        String NO_PUS = "0";//待发起
        String HAS_PUS = "1";//已发起
        String NO_ACCEPT = "2";//待接应
        String HAS_ACCEPT = "3";//已接应
        String COMPILE = "4";//已完成
    }

    //任务操作状态
    public interface NGKM_TASK_PRSN_CD {
        String PUS_TASK = "1";//发起
        String ACCEPT_TASK = "3";//接应
        String COMPILE_TASK = "4";//完成
        String BACK_TASK = "5";//撤回
        String REJECT_TASK = "6";//驳回
    }

    //咨询表相关常量
    public interface NGKM_CONSULT_PARAM {
        String CONSULT_ROW_PREFIX = "t_km_consult_rows_";//咨询表行记录前缀
        String CONSULT_DATA_PREFIX = "t_km_consult_data_";//咨询表行内容前缀
    }

    //咨询表字段是否必填
    public interface NGKM_CONSULT_ISREQUIRED {
        String REQUIRED = "1";//必填
        String NO_REQUIRED = "0";//非必填
    }

    //咨询表查询运算符
    public interface NGKM_CONSULT_OPERATION_TYPE {
        String EQUAL = "equal";//等于
        String NOT_EQUAL = "notEqual";//不等于
        String CONTAIN = "contain";///包含
        String NOT_CONTAIN = "notContain";//不包含
        String GREATER_THAN = "gt";//大于
        String LESS_THAN = "lt";//小于
    }

    //咨询表字段类型
    public interface NGKM_CONSULT_COLM_TYPE {
        String NUM = "num";//数字类型
        String DATE = "date";//日期类型
        String REL = "rel";//关联知识类型
        String MES = "mes";//短信类型
        String CHAR = "char";//字符串类型
    }

    //任务计划类型代码
    public interface NGKM_TASK_PLAN_TYLE_CD {
        String GATHR_TASK = "1";//采编任务
        String DOC_TASK = "2";//公文任务
    }

    //系统参数
    public interface NGKM_BUS_SYS_DATA {
        String BUS_TMPLTID_CD = "245006001";//网点信息模板参数
        String BUS_BGN_TIME_KEYCODE = "245006002";//预计营业时间原子ID
        String BUS_STS_KEYCODE = "245006003";//营业状态原子id
        String BUS_TASK_UPDATE_KEYCODES = "245006004";//任务更新原子id
        String BUS_STS_VALUE = "245006005";//网点状态变更
    }


    //强关联文件状态
    public interface NGKM_SOURCE_STATE {
        String SOURCE_NORMAL = "1";
        String SOURCE_DELETE = "2";
    }


    public interface SERVICE_TYPE_ID {
        String XJH = "xjhytck";


    }

    //批量权限操作类型
    public interface NGKM_BRWS_PRIV_TYPE {
        Byte ADD_KNWLG_BRWS = 1;//新增知识权限
        Byte DEL_KNWLG_BRWS = 2;//删除知识权限
        Byte ADD_ATOM_BRWS = 3;//新增原子权限
        Byte DEL_ATOM_BRWS = 4;//删除原子权限权限
        Byte KNWLG_INDEX_INCLUDE_ATOM = 5;//刷新知识  包含原子权限
        Byte BATCH_TASK_KNWLG_BRWS_ADD = 6;//批量新增知识权限任务
        Byte BATCH_TASK_KNWLG_BRWS_DEL = 7;//批量删除知识权限任务
        Byte BATCH_TASK_ATOM_ADD = 8;//批量新增原子权限任务
        Byte BATCH_TASK_ATOM_DEL = 9;//批量删除原子权限
    }

    //工作组浏览权限配置相关常量
    public interface NGKM_BRWS_PRIV_PARAM {
        String ATOM_BRWS_PRIV_PREFIX = "t_km_atom_brws_priv_";//关联原子记录前缀
    }

    //各省地区编码
    public interface NGKM_PROVNCE_CODE {
        String[] PROVNCE = {"100", "200", "210", "220", "230", "240", "250", "270", "280", "290", "311", "351", "371", "431", "451",
                "471", "531", "551", "571", "591", "731", "771", "791", "851", "871", "891", "898", "931", "951", "971", "991"};

    }

    /**
     * 特殊字符编码
     */
    public interface NGKM_SEPCIAL_CODE {
        String SPECIAL_CHARTER = "NGKM.SPECIAL.CHARTER";
    }

    /**
     * 时限限制类型
     */
    public interface NGKM_TIMEBOUND_TYPE {
        String NKNOWLEDGE_APPROVE = "1";//知识审核
        String NKNOWLEDGE_RELEASE = "2";//知识发布
        String CUSTOMER_TASK_DISTRIBUTION = "3";//客户化任务分发
        String QUESTIONKNOWLEDGE_AND_MULTIMEDIA_DOC = "4";//问答知识及多媒体采编
    }

    /**
     * 时限限制类别
     */
    public interface NGKM_TIMEBOUND_CLASSES {
        String TIMEBOUND_GENERAL = "1";//普通
        String TIMEBOUND_URGENCY = "2";//紧急
    }

    /**
     * 回答评价
     */
    public interface NGKM_ANSWER_GRADE {
        String NO_EVALUATION = "0";//未评价
        String PRAISE = "1";//赞
        String TRAMPLE = "2";//踩
    }

    /**
     * 是否有回答
     */
    public interface NGKM_IS_ANSWER {
        String HAVE_NOT_ANSWER = "0";//否
        String HAVE_ANSWER = "1";//是
    }

    /**
     * 处理状态
     */
    public interface NGKM_HANDLE_STATE {
        String UNTREATED = "0";    //待处理
        String TREATED = "1";      //已处理
    }

    /**
     * 质检类型
     */
    public interface QM_CHECK_TYPE {
        String VOICE = "0";       //语音质检
        String ORDER = "1";       //工单质检
    }

    /**
     * 考评模版节点类型
     */
    public interface QM_TEMPLATE_NODE_TYPE {
        String ROOT_NODE = "0";   //根节点考评模板
        String OBJECT = "1";      //考评对象
        String CATEGORY = "2";    //考评类别
        String CHECK_ITEM = "3";  //考评项
    }

    /**
     * 质检池质检状态
     */
    public interface QM_CHECK_STATUS {
        String CHECKING = "0";   //待质检
        String RECHECKING = "1"; //待复检
        String CHECKED = "2";    //已质检
    }

    /**
     * 质检池分配状态
     */
    public interface QM_DISTRIBUTE_STATUS {
        String NO = "0";           //未分配
        String TRUE = "1";         //已分配
    }

    /**
     * 质检结果状态
     */
    public interface QM_CHECK_RESULT {
        String NEW_BUILD = "0";     //质检新生成
        String TEMP_SAVE = "1";     //临时保存
        String ABANDON = "2";       //放弃
        String RECHECK = "3";       //复检
        String DEPART_CHECK = "4";  //分检
        String CHECKED = "5";       //被检人确认
        String SYS_CHECKED = "6";   //系统自确认
        String APPEALING = "7";     //申诉中
        String APPEAL_PASS = "8";   //申诉通过
        String APPEAL_DENY = "9";   //申诉驳回
        String SYS_DENY = "99";     //系统驳回
    }

    /**
     * 质检结果状态
     */
    public interface QM_LAST_CHECK_RESULT {
        String FALSE = "0";        //非最新质检结果
        String TRUE = "1";         //最新质检结果
    }

    /**
     * 申诉流程状态
     */
    public interface QM_APPEAL_PROCESS_STATUS {
        String DISABLE = "0";      //未启动
        String ENABLE = "1";       //启动
        String PAUSE = "2";        //暂停
    }

    /**
     * 质检申诉状态
     */
    public interface QM_APPEAL_STATUS {
        String APPEALING = "0";    //提起申诉|申诉中
        String PASS = "1";         //通过
        String REJECT = "2";       //驳回
        String SYS_REJECT = "3";   //系统自动驳回
    }

    /**
     * 审批结果
     */
    public interface QM_APPROVE_STATUS {
        String PASS = "0";         //通过
        String DENY = "1";         //驳回
    }

    /**
     * 审批结果
     */
    public interface QM_APPEAL_PROCESS_TYPE {
        String MAIN = "0";        //主流程
        String SUB = "1";         //子流程
    }

}
