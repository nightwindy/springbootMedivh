package com.windy.medivh.common.entity;

/**
 * 错误码枚举类
 * Created by qinyisheng on 16/9/30.
 */
public enum ErrorCodeEnum {

    SUCCESS("1001", "成功"),
    NO_DATA("1002", "无数据"),
    PARAM_ERROR("1003", "参数错误"),
    INSERT_FAIL("1004", "插入数据错误"),
    QUERY_FAIL("1005", "查询错误"),
    UPDATE_FAIL("1006", "修改数据错误"),
    DATA_ERROR("1008", "数据异常"),
    DUPLICATE_ERROR("1009", "重复操作"),
    NO_AUTH("1010", "没有权限,请联系@婷姐进行授权"),
    UPLOAD_ERROR("1011", "文件上传失败"),
    SIGN_ERROR("1012", "esign 签章失败"),
    SEND_SIGNCODE_ERROR("1013", "发送esign验证码失败"),
    INIT_ESIGN_ERROR("1014", "初始化esign开发者账号错误"),
    LOGIN_ESIGN_ERROR("1015", "登陆esign错误"),
    CREATE_ACCOUNT_ERROR("1016", "创建esign账号错误"),
    CREATE_SEAL_ERROR("1017", "创建印章错误"),
    INVALID_LOANORDER("1018", "异常的订单宝"),
    WRONG_SIGNCODE("1019", "错误的验证码"),
    EMPTY_USER("1020", "获取用户为空"),
    DING_DING_USER_ERROR("1021", "获取钉钉用户信息错误"),
    CHECK_ADMIN_ERROR("1022", "校验用户信息失败"),
    USER_NOT_EXISTS("1023", "用户不存在"),
    PARTNER_NOT_EXISTS("1024", "商家不存在"),
    MATCH_CAR_ERROR("1025", "查询车辆信息失败"),
    MATCH_COLOR_ERROR("1026", "匹配颜色信息失败"),
    MATCH_PRICE_ERROR("1027", "匹配价格失败"),
    MATCH_FRAME_NO_ERROR("1028", "匹配车架号失败"),
    USER_NAME_PASSWORD_ERROR("1029", "用户名或密码错误"),
    NO_AUTHORIZED("1030", "用户未被授权"),
    NO_FUNCTION_ERROR("1031", "查询无任何功能"),
    NO_ROLE_ERROR("1032", "该用户无任何角色"),
    HAS_NO_TREATED_CAR("1033", "有未处理的车源"),
    UPPERLIMIT("1034", "报名数量超过5个了"),
    CERT_CHECK_EMPTY_ERROR("1035", "查询用户的check信息为空"),
    PUSH_ERROR("1036", "发送通知失败"),
    PARAM_DECODE_FAILED("1037", "参数转码失败"),

    WAREHOUSE_CLOSE_ERROR("2001","该仓库尚有车辆,不能进行关闭操作"),

    PAYMENT_NOT_FIND("3001","结算单不存在"),
    PAYMENT_HAS_FINISH("3002","结算单已完成"),
    BIZ_EXCEPTION("8888","业务异常"),
    EXCEPTION("9999", "系统异常"),;

    private String errMsg;

    private String errCode;

    ErrorCodeEnum(String errCode, String errMsg) {
        this.errMsg = errMsg;
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public String getErrCode() {
        return errCode;
    }
}
