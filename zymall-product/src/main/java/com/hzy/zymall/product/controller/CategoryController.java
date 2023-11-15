package com.hzy.zymall.product.controller;

import com.hzy.common.utils.R;
import com.hzy.zymall.product.entity.CategoryEntity;
import com.hzy.zymall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;



/**
 * 商品三级分类
 *
 * @author zxwyhzy
 * @email zxwyhzy@gmail.com
 * @date 2023-11-14 16:27:24
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 查出所有分类以及子分类，以树形结构组装起来
     */
    @RequestMapping("/list/tree")

    public R list(){

        List<CategoryEntity> list = categoryService.listWithTree();
        return R.ok().put("data",list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        // return R.ok().put("category", category);
        return R.ok().put("data", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除 @RequestBody获取请求体
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Long[] catIds){
		categoryService.removeByIds(Arrays.asList(catIds));

        return R.ok();
    }

    @RequestMapping("/update/sort")
    public R updateSort(@RequestBody CategoryEntity[] category){
        categoryService.updateBatchById(Arrays.asList(category));
        return R.ok();
    }

}
