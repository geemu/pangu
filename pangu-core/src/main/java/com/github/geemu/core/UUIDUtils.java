package com.github.geemu.core;

import java.util.UUID;

/**
 * UUID工具类
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-01-05 16:53
 */
public final class UUIDUtils {

  /** 工具类隐藏public构造器 **/
  public UUIDUtils() {
    // ignore
  }

  /**
   * 获取UUID.
   * @return String
   */
  public static String uuid() {
    return UUID.randomUUID().toString().replace("-", "").toUpperCase();
  }

}
