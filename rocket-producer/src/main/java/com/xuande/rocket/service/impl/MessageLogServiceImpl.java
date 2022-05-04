package com.xuande.rocket.service.impl;

import com.xuande.rocket.entity.MessageLog;
import com.xuande.rocket.mapper.MessageLogMapper;
import com.xuande.rocket.service.IMessageLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuande
 * @since 2022-05-03
 */
@Service
public class MessageLogServiceImpl extends ServiceImpl<MessageLogMapper, MessageLog> implements IMessageLogService {

    @Override
    public int changeStatus(Integer oldStatus, Integer newStatus, String bizId) {
        return this.baseMapper.changeStatus(oldStatus, newStatus, bizId);
    }

    @Override
    public int confirmSuccess(String bizId) {
        return this.baseMapper.confirmSuccess(bizId);
    }
}
