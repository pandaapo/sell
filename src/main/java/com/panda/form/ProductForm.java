package com.panda.form;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductForm {

    private String productId;
    /** 商品名称 **/
    private String productName;
    /** 单价 **/
    private BigDecimal productPrice;
    /** 库存 **/
    private Integer productStock;
    /** 描述 **/
    private String productDescription;
    /** 小图 **/
    private String productIcon;

    /** 类目编号,0正常1下架 **/
    private Integer categoryType;

}
