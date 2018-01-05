package com.windy.medivh.common.model.request;

import lombok.Data;

/**
 * Created by chris on 2017/1/19 上午10:51.
 */
@Data
public class FpRiskRuleReq extends BaseDubboRequest {

    private Long riskRuleId;

    private String riskRuleTitle;

    private String riskRuleDetail;

    private String sendWay;

    private Integer status;

    /**
     * json数组
     * key:mobile,adminId,email
     */
    private String targetUser;

    private Integer retryType;

    private Long retryVal;

    private Long effectTime;

    private String msgTemplate;

    private Integer riskBizType;

    private String riskRuleSql;

    private Integer riskLevel;

    private String riskSolution;

    private String templateKey;

}
