package com.windy.medivh.common.model.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by huaian on 2017/2/8.
 */
@Data
public class FpRiskMessageReq extends BaseDubboRequest{
    private Integer riskLevel;

    private String riskRuleTitle;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date riskStartDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date riskEndDate;

    private String orderId;

    private Long riskId;

}
