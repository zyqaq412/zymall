package com.hzy.zymall.coupon.dao;

import com.hzy.zymall.coupon.entity.MemberPriceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品会员价格
 * 
 * @author zxwyhzy
 * @email zxwyhzy@gmail.com
 * @date 2023-11-13 16:25:24
 */
@Mapper
public interface MemberPriceDao extends BaseMapper<MemberPriceEntity> {
	
}
