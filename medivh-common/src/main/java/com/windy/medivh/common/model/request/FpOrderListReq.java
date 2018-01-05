package com.windy.medivh.common.model.request;

import lombok.Data;

/**
 * Created by eddy on 2017/3/3.
 */
@Data
public class FpOrderListReq extends BaseDubboRequest {
    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 车架号
     */
    private String carUnique;

    /**
     * 公司/经销商id
     */
    private Long dealerId;

    /**
     * 业务经理
     */
    private String manager;

    /**
     * 大区id
     */
    private Long regionId;

    /**
     * 申请时间
     */
    private String applyDate;

    /**
     *  仓库Id
     */
    private String wareHouseId;

}
