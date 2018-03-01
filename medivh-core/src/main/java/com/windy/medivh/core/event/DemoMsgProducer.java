package com.windy.medivh.core.event;

import com.guldan.starter.mq.annotation.MQProducer;
import com.guldan.starter.mq.base.AbstractMQProducer;
import com.windy.medivh.core.common.util.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@MQProducer(topic = "finance.topic", tag = "ProcessMessage")
public class DemoMsgProducer extends AbstractMQProducer {

    private static final String LOG_PRE = "放款后发送消息,";


    /**
     * 放贷后发送消息.只针对订单宝业务。
     *
     * @param orderNo
     */
    public void sendOrderNoMsgOnLoan(String orderNo) {
        log.info(LOG_PRE + "orderNo:" + orderNo);
        DemoMsgProducer demoMsgProducer = SpringContextUtil.getBean(DemoMsgProducer.class);

        //demoMsgProducer.asyncSend(,,);
    }

}
