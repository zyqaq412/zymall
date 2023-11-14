package com.hzy.zymall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzy.common.utils.PageUtils;
import com.hzy.common.utils.Query;
import com.hzy.zymall.product.dao.CategoryDao;
import com.hzy.zymall.product.entity.CategoryEntity;
import com.hzy.zymall.product.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        // 1.查出所有分类
        List<CategoryEntity> list = this.list();
        // 2.构建树形结构
        List<CategoryEntity> ans = new LinkedList<>();
        // 2.1找出顶级分类
        for (CategoryEntity category : list){
            if (category.getParentCid() == 0){
                ans.add(category);
            }
        }
        // 2.2构建树形结构
        buildTree(list,ans);

        return ans;
    }
    private void buildTree(List<CategoryEntity> list,List<CategoryEntity> ans){
        for (CategoryEntity category : ans){
            List<CategoryEntity> temp = new LinkedList<>();
            for (CategoryEntity node : list){
                if (node.getParentCid() == category.getCatId()){
                    temp.add(node);
                }
            }
            buildTree(list,temp);
            category.setChild(temp);
        }
    }
}