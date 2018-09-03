package com.panda.dto;

import lombok.Data;
import lombok.Getter;

/**
 * 购物车
 */
@Data
public class CarDTO {

    /** 商品Id **/
    private String productId;

    /** 数量 **/
    private Integer productQuantity;

    public CarDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
