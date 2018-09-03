package com.panda.exception;

import com.panda.enums.ResultEnum;

/**
 * 统一异常
 */
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String msg){
        super(msg);
        this.code = code;
    }
}
