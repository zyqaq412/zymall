package com.hzy.zymall.coupon.dao;

import com.hzy.zymall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author zxwyhzy
 * @email zxwyhzy@gmail.com
 * @date 2023-11-13 16:25:24
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
