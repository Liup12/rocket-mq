package com.xuande.rocket.mapper;

import com.xuande.rocket.entity.MessageLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xuande
 * @since 2022-05-03
 */
public interface MessageLogMapper extends BaseMapper<MessageLog> {


    int changeStatus(@Param("oldStatus") Integer oldStatus,@Param("newStatus") Integer newStatus, @Param("bizId")String bizId);


    int confirmSuccess(String bizId);
}
