package com.hzy.zymall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzy.common.utils.PageUtils;
import com.hzy.zymall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author zxwyhzy
 * @email zxwyhzy@gmail.com
 * @date 2023-11-14 16:27:24
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     *  查询所有分类
     * @return 树形结构的分类列表
     */
    List<CategoryEntity> listWithTree();
}

