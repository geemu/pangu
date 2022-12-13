package com.github.geemu.generate.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
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
    /** 操作系统osName属性 **/
    public static final String SYSTEM_PROPERTY_OS_NAME = System.getProperty("os.name");

    /**
     * 打开指定输出文件目录
     * @param outDir 输出文件目录
     */
    public static void openDir(String outDir) {
        if (StringUtils.isBlank(outDir) || !new File(outDir).exists()) {
            log.error("未找到输出目录:{}", outDir);
            return;
        }
        if (null == SYSTEM_PROPERTY_OS_NAME) {
            log.warn("读取操作系统失败");
            return;
        }
        log.info("文件输出目录:{}", outDir);
        try {
            if (OS_NAME_WINDOWS.contains(SYSTEM_PROPERTY_OS_NAME)) {
                Runtime.getRuntime().exec(OS_CMD_OPEN_WINDOWS + outDir);
            } else if (OS_NAME_MAC.contains(SYSTEM_PROPERTY_OS_NAME)) {
                Runtime.getRuntime().exec(OS_CMD_OPEN_MAC + outDir);
            }
        } catch (IOException e) {
            log.error("打开文件输出目录异常outDir:{},e:", outDir, e);
        }
    }

}
