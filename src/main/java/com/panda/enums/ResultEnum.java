package com.panda.enums;

import lombok.Getter;

/**
 * 异常错误码
 */
@Getter
public enum ResultEnum {
    SUCESS(0, "成功"),
    PARAM_ERROR(1,"参数出现问题"),
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "库存出现问题"),
    ORDERMASTER_NOT_EXIST(12, "订单不存在"),
    ORDERDETAIL_NOT_EXIST(13, "订单详情不存在"),
    ORDER_STATUS_ERROR(14, "订单状态出现问题"),
    ORDER_UPDATE_FAIL(15, "订单状态更新失败"),
    ORDER_DETAIL_EMPTY(16, "无订单详细"),
    ORDER_PAY_STATUS_ERROR(17, "支付状态出现问题"),
    CART_EMPTY(18, "购物车是空的"),
    ORDER_OWNER_ERROR(19, "不属于本人订单"),

    WECHAT_MP_ERROR(20, "微信公众号相关错误"),
    WXPAY_NOTIFY_MONEY_VERIFY_ERROR(21, "微信支付异步通知金额校验不通过"),
    ORDER_CANCEL_SUCCESSS(22, "订单取消成功"),
    ORDER_FINISH_SUCCESSS(23, "订单完结成功"),
    PRODUCT_STATUS_ERROR(24, "订单状态不正确"),
    LOGIN_FAIL(25, "登录失败，登录信息不正确"),
    LOGOUT_SUCCESS(26, "登出成功")
    ;
    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
