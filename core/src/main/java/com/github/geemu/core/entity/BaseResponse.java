package com.github.geemu.core.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

/**
 * 基础实体
 * @author 陈方明 cfmmail@sina.com
 * @since 2021-01-17 22:20
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("包装返回体")
@Accessors(chain = true)
@ToString(callSuper = true)
public class BaseResponse<T> {

    /** 状态码 **/
    private Integer code;
    /** 提示信息 **/
    private String message;
    /** 返回数据 **/
    private T data;

}
