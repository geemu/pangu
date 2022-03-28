package com.github.geemu.generate.utils;

import java.io.File;

/**
 * FileUtils
 * @author 陈方明  cfmmail@sina.com
 * @since 2022-03-22 20:45:18
 */
public class FileUtils {

    /**
     * 创建文件夹
     * @param directory directory
     * @return boolean
     */
    public static boolean forceMkdir(final File directory) {
        if (directory.exists()) {
            if (!directory.isDirectory()) {
                return Boolean.FALSE;
            }
        } else {
            if (!directory.mkdirs()) {
                if (!directory.isDirectory()) {
                    return Boolean.FALSE;
                }
            }
        }
        return Boolean.TRUE;
    }

}
