package com.xuande.rocket.model;

import com.alibaba.fastjson.JSON;
import com.xuande.rocket.common.MessageStatusConstants;
import com.xuande.rocket.entity.MessageLog;
import org.apache.rocketmq.common.message.Message;

import java.time.LocalDateTime;
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

    public BizMessage() {
    }

    public Message toMQMessage(String topic){
        return new Message(topic, JSON.toJSONString(this).getBytes());
    }


    public Message toMQMessage(String topic, String tag){
        return new Message(topic, tag, JSON.toJSONString(this).getBytes());
    }

    public MessageLog toMessageLog(String topic, String tag){
        MessageLog messageLog = new MessageLog();
        messageLog.setBizId(this.bizId);
        messageLog.setTag(tag);
        messageLog.setTopic(topic);
        messageLog.setStatus(MessageStatusConstants.SEND_OK);
        messageLog.setGmtCreate(LocalDateTime.now());
        messageLog.setMessage(JSON.toJSONString(this));
        messageLog.setRetryCount(0);
        return messageLog;
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
