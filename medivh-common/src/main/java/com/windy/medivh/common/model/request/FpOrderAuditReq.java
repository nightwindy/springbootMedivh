package com.windy.medivh.common.model.request;

import com.alibaba.fastjson.JSONObject;
import com.windy.medivh.common.entity.ordercenter.CarAndCapitalDTO;
import com.windy.medivh.common.entity.ordercenter.DocumentDTO;
import lombok.Data;

import java.util.List;

/**
 * Created by chris on 2017/3/1 下午7:51.
 */
@Data
public class FpOrderAuditReq extends BaseDubboRequest {

    /**
     * 单号
     */
    private String orderNo;
    /**
     * 业务类型
     */
    private Integer bizType;
    /**
     * 任务id
     * 管理当前任务执行动作
     */
    private String taskId;
    /**
     * 用户类型
     * 参照FpUserTypeEnum
     */
    private Integer userType;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 公司id
     */
    private Long partnerId;
    /**
     * 提交表单信息
     * 订单号也在里面
     */
    private JSONObject orderInfo;
    /**
     * 是否通过
     */
    private Boolean isThrough;
    /**
     * 是否驳回
     */
    private Boolean isReturn;
    /**
     * 审批备注
     */
    private String memo;
    /**
     * 动作类型
     */
    private String actionType;
    /**
     * 订单请求 审核凭证集合
     */
    private List<DocumentDTO> documentDTOs;
    /**
     * 订单拆单时的车辆和资方的匹配信息
     */
    private List<CarAndCapitalDTO> carAndCapitalDTOs;

}
