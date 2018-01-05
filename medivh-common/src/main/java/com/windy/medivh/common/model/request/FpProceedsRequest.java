package com.windy.medivh.common.model.request;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * Created by nina on 2017/5/23.
 */
@Data
public class FpProceedsRequest extends BaseDubboRequest {

    /**
     * 收款订单 唯一标示
     */
    private String proceedsDetailNo;

    /**
     * 收款详情
     */
    private JSONObject proceedsDetailInfo;

}
