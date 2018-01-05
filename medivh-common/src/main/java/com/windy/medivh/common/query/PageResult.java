package com.windy.medivh.common.query;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageResult<X> implements Serializable{
    private static final long serialVersionUID = 1L;

    private List<X> result;

	private int pageNo = BaseQuery.DEFAULT_PAGE;

	private int totalCount; // 总的数目

	private int pageSize = BaseQuery.DEFAULT_PAGE_SIZE; //每一页数目

	public List<X> getResult() {
		return result;
	}

	public void setResult(List<X> result) {
		this.result = result;
	}

    public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	@JsonIgnore
	public int getTotalPage() {
        if(pageNo < 1){
            pageNo = BaseQuery.DEFAULT_PAGE;
        }
		return totalCount / pageSize + (totalCount % pageSize == 0 ? 0 : 1);
	}

	public static <S,T>  PageResult<S> convertEmptyPageResult(PageResult<T> pageResult){
		PageResult<S> emptyPageResult = new PageResult<>();
		emptyPageResult.setPageNo(pageResult.getPageNo());
		emptyPageResult.setPageSize(pageResult.getPageSize());
		emptyPageResult.setResult(Collections.emptyList());
		emptyPageResult.setTotalCount(pageResult.getTotalCount());

		return emptyPageResult;
	}

	public static <S>  PageResult<S> emptyPageResult(int pageNo,int pageSize){
		PageResult<S> emptyPageResult = new PageResult<>();
		emptyPageResult.setPageNo(pageNo);
		emptyPageResult.setPageSize(pageSize);
		emptyPageResult.setResult(Collections.emptyList());
		emptyPageResult.setTotalCount(0);

		return emptyPageResult;
	}


	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
