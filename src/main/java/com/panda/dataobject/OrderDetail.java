package com.panda.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 订单商品
 */
@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;

    /** 订单ID **/
    private String orderId;

    /** 商品ID **/
    private String productId;

    /** 商品名称 **/
    private String productName;

    /** 商品单价 **/
    private BigDecimal productPrice;

    /** 商品数量 **/
    private Integer productQuantity;

    /** 商品小图 **/
    private String productIcon;
}
