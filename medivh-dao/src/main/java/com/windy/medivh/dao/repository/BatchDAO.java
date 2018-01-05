package com.windy.medivh.dao.repository;

import java.util.List;

/**
 * Created by chris on 2017/7/26 下午2:45.
 */
public interface BatchDAO<T> {

    public void batchInsert(List<T> list);

    public void batchUpdate(List<T> list);
}