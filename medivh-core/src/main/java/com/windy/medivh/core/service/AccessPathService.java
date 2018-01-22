package com.windy.medivh.core.service;

/**
 * Created by zhangweifeng on 2017/3/20.
 */
public interface AccessPathService {

    String findAccessPath(String personUrl) throws Exception;

    String findAccessPathWithExt(String personUrl) throws Exception;
}
