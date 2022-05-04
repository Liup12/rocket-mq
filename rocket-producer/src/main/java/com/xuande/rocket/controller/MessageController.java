package com.xuande.rocket.controller;

import com.xuande.rocket.model.BizMessage;
import com.xuande.rocket.mq.Producer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : xuande
 * @date : 2022-05-03 10:18
 **/
@RestController
public class MessageController {

    @Resource
    private Producer producer;

//    @PostMapping("send")
//    public String sendMessage(@RequestBody MessageRequest messageRequest){
//
//        Message message = new Message(messageRequest.getTopic(),
//                messageRequest.getTag(), messageRequest.getBody().getBytes());
//        try {
//            producer.send(message);
//        } catch (MQClientException e) {
//            e.printStackTrace();
//        } catch (RemotingException e) {
//            e.printStackTrace();
//        } catch (MQBrokerException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        return "success";
//    }

    @GetMapping("send")
    public String sendMessageForGet(String topic, String tag, String body){
        producer.sendMessage(body, topic, tag);
        return "success";
    }
}
