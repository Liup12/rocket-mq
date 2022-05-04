package com.xuande.rocket.listener;

import com.alibaba.fastjson.JSON;
import com.xuande.rocket.model.BizMessage;
import com.xuande.rocket.service.IMessageLogService;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : xuande
 * @date : 2022-05-03 10:42
 **/
@Component
public class ConfirmMessageListener implements MessageListenerConcurrently {

    @Resource
    private IMessageLogService messageLogService;


    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        for (MessageExt messageExt : list) {
            BizMessage message = JSON.parseObject(messageExt.getBody(), BizMessage.class);
            messageLogService.confirmSuccess(message.getBizId());
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
