package com.xuande.rocket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author xuande
 * @since 2022-05-03
 */
@TableName("message_log")
public class MessageLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 业务ID
     */
    private String bizId;

    /**
     * 消息投递topic
     */
    private String topic;

    /**
     * 消息标签tag
     */
    private String tag;

    /**
     * 消息状态(0: 已投递，1，消费成功，2，消费失败，-1 超时作废)
     */
    private Integer status;

    /**
     * 消息体
     */
    private String message;

    /**
     * 重试时间
     */
    private LocalDateTime retryTime;

    /**
     * 重试次数
     */
    private Integer retryCount;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModify;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }
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
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public LocalDateTime getRetryTime() {
        return retryTime;
    }

    public void setRetryTime(LocalDateTime retryTime) {
        this.retryTime = retryTime;
    }
    public Integer getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }
    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
    public LocalDateTime getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(LocalDateTime gmtModify) {
        this.gmtModify = gmtModify;
    }

    @Override
    public String toString() {
        return "MessageLog{" +
            "id=" + id +
            ", bizId=" + bizId +
            ", topic=" + topic +
            ", tag=" + tag +
            ", status=" + status +
            ", message=" + message +
            ", retryTime=" + retryTime +
            ", retryCount=" + retryCount +
            ", gmtCreate=" + gmtCreate +
            ", gmtModify=" + gmtModify +
        "}";
    }
}
