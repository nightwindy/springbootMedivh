package com.windy.medivh.core.ao;

import java.io.IOException;

public interface XhtmlService {
    //对html进行语法检查，确保其完全符合xhtml规范，否则itext to pdf会报错
    String toXhtml(String content) throws IOException;
}
