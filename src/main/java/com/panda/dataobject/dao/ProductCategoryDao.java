package com.panda.dataobject.dao;

import com.panda.dataobject.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

//？？？疑问：这个dao是否需要bean的注解
//这个dao层是来封装mapper的，目的是为了代码结构
public class ProductCategoryDao {
    @Autowired
    ProductCategoryMapper mapper;

    public int myInsert(Map<String, Object> map){
       return mapper.insertByMap(map);
    }
}
