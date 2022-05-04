package com.xuande.rocket.controller;

/**
 * @author : xuande
 * @date : 2022-05-03 10:20
 **/

public class MessageRequest {

    private String topic;

    private String tag;

    private String body;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
