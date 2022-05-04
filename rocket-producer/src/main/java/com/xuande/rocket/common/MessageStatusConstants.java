package com.xuande.rocket.common;


/**
 * @author : xuande
 * @date : 2022-05-03 13:46
 **/
public interface MessageStatusConstants {

    /**
     * 投递成功
     */
    Integer SEND_OK = 1;

    /**
     * 投递失败
     */
    Integer SEND_FAIL = -1;

    /**
     * 消费成功
     */
    Integer CONSUME_OK = 2;

    /**
     * 消费失败
     */
    Integer CONSUME_FAIL = -2;


    /**
     * 消息超时作废
     */
    Integer MESSAGE_TIME_OUT = -3;

}
