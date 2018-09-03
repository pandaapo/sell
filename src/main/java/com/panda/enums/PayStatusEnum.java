package com.panda.enums;

import lombok.Getter;

/**
 * 支付状态
 */
@Getter
public enum PayStatusEnum implements CodeEnum {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功"),
    ;

    private Integer code;

    private String messge;

    PayStatusEnum(Integer code, String messge) {
        this.code = code;
        this.messge = messge;
    }
}
