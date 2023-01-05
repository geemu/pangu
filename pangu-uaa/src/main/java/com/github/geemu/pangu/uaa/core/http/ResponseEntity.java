package com.github.geemu.pangu.uaa.core.http;

import com.github.geemu.pangu.common.exception.BizRuntimeException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 基础封装返回体
 * @author 陈方明  cfmmail@sina.com
 * @since 2018-10-27 10:18
 */
@Getter
@ToString
@EqualsAndHashCode
public class ResponseEntity<T> {

    /** 返回状态 **/
    private final int code;
    /** 返回提示信息 **/
    private final String message;
    /** 返回数据 **/
    private final T data;

    private ResponseEntity(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    /**
     * 没有数据的自定义状态返回
     * @param state code、message
     */
    public ResponseEntity(ResponseState state) {
        this(state.getCode(), state.getMessage(), null);
    }

    public ResponseEntity(BizRuntimeException e) {
        this(e.getCode(), e.getMessage(), null);
    }

    /**
     * 成功且有数据的返回
     * @param data 数据
     */
    public ResponseEntity(T data) {
        this(DefaultResponseState.SUCCESS.getCode(), DefaultResponseState.SUCCESS.getMessage(), data);
    }

    /**
     * 成功且但无数据的返回
     */
    public ResponseEntity() {
        this(DefaultResponseState.SUCCESS.getCode(), DefaultResponseState.SUCCESS.getMessage(), null);
    }

    /**
     * 自定义状态和数据的返回
     * @param state code、message
     * @param data 数据
     */
    public ResponseEntity(ResponseState state, T data) {
        this(state.getCode(), state.getMessage(), data);
    }

    /**
     * 自定义的message代替responseStatus中的message且有自己的返回数据
     * @param state state
     * @param message message
     * @param data data
     */
    public ResponseEntity(ResponseState state, String message, T data) {
        this(state.getCode(), message, data);
    }

    /**
     * 自定义的message代替responseStatus中的message无返回数据
     * @param state state
     * @param message message
     */
    public ResponseEntity(ResponseState state, String message) {
        this(state.getCode(), message, null);
    }

}
