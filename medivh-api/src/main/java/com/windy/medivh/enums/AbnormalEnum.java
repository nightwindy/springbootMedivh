package com.windy.medivh.enums;

import lombok.Getter;

public enum AbnormalEnum {

    NORMAL(1, "正常"),
    ABNORMAL(0,"异常");

    @Getter
    private int code;

    @Getter
    private String desc;

    AbnormalEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String valueOf(int code) {
        for (AbnormalEnum tmp : values()) {
            if (tmp.code == (code)) {
                return tmp.getDesc();
            }
        }
        return null;
    }
}
