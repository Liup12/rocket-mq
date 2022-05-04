package com.xuande.consumer.mq;

import com.xuande.consumer.model.BizMessage;
import com.xuande.consumer.properties.RocketProperties;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.client.producer.SendResult;
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
    private RocketProperties properties;

    public void sendMessage(Object object, String topic, String tag){
        this.sendMessage(new BizMessage(object), topic, tag);
    }

    public void sendMessage(BizMessage bizMessage, String topic, String tag){
        try {
            mqProducer.send(bizMessage.toMQMessage(topic, tag));
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


    public void confirmMessage(String bizId){
        BizMessage bizMessage = new BizMessage(bizId, new String("success"));
        try {
            mqProducer.send(bizMessage.toMQMessage(properties.getConfirmTopic(), "*"));
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

}
