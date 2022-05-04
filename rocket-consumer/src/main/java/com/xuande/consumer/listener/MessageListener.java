package com.xuande.consumer.listener;

import com.alibaba.fastjson.JSON;
import com.xuande.consumer.model.BizMessage;
import com.xuande.consumer.mq.Producer;
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
public class MessageListener implements MessageListenerConcurrently {

    @Resource
    private Producer producer;
    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {

        for (MessageExt messageExt : list) {
            BizMessage message = JSON.parseObject(messageExt.getBody(), BizMessage.class);
            System.out.println(JSON.toJSONString(message));
            // 发送确认消息
            message.setBody("success");
            producer.confirmMessage(message.getBizId());

        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
