package com.github.geemu.pangu.uaa.domain.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 菜单布局
 * @author 陈方明  cfmmail@sina.com
 * @since 2021-04-17 11:51:04
 */
@Getter
@AllArgsConstructor
public enum LayoutEnum {

    LEFT_NAV("左侧导航栏"),
    TOP_NAV("顶部导航栏"),
    FAVOURITE("收藏栏");

    private final String desc;

}
