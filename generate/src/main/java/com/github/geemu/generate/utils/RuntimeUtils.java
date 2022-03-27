package com.github.geemu.generate.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 运行工具类
 * @author nieqiurong 2020/11/13.
 * @since 3.5.0
 */
@Slf4j
public class RuntimeUtils {

    /** 操作系统-Windows **/
    public static final String OS_NAME_WINDOWS = "Windows";
    /** 操作系统-Mac **/
    public static final String OS_NAME_MAC = "Mac";

    /** 操作系统打开目录命令-Windows **/
    public static final String OS_CMD_OPEN_WINDOWS = "cmd /c start ";
    /** 操作系统打开目录命令-Mac **/
    public static final String OS_CMD_OPEN_MAC = "open ";

    /**
     * 打开指定输出文件目录
     * @param outDir 输出文件目录
     */
    public static void openDir(String outDir) throws IOException {
        String osName = System.getProperty("os.name");
        if (null == osName) {
            log.warn("读取操作系统失败");
            return;
        }
        log.info("文件输出目录:{}", outDir);
        if (OS_NAME_WINDOWS.contains(osName)) {
            Runtime.getRuntime().exec(OS_CMD_OPEN_WINDOWS + outDir);
        } else if (OS_NAME_MAC.contains(osName)) {
            Runtime.getRuntime().exec(OS_CMD_OPEN_MAC + outDir);
        }
    }

}
