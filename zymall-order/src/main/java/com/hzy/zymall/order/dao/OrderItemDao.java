package com.hzy.zymall.order.dao;

import com.hzy.zymall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author zxwyhzy
 * @email zxwyhzy@gmail.com
 * @date 2023-11-13 16:56:15
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
