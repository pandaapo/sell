package com.panda.service;

import com.panda.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {
    //查询一条记录
    ProductCategory findOne(Integer id);

    //查询所有
    List<ProductCategory> findAll();

    //通过type查询
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    //新增和更新
    ProductCategory save(ProductCategory productCategory);
}
