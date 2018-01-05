package com.windy.medivh.common.form;

import com.windy.medivh.common.query.BaseQuery;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by songshuang on 17/3/11.
 */
@Data
public class PageForm implements Serializable{
    private static final long serialVersionUID = 1370601692374984844L;

    protected Integer pageSize = BaseQuery.DEFAULT_PAGE_SIZE;
    protected Integer pageNo = BaseQuery.DEFAULT_PAGE;


    private Integer totalRecord;//总记录数

    private Integer currentRow;//总记录数

    private Integer pageOffset;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
