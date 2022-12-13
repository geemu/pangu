package com.github.geemu.generate.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

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

    /**
     * 获取指定文件夹下所有文件,不含文件夹
     * @param path 文件夹路径
     * @return List<File>
     */
    public static List<File> getAllFile(String path) {
        if (StringUtils.isBlank(path)) {
            return new ArrayList<>();
        }
        return getAllFile(new File(path));
    }

    /**
     * 获取指定文件夹下所有文件,不含文件夹
     * @param dirFile 文件夹
     * @return List<File>
     */
    public static List<File> getAllFile(File dirFile) {
        if (Objects.isNull(dirFile) || !dirFile.exists() || dirFile.isFile()) {
            return new ArrayList<>();
        }
        File[] childrenFiles = dirFile.listFiles();
        if (Objects.isNull(childrenFiles) || childrenFiles.length == 0) {
            return new ArrayList<>();
        }
        List<File> response = new ArrayList<>();
        for (File childFile : childrenFiles) {
            if (childFile.isFile()) {
                response.add(childFile);
            } else {
                List<File> cFiles = getAllFile(childFile);
                if (cFiles.isEmpty()) {
                    continue;
                }
                response.addAll(cFiles);
            }
        }
        return response;
    }

    /**
     * 读取文件内同
     * @param file file
     * @return String
     */
    public static String read(File file) {
        Scanner sc;
        StringBuilder data = new StringBuilder();
        try {
            sc = new Scanner(file.toPath(), StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            return data.toString();
        }
        while (sc.hasNextLine()) {
            data.append(sc.nextLine());
        }
        return data.toString();
    }

}
