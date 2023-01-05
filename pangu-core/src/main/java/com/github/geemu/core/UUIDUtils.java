package com.github.geemu.core;

import java.util.UUID;

/**
 * UUID工具类
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-01-05 16:53
 */
public final class UUIDUtils {

  public UUIDUtils() {
    //ignore private construct
  }

  /**
   * 获取UUID.
   * @return String
   */
  public static String uuid() {
    return UUID.randomUUID().toString().replace("-", "").toUpperCase();
  }

}
