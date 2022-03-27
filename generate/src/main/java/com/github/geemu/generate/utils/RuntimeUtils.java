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

    /**
     * 打开指定输出文件目录
     * @param outDir 输出文件目录
     */
    public static void openDir(String outDir) throws IOException {
        String osName = System.getProperty("os.name");
        if (osName != null) {
            if (osName.contains("Mac")) {
                Runtime.getRuntime().exec("open " + outDir);
            } else if (osName.contains("Windows")) {
                Runtime.getRuntime().exec("cmd /c start " + outDir);
            } else {
//                  log.debug("文件输出目录:{}", outDir);
            }
        } else {
            // log.warn("读取操作系统失败");
        }
    }
}
