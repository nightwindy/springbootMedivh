package com.windy.medivh.core.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DecimalUtil {

    public static BigDecimal valueOf(Long v1) {
        if (v1 == null) {
            return new BigDecimal(0);
        } else {
            return BigDecimal.valueOf(v1);
        }
    }

    public static Long valueOf(BigDecimal v1) {
        if (v1 == null) {
            return 0L;
        } else {
            return v1.longValue();
        }
    }

    /**
     * 转化成百分号
     * @param v1
     * @return
     */
    public static String getPercent(BigDecimal v1){

        DecimalFormat df = new DecimalFormat("0.00%");
        if(v1==null){
            return "0.00%";
        }
        return df.format(v1);
    }

    /**
     * 百分号转化成小数
     */
    public static BigDecimal getBigDecimal(String percent){
        if(percent==null){
            return BigDecimal.ZERO;
        }
        percent.replace("%","");
        Double d = Double.valueOf(percent)/100;
        return new BigDecimal(d);
    }

    public static void main(String[] args){
        System.out.println(getPercent(new BigDecimal("0.66666")));
    }
}
