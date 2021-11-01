package com.github.geemu.core;

/**
 * StringUtils
 * @author 陈方明  cfmmail@sina.com
 * @since 2021-01-17 22:20
 */
public final class StringUtils {

    private StringUtils() {
        // ignore private construct
    }

    /**
     * text是否为null
     * @param text text
     * @return {@code true}如果text为null
     */
    public static boolean isNull(String text) {
        return null == text;
    }

}
