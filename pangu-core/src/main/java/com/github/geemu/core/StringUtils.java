package com.github.geemu.core;

/**
 * String工具类
 * @author 陈方明  cfmmail@sina.com
 * @since 2018-10-25 20:25
 */
public final class StringUtils {

    private StringUtils() {
        //ignore private construct
    }

    /**
     * 参数cs是否不为空
     * 1. 参数cs为{@code null}返回{@code false}
     * 2. 参数cs为{@code ""}返回{@code false}
     * @param cs 参数cs
     * @return boolean 参数cs是否不为空
     */
    public static boolean isNotEmpty(final CharSequence cs) {
        return !isEmpty(cs);
    }

    /**
     * 参数cs是否为空
     * 1. 参数cs为{@code null}返回{@code true}
     * 2. 参数cs为{@code ""}返回{@code true}
     * @param cs 参数cs
     * @return boolean 参数cs是否为空
     */
    public static boolean isEmpty(final CharSequence cs) {
        return null == cs || 0 == cs.length();
    }

    /**
     * 参数cs是否包不含空白
     * 1. 参数cs为{@code null}返回{@code true}
     * 2. 参数cs含{@code null}元素返回{@code false}
     * 3. 参数cs含{@code ""}元素返回{@code false}
     * 4. 参数cs含{@code " "}元素返回{@code false}
     * @param cs 参数cs
     * @return 参数cs是否包不含空白
     */
    public static boolean hasNoBank(final CharSequence... cs) {
        return !hasBank(cs);
    }

    /**
     * 参数cs是否包含空白
     * 1. 参数cs为{@code null}返回{@code false}
     * 2. 参数cs含{@code null}元素返回{@code true}
     * 3. 参数cs含{@code ""}元素返回{@code true}
     * 4. 参数cs含{@code " "}元素返回{@code true}
     * @param cs 参数cs
     * @return 参数cs是否包含空白
     */
    public static boolean hasBank(final CharSequence... cs) {
        if (ArrayUtils.isEmpty(cs)) {
            return Boolean.FALSE;
        }
        for (final CharSequence item : cs) {
            if (isBlank(item)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * 参数cs是否为空白
     * 1. 参数cs为{@code null}返回{@code true}
     * 2. 参数cs为{@code ""}返回{@code true}
     * 2. 参数cs全部为{@code " "}返回{@code true}
     * @param cs 参数cs
     * @return 参数cs是否为空白
     */
    public static boolean isBlank(final CharSequence cs) {
        int csLength;
        if (null == cs || 0 == (csLength = cs.length())) {
            return Boolean.TRUE;
        }
        for (int i = 0; i < csLength; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    /**
     * 参数cs是否全为空白
     * 1. 参数cs为{@code null}返回{@code true}
     * 2. 参数cs元素全为{@code null}返回{@code true}
     * 3. 参数cs长度为{@code o}返回{@code true}
     * @param cs 参数cs
     * @return 参数cs是否全为空白
     */
    public static boolean isAllBlank(final CharSequence... cs) {
        if (ArrayUtils.isEmpty(cs)) {
            return Boolean.TRUE;
        }
        for (final CharSequence item : cs) {
            if (isNotBlank(item)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    /**
     * 参数cs是否不为空白
     * 1. 参数cs为{@code null}返回{@code false}
     * 2. 参数cs为{@code ""}返回{@code false}
     * 3. 参数cs全部为{@code " "}返回{@code false}
     * @param cs 参数cs
     * @return 参数cs是否不为空白
     */
    public static boolean isNotBlank(final CharSequence cs) {
        return !isBlank(cs);
    }

    /**
     * 参数s去除前后空格
     * 1. 参数s为{@code null}返回{@code null}
     * 2. 参数s去除前后空格后为{@code ""}返回{@code null}
     * @param s 参数s
     * @return 参数s去除前后空格
     */
    public static String trimToNull(final String s) {
        final String ds = trim(s);
        return isEmpty(ds) ? null : ds;
    }

    /**
     * 参数s去除前后空格
     * 1. 参数s为{@code null}返回{@code null}
     * @param s 参数s
     * @return 参数s去除前后空格
     */
    public static String trim(final String s) {
        return null != s ? s.trim() : null;
    }

    /**
     * 参数s去除前后空格
     * 1. 参数s为{@code null}返回{@code ""}
     * 2. 参数s去除前后空格后为{@code ""}返回{@code ""}
     * @param s 参数s
     * @return 参数s去除前后空格
     */
    public static String trimToEmpty(final String s) {
        return s == null ? "" : s.trim();
    }

    /**
     * 参数s截取指定长度
     * @param s 参数s
     * @param length 指定长度
     * @return 参数s截取指定长度
     * @throws IllegalArgumentException length不符合规范抛出异常
     */
    public static String truncate(final String s, final int length) throws IllegalArgumentException {
        return truncate(s, 0, length);
    }

    /**
     * 参数s从指定位置截取指定长度
     * 1. 参数s为{@code null}返回{@code null}
     * 2. 参数s的长度小于需要截取的长度，返回可以被截取的长度
     * @param s 参数s
     * @param beginIndex 开始截取位置索引
     * @param length 指定长度
     * @return 参数s从指定位置截取指定长度
     * @throws IllegalArgumentException 参数beginIndex、length不符合规范抛出异常
     */
    public static String truncate(final String s, final int beginIndex, final int length) throws IllegalArgumentException {
        if (null == s || beginIndex < 0 || length < 0 || beginIndex > s.length()) {
            return "";
        }
        if (s.length() > length) {
            final int endIndex = Math.min(beginIndex + length, s.length());
            return s.substring(beginIndex, endIndex);
        }
        return s.substring(beginIndex);
    }

}
