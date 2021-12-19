package com.github.geemu.core.entity;

/**
 * DefaultResponseState
 * @author 陈方明  cfmmail@sina.com
 * @since 2021-12-19 00:03:56
 */
public enum DefaultResponseState implements ResponseState {

    /** 成功 **/
    SUCCESS(200, "成功"),
    BAD_REQUEST(400, "请求参数检验不通过"),
    UN_AUTHENTICATION(401, "未认证"),
    UN_AUTHORIZATION(403, "未授权"),
    NOT_FOUND_PATH(404, "请求路径不存在"),
    UNKNOWN_EXCEPTION(500, "后台未知异常");

    /** 状态码 **/
    private final Integer code;
    /** 提示信息 **/
    private final String message;

    DefaultResponseState(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
