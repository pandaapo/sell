package com.panda.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 4001907052358723999L;

    /** 错误码 **/
    private Integer code;

    /** 提示信息 */
    private String msg;

    /** 具体的内容 */
    private T data;
}
