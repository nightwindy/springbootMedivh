/*
package com.medivh.core.service.mq;

import com.alibaba.fastjson.JSON;
import com.camaro.starter.mq.annotation.MQConsumer;
import com.camaro.starter.mq.base.AbstractMQPushConsumer;
import DebtCarInfoService;
import com.mhc.lincoln.api.DebtService;
import com.mhc.lincoln.core.ao.IDebtCessionAO;
import FpDebtEntityBO;
import com.mhc.lincoln.dto.DebtRequest;
import com.mhc.lincoln.enums.DebtStatusEnum;
import com.subaru.common.enums.ordercenter.FlowActionTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

*/
/**
 * Created by xiaotian on 2017/7/13.
 * 借据消息订阅
 *//*

@MQConsumer(consumerGroup = "lincoln.consumer", topic = "lincoln.topic")
public class NewDebtMqSubscriber extends AbstractMQPushConsumer<DebtRequest> {

    private static final Logger logger = LoggerFactory.getLogger(DebtRequest.class);

    @Autowired
    private DebtService debtService;

    @Autowired
    private DebtCarInfoService debtCarInfoService;

    @Autowired
    private IDebtCessionAO debtCessionAO;


    @Override
    public boolean process(DebtRequest message, Map map) {
        logger.info("接收到消息: " + JSON.toJSONString(message));
        FpDebtEntityBO fpDebtEntityBO = new FpDebtEntityBO();
        BeanUtils.copyProperties(message, fpDebtEntityBO);
        if ("closeOrder".equals(message.getActionType())) {  // 关闭订单
            logger.info("用户关闭订单: order_no = " + fpDebtEntityBO.getOrderNo());
            fpDebtEntityBO.setStatus(Byte.valueOf("-1"));
            // 关闭借据表
            debtService.closeDebtByOrderNo(fpDebtEntityBO.getOrderNo());
            // 关闭车辆计息表
            debtCarInfoService.closeByOrderNo(fpDebtEntityBO.getOrderNo());

        }
        if (FlowActionTypeEnum.USER_SIGN.getCode().equals(message.getActionType())) {//用户签约

        } else if (FlowActionTypeEnum.CASH_PASS.getCode().equals(message.getActionType())) {//财务打款
            message.setStatus((byte) DebtStatusEnum.OUT.getCode());
            // 生成借据
            debtService.createDebt(message);
            //更新核价信息
            debtService.updateDebtByCorePrice(message.getOrderNo());

            debtService.expenditureAccount(message);
            // 创建车辆计息记录
            debtCarInfoService.createDebtCarList(message.getOrderNo());
            // 计算当天的利息
            debtCarInfoService.calDebtCar(message.getOrderNo());


        } else if (FlowActionTypeEnum.EXTENSION_REPAY_CHECK.getCode().equals(message.getActionType())) {//展期结算
            debtService.exhibition(message);
            // 更新展期信息
            debtCarInfoService.extensionUpdateDebtCarList(message.getOrderNo(), message.getChargeNo());


        } else if (FlowActionTypeEnum.REPAY_CHECK.getCode().equals(message.getActionType())) {//财务审核回款
            // 结算信息更新
            debtCarInfoService.paymentUpdateDebtCarList(message.getOrderNo(), message.getChargeNo());
            //还款完成更新借据
            debtService.repayment(message);
            // 更新车辆的借据状态
            debtCarInfoService.updateDebtCarStatus(message.getOrderNo());
            // 更新债权资金池
            debtCessionAO.updateCapitalPoolAmount(message.getOrderNo());


        } else if (FlowActionTypeEnum.SUPPLY_PASS.getCode().equals(message.getActionType())) {//车辆核价（TODO 订单借据产生之前已经有核价金额了，所以该条消息不用消费）

        } else if (FlowActionTypeEnum.EXTENSION_PRICE.getCode().equals(message.getActionType())) {//展期核价
            //获取核价金额
            debtService.updateDebtByCorePrice(message.getOrderNo());
        }
        return true;
    }
}
*/
