package com.github.geemu.pangu.core;

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
