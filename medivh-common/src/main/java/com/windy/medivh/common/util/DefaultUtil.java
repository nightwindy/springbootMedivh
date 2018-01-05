package com.windy.medivh.common.util;

public class DefaultUtil {

    public static Boolean value(Boolean b) {
        if (b == null) {
            return false;
        } else {
            return b;
        }
    }

    public static Integer value(Integer i) {
        if (i == null) {
            return 0;
        } else {
            return i;
        }
    }

    public static Long value(Long l) {
        if (l == null) {
            return 0L;
        } else {
            return l;
        }
    }
}
