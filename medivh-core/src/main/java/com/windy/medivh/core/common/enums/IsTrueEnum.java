package com.windy.medivh.core.common.enums;

import lombok.Getter;

public enum IsTrueEnum {
    NO(0, "不正确"),
    YES(1,"正确");

    @Getter
    private int code;

    @Getter
    private String desc;

    IsTrueEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
