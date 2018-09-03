package com.panda.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class OrderForm {
    @NotEmpty(message = "买家姓名必填")
    private String name;

    @NotEmpty(message = "手机号必填")
    private String phone;

    @NotEmpty(message = "手机号必填")
    private String address;

    @NotEmpty(message = "买家微信openid")
    private String openid;

    @NotEmpty(message = "购物车不能为空")
    private String items;
}
