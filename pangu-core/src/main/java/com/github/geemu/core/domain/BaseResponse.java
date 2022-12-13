package com.github.geemu.core.domain;

import com.github.geemu.core.exception.BizRuntimeException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 基础实体
 * @author 陈方明 cfmmail@sina.com
 * @since 2021-01-17 22:20
 */
@Getter
@ToString
@EqualsAndHashCode
public class BaseResponse<T> {

    /** 返回状态 **/
    private final Integer code;
    /** 返回提示信息 **/
    private final String message;
    /** 返回数据 **/
    private final T data;

    /**
     * 隐藏构造
     * @param code 状态码
     * @param message 状态提示信息
     * @param data 返回数据
     */
    private BaseResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 无数据返回的默认成功
     */
    public BaseResponse() {
        this(DefaultResponseState.OK.getCode(), DefaultResponseState.OK.getMessage(), null);
    }

    /**
     * 有数据返回的默认成功
     * @param data 数据
     */
    public BaseResponse(T data) {
        this(DefaultResponseState.OK.getCode(), DefaultResponseState.OK.getMessage(), data);
    }

    /**
     * 无数据的自定义状态返回
     * @param state 状态码、状态提示信息
     */
    public BaseResponse(ResponseState state) {
        this(state.getCode(), state.getMessage(), null);
    }

    /**
     * 无数据的自定义状态返回
     * @param state state 状态码
     * @param message message 状态提示信息
     */
    public BaseResponse(ResponseState state, String message) {
        this(state.getCode(), message, null);
    }

    /**
     * 无数据的自定义状态返回
     * @param ex 状态码、状态提示信息
     */
    public BaseResponse(BizRuntimeException ex) {
        this(ex.getCode(), ex.getMessage(), null);
    }

    /**
     * 有数据的自定义状态返回
     * @param state 状态码、状态提示信息
     * @param data 数据
     */
    public BaseResponse(ResponseState state, T data) {
        this(state.getCode(), state.getMessage(), data);
    }

    /**
     * 有数据的自定义状态返回
     * @param state 状态码
     * @param message 状态提示信息
     * @param data 数据
     */
    public BaseResponse(ResponseState state, String message, T data) {
        this(state.getCode(), message, data);
    }

    /**
     * 无数据返回的默认成功
     * @return ResponseEntity<Void>
     */
    public static BaseResponse<Void> ok() {
        return new BaseResponse<>();
    }

    /**
     * 有数据返回的默认成功
     * @param data data
     * @param <T> <T>
     * @return ResponseEntity<T>
     */
    public static <T> BaseResponse<T> ok(T data) {
        return new BaseResponse<>(data);
    }
    
}
