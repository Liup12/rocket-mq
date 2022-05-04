package com.xuande.rocket.mq;

import static com.xuande.rocket.common.MessageStatusConstants.*;

import com.xuande.rocket.common.MessageStatusConstants;
import com.xuande.rocket.model.BizMessage;
import com.xuande.rocket.service.IMessageLogService;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author : xuande
 * @date : 2022-05-03 13:18
 **/
@Component
public class Producer {

    @Resource
    private MQProducer mqProducer;

    @Resource
    private IMessageLogService messageLogService;

    public void sendMessage(Object object, String topic, String tag){
        this.sendMessage(new BizMessage(object), topic, tag);
    }

    public void sendMessage(BizMessage bizMessage, String topic, String tag){

        // 消息发送之前先入库
        this.saveMessageLog(bizMessage, topic, tag);

        try {
            SendResult result = mqProducer.send(bizMessage.toMQMessage(topic, tag));
            SendStatus sendStatus = result.getSendStatus();
            if (!sendStatus.equals(SendStatus.SEND_OK)){
                // 修改当前日志的发送状态
                messageLogService.changeStatus(SEND_OK, SEND_FAIL, bizMessage.getBizId());
            }
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public void saveMessageLog(BizMessage bizMessage, String topic, String tag){
        if (!messageLogService.save(bizMessage.toMessageLog(topic, tag))) {
            throw new RuntimeException("消息在发送之前必须保存到数据库中");
        }
    }


}
