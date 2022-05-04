package com.xuande.consumer.model;

import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.common.message.Message;

import java.util.UUID;

/**
 * @author : xuande
 * @date : 2022-05-03 12:27
 **/
public class BizMessage {

    /**
     * 业务消息ID
     */
    private String bizId;


    /**
     * 消息体
     */
    private Object body;



    public BizMessage(Object object) {
        this.bizId = UUID.randomUUID().toString();
        this.body = object;
    }

    public BizMessage(String bizId, Object body) {
        this.bizId = bizId;
        this.body = body;
    }

    public Message toMQMessage(String topic){
        return new Message(topic, JSON.toJSONString(this).getBytes());
    }


    public Message toMQMessage(String topic, String tag){
        return new Message(topic, tag, JSON.toJSONString(this).getBytes());
    }


    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
