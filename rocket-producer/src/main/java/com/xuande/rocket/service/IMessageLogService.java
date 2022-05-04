package com.xuande.rocket.service;

import com.xuande.rocket.entity.MessageLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xuande
 * @since 2022-05-03
 */
public interface IMessageLogService extends IService<MessageLog> {


    int changeStatus(Integer oldStatus, Integer newStatus, String bizId);


    int confirmSuccess(String bizId);
}
