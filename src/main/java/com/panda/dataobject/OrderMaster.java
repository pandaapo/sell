package com.panda.dataobject;

import com.panda.enums.OrderStatusEnum;
import com.panda.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate  //为了能让updateTime自动更新
public class OrderMaster {
    /** 订单id **/
    @Id
    private String orderId;

    /** 买家名字 **/
    private String buyerName;

    /** 买家电话 **/
    private String  buyerPhone;

    /** 买家地址 **/
    private String buyerAddress;

    /** 买家微信openid **/
    private String buyerOpenid;

    /** 订单总金额 **/
    private BigDecimal orderAmount;

    /**  订单状态，默认为0新订单 **/
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态，默认为0未支付 **/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private Date createTime;

    private Date updateTime;
}
