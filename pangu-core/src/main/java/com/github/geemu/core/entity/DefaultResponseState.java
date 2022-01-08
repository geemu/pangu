package com.github.geemu.core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * DefaultResponseState
 * @author 陈方明 cfmmail@sina.com
 * @since 2021-12-19 00:03:56
 */
@Getter
@ToString
@AllArgsConstructor
public enum DefaultResponseState implements ResponseState {

    /** 通用成功 **/
    OK(200, "成功"),
    OK_PARTIAL(206, "部分成功"),
    /** 通用客户端异常 **/
    CLIENT_ERROR(400, "客户端未知异常"),
    CLIENT_UN_AUTHENTICATION(401, "未认证"),
    CLIENT_UN_AUTHORIZATION(403, "未授权"),
    CLIENT_NOT_FOUND_PATH(404, "请求路径不存在"),
    /** 通用服务端异常 **/
    SERVER_ERROR(500, "服务端未知异常");

    /** 状态码 **/
    private final Integer code;
    /** 提示信息 **/
    private final String message;

}
