package com.windy.medivh.core.event;

import com.guldan.starter.mq.annotation.MQConsumer;
import com.guldan.starter.mq.base.AbstractMQPushConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
@MQConsumer(topic = "finance.topic", consumerGroup = "finance.contract.consumerId", tag = "ContractWaitForPartnerSignMsg")
public class DemoMsgConsumer extends AbstractMQPushConsumer<DemoMessage> {




    @Override
    public boolean process(DemoMessage cwfpsMsg, Map<String, Object> extParam) {
        boolean isSucess = true;

//        log.info("接收资方消息返回="+JSON.toJSONString(bizResult));
//        if(bizResult==null||!bizResult.isSuccess()){
//            isSucess = false;
//        }
        return isSucess;
    }
}