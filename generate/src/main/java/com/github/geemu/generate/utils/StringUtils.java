package com.github.geemu.generate.utils;

/**
 * StringUtils
 * @author 陈方明  cfmmail@sina.com
 * @since 2022-03-22 20:45:18
 */
public final class StringUtils {

    /**
     * 是否为空
     * @param cs cs
     * @return boolean
     */
    public static boolean isBlank(CharSequence cs) {
        if (cs != null) {
            int length = cs.length();
            for (int i = 0; i < length; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

}
