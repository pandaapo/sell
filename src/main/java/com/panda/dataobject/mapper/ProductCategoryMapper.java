package com.panda.dataobject.mapper;

import com.panda.dataobject.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface ProductCategoryMapper {

    @Insert("insert into product_category (category_name, category_type) values (#{category_name, jdbcType=VARCHAR}, #{categoryType, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Insert("insert into product_category (category_name, category_type) values (#{categoryName, jdbcType=VARCHAR}, #{categoryType, jdbcType=INTEGER})")
    int insertByObject(ProductCategory productCategory);

    @Select("select * from product_category where category_type = #{categoryType}")
    @Results({
            @Result(column="category_type", property = "categoryType"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_id", property = "categoryId")
    })
    ProductCategory findByCategoryType(Integer categoryType);

    @Select("select * from product_category where category_name = #{categoryName}")
    @Results({
            @Result(column="category_type", property = "categoryType"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_id", property = "categoryId")
    })
    List<ProductCategory> findByCategoryName(String categoryName);

    @Update("update product_category set category_name =#{category_name} where category_type =#{category_type}")
    int updateByCategoryType(@Param("category_name") String category_name, @Param("category_type") Integer category_type);

    @Update("update product_category set category_name =#{categoryName} where category_type =#{categoryType}")
    int updateByObject(ProductCategory productCategory);

    @Delete("delete from product_category where category_type =#{categoryType}")
    int deleteByCategoryType(Integer categoryType);

    ProductCategory selectByCategoryType(Integer categoryType);
}
