package com.windy.medivh.common.entity;

import java.io.Serializable;

/**
 * 适用于系统间的通信数据交互
 * Created by qinyisheng on 16/9/30.
 */
public class APIResult<T> implements Serializable{

    private static final long serialVersionUID = -2982140134881098235L;

    /**
     * 成功标识
     */
    private boolean success = false;

    /**
     * 返回结果code
     */
    private String code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 无参构造器
     */
    public APIResult(){}

    /**
     * 含参构造器
     * @param success
     * @param data
     * @param code
     * @param message
     */
    public APIResult(boolean success, T data, String code, String message) {
        this.success = success;
        this.data = data;
        this.code = code;
        this.message = message;
    }

    /**
     * @return APIResult<T>
     */
    public static <T> APIResult<T> create() {
        return new APIResult<T>();
    }

    /**
     * 快速创建Result的方法 -create APIResult<T> Object for successful cases.
     *
     * @param data
     *            result data
     * @return APIResult<T>
     */
    public static <T> APIResult<T> create(T data) {
        APIResult<T> result = APIResult.create();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    /**
     * 接口调用成功时也需要code和message的场景
     *
     * @param data
     * @param code
     * @param message
     * @return
     */
    public static <T> APIResult<T> create(T data, String code, String message) {
        APIResult<T> result = APIResult.create();
        result.setSuccess(true);
        result.setData(data);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     * 任意场景
     *
     * @param isSuccess
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static <T> APIResult<T> create(T data, boolean isSuccess, String code, String message) {
        APIResult<T> result = APIResult.create();
        result.setSuccess(isSuccess);
        result.setData(data);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     * create APIResult<T> Object for unsuccessful cases.
     *
     * @param code
     *            result code
     * @param message
     *            result code
     * @return APIResult<T>
     */
    public static <T> APIResult<T> create(String code, String message) {
        APIResult<T> result = APIResult.create();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     * @param errorCodeEnum
     * @param <T>
     * @return
     */
    public static <T> APIResult<T> create(ErrorCodeEnum errorCodeEnum) {
        APIResult<T> result = APIResult.create();
        result.setSuccess(false);
        result.setCode(errorCodeEnum.getErrCode());
        result.setMessage(errorCodeEnum.getErrMsg());
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
