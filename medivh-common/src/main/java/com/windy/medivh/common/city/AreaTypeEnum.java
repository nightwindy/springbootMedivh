package com.windy.medivh.common.city;

import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bleedfly on 15/1/5.
 */
public enum AreaTypeEnum {

    /**
     * 区
     */
    BIGAREA(1, "区域"),

    /**
     * 省
     */
    PROVINCE(2, "省"),

    /**
     * 市
     */
    CITY(3, "市");

    private String desc;

    private Integer code;

    AreaTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getCode() {
        return code;
    }

    public static Set<Integer> getCodeList() {
        Set<Integer> codeSets = new HashSet<Integer>();
        for (AreaTypeEnum enume : AreaTypeEnum.values()) {
            codeSets.add(enume.getCode());
        }
        return codeSets;
    }

    public static String getCodeName(int code) {
        Assert.notNull(code, "code should not be null");
        for (AreaTypeEnum enume : AreaTypeEnum.values()) {
            if (enume.getCode() == code) {
                return enume.getDesc();
            }
        }
        return null;
    }
}
