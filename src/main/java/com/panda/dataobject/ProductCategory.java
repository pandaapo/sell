package com.panda.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 类目表
 */
@Entity
@DynamicUpdate
@Proxy(lazy = false)
@Data
public class ProductCategory {

    /** 类目ID **/
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)    //为什么我的代码需要加这个生成策略？
    private Integer categoryId;

    /** 类目名称 **/
    private String categoryName;

    /** 类目编号 **/
    private Integer categoryType;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
