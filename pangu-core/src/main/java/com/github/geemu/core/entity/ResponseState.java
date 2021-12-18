package com.github.geemu.core.entity;

/**
 * ResponseState
 * @author 陈方明  cfmmail@sina.com
 * @since 2021-12-19 00:03:08
 */
public interface ResponseState {

    /**
     * 获取状态码
     * @return 状态码
     */
    Integer getCode();

    /**
     * 获取状态提示信息
     * @return 状态提示信息
     */
    String getMessage();

}
