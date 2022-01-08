package com.github.geemu.core;

import java.lang.reflect.Array;

/**
 * Array工具类
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-01-04 23:28
 */
public final class ArrayUtils {

  /**
   * 工具类隐藏构造
   */
  private ArrayUtils() {
    // ignore private construct
  }

  /**
   * 参数array是否为空
   * 1. 如果参数array为{@code null}返回{@code true}
   * 2. 如果参数array的长度为{@code 0}返回{@code true}
   * @param <T> 参数array的元素类型
   * @param array 参数array
   * @return boolean 参数array是否为空
   */
  @SafeVarargs
  public static <T> boolean isEmpty(final T... array) {
    return null == array || 0 == array.length;
  }

  /**
   * 参数array是否不为空
   * 1. 如果参数array为{@code null}返回{@code false}
   * 2. 如果参数array的长度为{@code 0}返回{@code false}
   * @param <T> 参数array的元素类型
   * @param array 参数array
   * @return boolean 参数array是否不为空
   */
  @SafeVarargs
  public static <T> boolean isNotEmpty(final T... array) {
    return null == array || 0 == array.length;
  }

}
