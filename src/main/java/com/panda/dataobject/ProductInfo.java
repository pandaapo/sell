package com.panda.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.panda.enums.ProductStatusEnum;
import com.panda.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Proxy(lazy = false)
@DynamicUpdate
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = -1603844380829341352L;
    @Id
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
    /** 商品状态,0正常1下架 **/
    private Integer productStatus = ProductStatusEnum.UP.getCode();
    /** 类目编号,0正常1下架 **/
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }
}
