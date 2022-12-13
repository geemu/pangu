package com.github.geemu.generate.entity;

import lombok.Builder;
import lombok.Data;

/**
 * TemplateSource
 * @author 陈方明  cfmmail@sina.com
 * @since 2022-03-28 22:58:03
 */
@Data
@Builder
public class TemplateSource {

    /** 模板名称 **/
    private final String name;
    /** 模板内容 **/
    private final String templateContent;

}
