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
/*        List<CategoryEntity> list = this.list();

        // 使用Java流过滤出顶级分类
        List<CategoryEntity> topLevelCategories = list.stream()
                .filter(category -> category.getParentCid() == 0)
                .collect(Collectors.toList());

        // 构建树形结构
        buildTree(list, topLevelCategories);*/


        // 1.查出所有分类
        List<CategoryEntity> list = this.list();
        // 2.构建树形结构
        List<CategoryEntity> topLevelCategories = new LinkedList<>();
        // 2.1找出顶级分类
        for (CategoryEntity category : list){
            if (category.getParentCid() == 0){
                topLevelCategories.add(category);
            }
        }
        // 2.2构建树形结构
        buildTree(list,topLevelCategories);

        return topLevelCategories;
    }
    private void buildTree(List<CategoryEntity> list,List<CategoryEntity> parentCategories){

       /* for (CategoryEntity category : parentCategories) {
            // 使用Java流过滤出当前分类的子分类
            List<CategoryEntity> childCategories = list.stream()
                    .filter(node -> node.getParentCid() == category.getCatId())
                    .collect(Collectors.toList());

            // 递归构建子树
            buildTree(list, childCategories);

            // 设置子分类
            category.setChild(childCategories);
        }*/
        for (CategoryEntity category : parentCategories){
/*            if (category.getName().equals("全新整车")){
                System.out.println();
            }*/
            List<CategoryEntity> temp = new LinkedList<>();
            for (CategoryEntity node : list){
/*                if (node.getName().equals("中型车")){
                    System.out.println();
                }*/
                //if (node.getParentCid() == category.getCatId()){
                if (node.getParentCid().equals(category.getCatId())){
                    temp.add(node);
                }
            }

            category.setChildren(temp);
            buildTree(list,temp);

        }
    }
}