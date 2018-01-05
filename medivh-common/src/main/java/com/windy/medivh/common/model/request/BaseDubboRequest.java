package com.windy.medivh.common.model.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by chris on 2017/1/19 上午10:38.
 */
public class BaseDubboRequest implements Serializable {

    public static int DEFAULT_PAGE_SIZE = 20;  //  默认页大小

    public static int MAX_PAGE_SIZE = 100;      // 最大页大小

    public static int DEFAULT_PAGE = 1;  // 默认分页


    /**
     * 简单请求对象
     * 约定好直接往这里塞
     */
    @Getter
    @Setter
    private HashMap<String, Object> extInfo ;

    @Getter
    @Setter
    protected String correlationID = UUID.randomUUID().toString();

    @Getter
    @Setter
    private Date beginTime;

    @Getter
    @Setter
    private Date endTime;

    /**
     * distinct
     */
    @Getter
    @Setter
    protected boolean distinct;
    /**
     * order by clause.
     */
    @Getter
    @Setter
    protected String orderByClause;
    /**
     * page
     */
    protected Integer pageOffset;
    /**
     * pageNo
     */
    protected Integer pageNo = DEFAULT_PAGE;
    /**
     * page size
     */
    protected Integer pageSize = DEFAULT_PAGE_SIZE;

    public BaseDubboRequest() {
        calPageOffset();
    }

    public void clearPage() {
        this.pageSize = null;
        this.pageNo = null;
        this.pageOffset = null;
    }

    public Integer getPageOffset() {
        return pageOffset;
    }

    public void setPageOffset(Integer pageOffset) {
        this.pageOffset = pageOffset;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null || pageSize <= 0) {
            this.clearPage();
        } else if (pageSize > MAX_PAGE_SIZE) {
            this.pageSize = MAX_PAGE_SIZE;
        } else {
            this.pageSize = pageSize;
        }
        this.calPageOffset();
    }


    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo == null || pageNo < DEFAULT_PAGE) {
            this.clearPage();
        } else {
            this.pageNo = pageNo;
        }
        this.calPageOffset();
    }

    protected void calPageOffset() {
        if (null == pageSize || null == pageNo) {
            pageOffset = null;
        } else {
            pageOffset = (pageNo - 1) * pageSize;
        }
    }

}
