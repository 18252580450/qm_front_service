package com.asiainfo.qm.manage.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 原子单位转换工具
 */
public class UnitConvert {

    private static final Logger LOGGER = LoggerFactory.getLogger(UnitConvert.class);

    private UnitConvert(){}

    /**
     * 转换原子值为最小单位
     *
     * @param paramType 参数类型
     * @param value 实际值
     * @param unit 单位
     * @return 原始值
     * @throws GeneralException
     */
    public static String convertToSmallUnit(String paramType, String value, String unit) throws GeneralException{
        if(Constants.NGKM_ATOM_PARAM_TYPE.MEMORY.equals(paramType)){
            return convertMemoryToSmall(value, unit);
        }
        return value;
    }

    /**
     * 转换原子为原始值
     *
     * @param paramType 原子类型
     * @param value 最小单位值
     * @param unit 单位
     * @return 原始值
     * @throws GeneralException
     */
    public static String convertToOrigin(String paramType, String value, String unit) throws GeneralException{
        if(Constants.NGKM_ATOM_PARAM_TYPE.MEMORY.equals(paramType)){
            return convertMemoryToOrigin(value, unit);
        }

        return value;
    }

    /**
     * 转换内存类型至最小单位
     *
     * @param value 原始值
     * @param unit 单位
     * @return
     */
    private static String convertMemoryToSmall(String value, String unit) throws GeneralException{
        Double num;
        Double zero = (double)0;
        try{
            num = Double.valueOf(value);
            if(Constants.NGKM_ATOM_PARAM_RAMTYPE_WKUNIT.KB.equals(unit)){
                num *= 1024;
                if(zero.equals(num - num.longValue())){
                    return num.longValue() + "";
                }
                return num.toString();
            }else if(Constants.NGKM_ATOM_PARAM_RAMTYPE_WKUNIT.MB.equals(unit)){
                num *= (1024 * 1024);
                if(zero.equals(num - num.longValue())){
                    return num.longValue() + "";
                }
                return num.toString();
            }else if(Constants.NGKM_ATOM_PARAM_RAMTYPE_WKUNIT.GB.equals(unit)){
                num *= (1024 * 1024 * 1024);
                if(zero.equals(num - num.longValue())){
                    return num.longValue() + "";
                }
                return num.toString();
            }else if(Constants.NGKM_ATOM_PARAM_RAMTYPE_WKUNIT.TB.equals(unit)){
                num *= (1024 * 1024 * 1024 * 1024);
                if(zero.equals(num - num.longValue())){
                    return num.longValue() + "";
                }
                return num.toString();
            }
            return value;
        }catch(NumberFormatException e){
            LOGGER.error(e.getMessage(), e);
            throw new GeneralException("132117");
        }

    }

    /**
     * 将内存转换为原始值
     *
     * @param value 最小单位值
     * @param unit 单位
     * @return
     */
    private static String convertMemoryToOrigin(String value, String unit) throws GeneralException{
        Double num;//流量应该没有小数
        Double zero = (double)0;
        try{
            num = Double.valueOf(value);
            if(Constants.NGKM_ATOM_PARAM_RAMTYPE_WKUNIT.KB.equals(unit)){
                num /= 1024;
                if(zero.equals(num - num.longValue())){
                    return num.longValue() + "";
                }
                return num.toString();
            }else if(Constants.NGKM_ATOM_PARAM_RAMTYPE_WKUNIT.MB.equals(unit)){
                num /= (1024 * 1024);
                if(zero.equals(num - num.longValue())){
                    return num.longValue() + "";
                }
                return num.toString();
            }else if(Constants.NGKM_ATOM_PARAM_RAMTYPE_WKUNIT.GB.equals(unit)){
                num /= (1024 * 1024 * 1024);
                if(zero.equals(num - num.longValue())){
                    return num.longValue() + "";
                }
                return num.toString();
            }else if(Constants.NGKM_ATOM_PARAM_RAMTYPE_WKUNIT.TB.equals(unit)){
                num /= (1024 * 1024 * 1024 * 1024);
                if(zero.equals(num - num.longValue())){
                    return num.longValue() + "";
                }
                return num.toString();
            }else{
                return value;
            }
        }catch(NumberFormatException e){
            LOGGER.error(e.getMessage(), e);
            throw new GeneralException("132117");
        }
    }

    /**
     * 根据单位代码 获取单位值
     *
     * @param paramType 参数类型
     * @param unit 单位
     * @return
     */
    public static String getUnit(String paramType, String unit) throws GeneralException{
        if(Constants.NGKM_ATOM_PARAM_TYPE.PRICETIME_TYPE.equals(paramType)){
            return getPriceTimeUnit(unit);
        }
        if(Constants.NGKM_ATOM_PARAM_TYPE.MEMORY.equals(paramType)){
            return getMemoryUnit(unit);
        }
        if(Constants.NGKM_ATOM_PARAM_TYPE.TIME_PERIOD_TYPE.equals(paramType)){
            return getTimeUnit(unit);
        }
        return unit;
    }

    /**
     * 获取内存类型的单位
     *
     * @param unit
     * @return
     */
    private static String getMemoryUnit(String unit) throws GeneralException{
        if(Constants.NGKM_ATOM_PARAM_RAMTYPE_WKUNIT.B.equals(unit)){
            return "B";
        }else if(Constants.NGKM_ATOM_PARAM_RAMTYPE_WKUNIT.KB.equals(unit)){
            return "KB";
        }else if(Constants.NGKM_ATOM_PARAM_RAMTYPE_WKUNIT.MB.equals(unit)){
            return "MB";
        }else if(Constants.NGKM_ATOM_PARAM_RAMTYPE_WKUNIT.GB.equals(unit)){
            return "GB";
        }else if(Constants.NGKM_ATOM_PARAM_RAMTYPE_WKUNIT.TB.equals(unit)){
            return "TB";
        }
        return unit;
    }

    /**
     * 获取金额时间类型的单位
     *
     * @param unit
     * @return
     */
    private static String getPriceTimeUnit(String unit) throws GeneralException{
        if(Constants.NGKM_ATOM_PARAM_PRICEORTIMETYPE_WKUNIT.YUAN_MINUTE.equals(unit)){
            return "元/分钟";
        }
        if(Constants.NGKM_ATOM_PARAM_PRICEORTIMETYPE_WKUNIT.YUAN_HOUR.equals(unit)){
            return "元/小时";
        }
        if(Constants.NGKM_ATOM_PARAM_PRICEORTIMETYPE_WKUNIT.YUAN_DAY.equals(unit)){
            return "元/天";
        }
        if(Constants.NGKM_ATOM_PARAM_PRICEORTIMETYPE_WKUNIT.YUAN_MONTH.equals(unit)){
            return "元/月";
        }
        if(Constants.NGKM_ATOM_PARAM_PRICEORTIMETYPE_WKUNIT.YUAN_QUARTER.equals(unit)){
            return "元/季度";
        }
        if(Constants.NGKM_ATOM_PARAM_PRICEORTIMETYPE_WKUNIT.YUAN_HALF_YEAR.equals(unit)){
            return "元/半年";
        }
        if(Constants.NGKM_ATOM_PARAM_PRICEORTIMETYPE_WKUNIT.YUAN_YEAR.equals(unit)){
            return "元/年";
        }
        if(Constants.NGKM_ATOM_PARAM_PRICEORTIMETYPE_WKUNIT.YUAN_2YEAR.equals(unit)){
            return "元/两年";
        }
        if(Constants.NGKM_ATOM_PARAM_PRICEORTIMETYPE_WKUNIT.YUAN_3YEAR.equals(unit)){
            return "元/三年";
        }
        if(Constants.NGKM_ATOM_PARAM_PRICEORTIMETYPE_WKUNIT.YUAN_PERIOD.equals(unit)){
            return "元/账期";
        }
        return unit;
    }

    /**
     * 获取时间类型的单位
     *
     * @param unit 单位
     * @return
     * @throws GeneralException
     */
    private static String getTimeUnit(String unit) throws GeneralException{
        if(Constants.NGKM_ATOM_PARAM_TIMES_WKUNIT.SECOND.equals(unit)){
            return "秒";
        }else if(Constants.NGKM_ATOM_PARAM_TIMES_WKUNIT.MINUTE.equals(unit)){
            return "分钟";
        }else if(Constants.NGKM_ATOM_PARAM_TIMES_WKUNIT.HOUR.equals(unit)){
            return "小时";
        }else if(Constants.NGKM_ATOM_PARAM_TIMES_WKUNIT.DAY.equals(unit)){
            return "天";
        }else if(Constants.NGKM_ATOM_PARAM_TIMES_WKUNIT.MONTH.equals(unit)){
            return "月";
        }else if(Constants.NGKM_ATOM_PARAM_TIMES_WKUNIT.QUARTER.equals(unit)){
            return "季度";
        }else if(Constants.NGKM_ATOM_PARAM_TIMES_WKUNIT.HALF_YEAR.equals(unit)){
            return "半年";
        }else if(Constants.NGKM_ATOM_PARAM_TIMES_WKUNIT.YEAR.equals(unit)){
            return "年";
        }else if(Constants.NGKM_ATOM_PARAM_TIMES_WKUNIT.TWO_YEAR.equals(unit)){
            return "两年";
        }else if(Constants.NGKM_ATOM_PARAM_TIMES_WKUNIT.THREE_YEAR.equals(unit)){
            return "三年";
        }
        return unit;
    }

}
