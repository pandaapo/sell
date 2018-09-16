package com.panda.service.impl;

import com.panda.dataobject.ProductCategory;
import com.panda.dataobject.dao.ProductCategoryDao;
import com.panda.dataobject.mapper.ProductCategoryMapper;
import com.panda.repository.ProductCategoryRepository;
import com.panda.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepository repository;

 //   //可以这直接注入mapper
//    @Autowired
//    private ProductCategoryMapper mapper;

//    @Autowired
//    private ProductCategoryDao dao;

    @Override
    public ProductCategory findOne(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
