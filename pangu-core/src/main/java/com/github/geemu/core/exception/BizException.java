package com.github.geemu.core.exception;

import com.github.geemu.core.domain.ResponseState;

/**
 * BizRuntimeException
 * @author 陈方明  cfmmail@sina.com
 * @since 2021-12-19 00:08:49
 */
public class BizException extends RuntimeException {

    /** 返回状态 **/
    private final Integer code;
    /** 返回提示信息 **/
    private final String message;
    /** 异常信息 **/
    private final Throwable cause;

    /**
     * 隐藏构造
     * @param code 状态码
     * @param message 状态提示信息
     */
    private BizException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
        this.cause = cause;
    }

    /**
     * 无异常堆栈的返回
     * @param state 状态码、状态提示信息
     */
    public BizException(ResponseState state) {
        this(state.getCode(), state.getMessage(), null);
    }

    /**
     * 无异常堆栈的自定义状态提示信息返回
     * @param code code 状态码
     * @param message message 状态提示信息
     */
    public BizException(ResponseState code, String message) {
        this(code.getCode(), message, null);
    }

    /**
     * 有异常堆栈的自定义状态返回
     * @param state 状态码、状态提示信息
     * @param cause 异常堆栈
     */
    public BizException(ResponseState state, Throwable cause) {
        this(state.getCode(), state.getMessage(), cause);
    }

    /**
     * 有异常堆栈的自定义状态返回
     * @param code 状态码
     * @param message 状态提示信息
     * @param cause 异常堆栈
     */
    public BizException(ResponseState code, String message, Throwable cause) {
        this(code.getCode(), message, cause);
    }

    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public Throwable getCause() {
        return this.cause;
    }

}
