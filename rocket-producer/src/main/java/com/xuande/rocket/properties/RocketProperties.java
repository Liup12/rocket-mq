package com.xuande.rocket.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : xuande
 * @date : 2022-05-03 10:14
 **/
@Data
@Component
@ConfigurationProperties(prefix = "rocket.mq")
public class RocketProperties {

    private String server;

    private String group;

    private String messageTopic;

    private String confirmTopic;


    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getMessageTopic() {
        return messageTopic;
    }

    public void setMessageTopic(String messageTopic) {
        this.messageTopic = messageTopic;
    }

    public String getConfirmTopic() {
        return confirmTopic;
    }

    public void setConfirmTopic(String confirmTopic) {
        this.confirmTopic = confirmTopic;
    }
}
