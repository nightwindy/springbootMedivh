/*
package com.medivh.core.service.mq;

import com.alibaba.fastjson.JSON;
import com.camaro.starter.mq.annotation.MQConsumer;
import com.camaro.starter.mq.base.AbstractMQPushConsumer;
import com.mhc.lincoln.core.ao.IDebtAO;
import com.mhc.lincoln.core.ao.IMessageAO;
import com.medivh.core.common.model.IsOverDueModel;
import DateUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

*/
/**
 * Created by XianGuo
 * Date: 2017-08-21 12:43
 * 来自风险预警的消息
 *//*

@Component
@Slf4j
@MQConsumer(topic = "trumpchi_risk", consumerGroup = "lincoln_risk_overdue", tag = "risk_fact")
public class RiskMessageConsumer extends AbstractMQPushConsumer {

    @Autowired
    private IMessageAO messageAO;


    @Autowired
    private IDebtAO debtAO;

    */
/**
     * 订单到期前后消息
     * 推送时间 早上10点到晚上8：30之前
     *//*

    @Override
    public boolean process(Object msgContent, Map map) {
        log.info("-----收到trumpchi的订单到期消息：{}", JSON.toJSONString(msgContent));
        if (msgContent == null) {
            log.warn("订单到期提醒消息内容为空");
            return true;
        }
        try {
            List<RiskInfo> riskInfoList = JSON.parseArray(JSON.toJSONString(msgContent), RiskInfo.class);

            // 转化成逾期数据
            List<IsOverDueModel> dueModelList = this.transform(riskInfoList);

            // 发送有问题的数据给相关钉钉用户
            messageAO.sendDingTalk(debtAO.judgeOverDueIsTrue(dueModelList));
            log.info("处理订单到期消息成功");
        } catch (Exception e) {
            log.error("订单到期消息格式错误！原因：{}", e.getMessage());
        }

        return true;
    }

    */
/**
     * 转化数据
     *//*

    private List<IsOverDueModel> transform(List<RiskInfo> riskInfoList) {

        List<IsOverDueModel> resultList = new ArrayList<>();
        if (CollectionUtils.isEmpty(riskInfoList)) {
            return resultList;
        }

        for (RiskInfo item : riskInfoList) {

            if (CollectionUtils.isEmpty(item.getOrderItems())) {
                continue;
            }

            for (RiskDataInfo temp : item.getOrderItems()) {
                // 获取订单信息
                if (temp.getOrderInfo() == null || !temp.isNotOverdue()) {
                    continue;
                }

                IsOverDueModel model = new IsOverDueModel();
                RiskOrderInfo orderInfo = temp.getOrderInfo();
                model.setOrderNo(orderInfo.getOrderNo());
                Date overdueDate = DateUtil.getDateFromString(orderInfo.getOnloanDeadLine(), DateUtil.FORMAT_DATE);
                model.setOverDueTime(new Timestamp(overdueDate == null ? System.currentTimeMillis() : overdueDate.getTime()));
                resultList.add(model);
            }

        }
        return resultList;
    }


    @Data
    private static class RiskInfo {

        */
/**
         * 预警规则
         *//*

        private Long riskRuleId;
        */
/**
         * 预警标题
         *//*

        private String riskRuleTitle;

        */
/**
         * 预警订单信息
         *//*

        private List<RiskDataInfo> orderItems;

        */
/**
         * 发送时间
         *//*

        private Long sendRiskDate;

    }

    @Data
    static class RiskDataInfo {
        */
/**
         * 订单信息
         *//*

        private RiskOrderInfo orderInfo;

        */
/**
         * 预计车辆信息
         *//*

        private List<RiskCarInfo> carInfos;

        */
/**
         * 获取订单到期日
         *//*

        int getOrderDelayDays() {
            return orderInfo.getDelayLoanDays() == null ? 0 : Integer.parseInt(orderInfo.getDelayLoanDays());
        }

        */
/**
         * 到期前1或3天
         *//*

        boolean isNotOverdue() {
            return -1 == getOrderDelayDays() || -3 == getOrderDelayDays();

        }

    }

    @Data
    static class RiskOrderInfo {
        */
/**
         * 订单编号
         *//*

        private String orderNo;

        */
/**
         * 车型名称
         *//*

        private String modelName;

        */
/**
         * 垫资金额
         *//*

        private String loanAmount;

        */
/**
         * 到期前
         *//*

        private String delayLoanDays;

        */
/**
         * 再贷金额
         *//*

        private String zaidaiAmount;

        */
/**
         * 到期时间
         *//*

        private String onloanDeadLine;


    }

    @Data
    static class RiskCarInfo {

        */
/**
         * 车架号
         *//*

        private String carUnique;

        */
/**
         * 到期时间
         *//*

        private String deadLine;

        */
/**
         * 逾期天数 负数表示到期前n天 否则 到期后n天
         *//*

        private String loanDelayDays;


    }

}
*/
