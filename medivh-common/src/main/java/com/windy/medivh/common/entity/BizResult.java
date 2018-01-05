package com.windy.medivh.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.windy.medivh.common.query.BaseQuery;

import java.io.Serializable;
import java.util.Map;

/**
 * 扩展了APIResult，增加补充数据Map
 * Created by qinyisheng on 16/9/30.
 */
public class BizResult<T> implements Serializable {
    /**
     * 是否成功
     */
    private boolean success = false;

    /**
     * 返回结果码
     */
    private String code;

    /**
     * 返回结果描述
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    /**
     * 补充数据
     */
    private Map<String, Object> extraInfo;

    /**
     * 分页查询返回字段
     */
    private int pageNo = BaseQuery.DEFAULT_PAGE;

    /**
     * 总的数目
     */
    private int totalCount;

    /**
     * 每一页数目
     */
    private int pageSize = BaseQuery.DEFAULT_PAGE_SIZE;

    public static <T> BizResult<T> success(T data){
        return create(data);
    }

    public static <T> BizResult<T> empty(){
        BizResult<T> result = create();
        result.setSuccess(true);
        return result;
    }

    public static <T> BizResult<T> error(String code, String message) {
        return create(code,message);
    }

    public static <T,S> BizResult<T> error(BizResult<S> errorBizResult){
        return error(errorBizResult.getCode(),errorBizResult.getMessage());
    }

    public static <T> BizResult<T> paramsError(String msg){
        return BizResult.error(ErrorCodeEnum.PARAM_ERROR.getErrCode(),
                ErrorCodeEnum.PARAM_ERROR.getErrMsg() + "：" + msg
        );
    }

    public static <T> BizResult<T> bizError(String msg){
        return BizResult.error(
                ErrorCodeEnum.BIZ_EXCEPTION.getErrCode(),
                ErrorCodeEnum.BIZ_EXCEPTION.getErrMsg() + "：" + msg
        );
    }
    public static <T> BizResult<T> systemError(String msg){
        return BizResult.error(
                ErrorCodeEnum.EXCEPTION.getErrCode(),
                ErrorCodeEnum.EXCEPTION.getErrMsg() + "：" + msg
        );
    }
    
    public BizResult() {
    }
    
    public static <T> BizResult<T> create() {
        return new BizResult<T>();
    }

    /**
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BizResult<T> create(T data) {
        BizResult<T> bizResult = create();
        bizResult.setSuccess(true);
        bizResult.setData(data);
        return bizResult;
    }

    /**
     * 接口调用成功时也需要code和message的场景
     * @param data
     * @param code
     * @param message
     * @return
     */
    public static <T> BizResult<T> create(T data, String code, String message) {
        BizResult<T> result = BizResult.create();
        result.setSuccess(true);
        result.setData(data);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     * 任意场景
     * @param isSuccess
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static <T> BizResult<T> create(T data, boolean isSuccess, String code, String message) {
        BizResult<T> result = BizResult.create();
        result.setSuccess(isSuccess);
        result.setData(data);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     * @param data
     * @param extraInfo
     * @param <T>
     * @return
     */
    public static <T> BizResult<T> create(T data, Map<String,Object> extraInfo){
        BizResult<T> bizResult = create();
        bizResult.setSuccess(true);
        bizResult.setData(data);
        bizResult.setExtraInfo(extraInfo);
        return bizResult;
    }

    /**
     * @param data
     * @param extraInfo
     * @param isSuccess
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static <T> BizResult<T> create(T data, Map<String,Object> extraInfo, boolean isSuccess, String code, String message){
        BizResult<T> bizResult = create();
        bizResult.setSuccess(true);
        bizResult.setData(data);
        bizResult.setExtraInfo(extraInfo);
        bizResult.setSuccess(isSuccess);
        bizResult.setCode(code);
        bizResult.setMessage(message);
        return bizResult;
    }

    /**
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static <T> BizResult<T> create(String code, String message) {
        BizResult<T> bizResult = create();
        bizResult.setSuccess(false);
        bizResult.setCode(code);
        bizResult.setMessage(message);
        return bizResult;
    }

    /**
     *
     * @param errorCodeEnum
     * @param <T>
     * @return
     */
    public static <T> BizResult<T> create(ErrorCodeEnum errorCodeEnum) {
        BizResult<T> bizResult = create();
        bizResult.setSuccess(false);
        bizResult.setCode(errorCodeEnum.getErrCode());
        bizResult.setMessage(errorCodeEnum.getErrMsg());
        return bizResult;
    }

    public Map<String, Object> getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(Map<String, Object> extraInfo) {
        this.extraInfo = extraInfo;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
