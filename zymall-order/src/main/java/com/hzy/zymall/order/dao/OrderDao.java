package com.hzy.zymall.order.dao;

import com.hzy.zymall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author zxwyhzy
 * @email zxwyhzy@gmail.com
 * @date 2023-11-13 16:56:15
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
