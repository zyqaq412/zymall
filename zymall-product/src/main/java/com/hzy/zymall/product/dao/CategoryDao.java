package com.hzy.zymall.product.dao;

import com.hzy.zymall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author zxwyhzy
 * @email zxwyhzy@gmail.com
 * @date 2023-11-14 16:27:24
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
