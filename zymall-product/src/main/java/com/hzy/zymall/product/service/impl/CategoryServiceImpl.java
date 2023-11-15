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

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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
        //1、查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);

        //2、组装成父子的树形结构

        //2.1）、找到所有的一级分类
        List<CategoryEntity> level1Menus = entities.stream().filter(categoryEntity ->
                categoryEntity.getParentCid() == 0
        ).map((menu)->{
            menu.setChildren(getChildrens(menu,entities));
            return menu;
        }).sorted((menu1,menu2)->{
            return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());




        return level1Menus;
/*        // 1.查出所有分类
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

        return topLevelCategories;*/
    }
    //递归查找所有菜单的子菜单
    private List<CategoryEntity> getChildrens(CategoryEntity root,List<CategoryEntity> all){

        List<CategoryEntity> children = all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid() == root.getCatId();
        }).map(categoryEntity -> {
            //1、找到子菜单
            categoryEntity.setChildren(getChildrens(categoryEntity,all));
            return categoryEntity;
        }).sorted((menu1,menu2)->{
            //2、菜单的排序
            return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());

        return children;
    }
/*    private void buildTree(List<CategoryEntity> list,List<CategoryEntity> parentCategories){

       *//* for (CategoryEntity category : parentCategories) {
            // 使用Java流过滤出当前分类的子分类
            List<CategoryEntity> childCategories = list.stream()
                    .filter(node -> node.getParentCid() == category.getCatId())
                    .collect(Collectors.toList());

            // 递归构建子树
            buildTree(list, childCategories);

            // 设置子分类
            category.setChild(childCategories);
        }*//*
        for (CategoryEntity category : parentCategories){
*//*            if (category.getName().equals("全新整车")){
                System.out.println();
            }*//*
            List<CategoryEntity> temp = new LinkedList<>();
            for (CategoryEntity node : list){
*//*                if (node.getName().equals("中型车")){
                    System.out.println();
                }*//*
                //if (node.getParentCid() == category.getCatId()){
                if (node.getParentCid().equals(category.getCatId())){
                    temp.add(node);
                }
            }

            category.setChildren(temp);
            buildTree(list,temp);

        }
    }*/
}