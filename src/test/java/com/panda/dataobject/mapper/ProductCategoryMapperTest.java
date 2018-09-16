package com.panda.dataobject.mapper;

import com.panda.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void insertByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("category_name", "hello猪");
        map.put("categoryType", 5);
        int result = mapper.insertByMap(map);
        Assert.assertEquals(1, result);
    }

    @Test
    public void insertByObject(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("hi猪");
        productCategory.setCategoryType(6);
        int result = mapper.insertByObject(productCategory);
        Assert.assertEquals(1, result);
    }

    @Test
    public void findByCategoryType(){
        ProductCategory result = mapper.findByCategoryType(99);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryName(){
        List<ProductCategory> result = mapper.findByCategoryName("hello猪");
        Assert.assertNotNull(result);
    }

    @Test
    public void updateByCategoryType(){
        int result = mapper.updateByCategoryType("hi猪", 6);
        Assert.assertEquals(1,result);
    }

    @Test
    public void updateByObject(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("hi猪猪");
        productCategory.setCategoryType(6);
        int result = mapper.updateByObject(productCategory);
        Assert.assertEquals(1, result);
    }

    @Test
    public void deleteByCategoryType(){
        int result = mapper.deleteByCategoryType(6);
        Assert.assertEquals(1, result);
    }

    @Test
    public void selectByCategoryType(){
        ProductCategory productCategory =  mapper.selectByCategoryType(5);
        Assert.assertNotNull(productCategory);
    }
}