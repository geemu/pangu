package com.github.geemu.generate.utils;

import java.io.File;
import java.io.IOException;

/**
 * FileUtils
 * @author 陈方明  cfmmail@sina.com
 * @since 2022-03-22 20:45:18
 */
public class FileUtils {

    public static void forceMkdir(final File directory) throws IOException {
        if (directory.exists()) {
            if (!directory.isDirectory()) {
                throw new IOException("File " + directory + " exists and is " + "not a directory. Unable to create directory.");
            }
        } else {
            if (!directory.mkdirs()) {
                if (!directory.isDirectory()) {
                    throw new IOException("Unable to create directory " + directory);
                }
            }
        }
    }

    /**
     * forceMkdirParent
     * @param file file
     * @throws IOException IOException
     */
    public static void forceMkdirParent(final File file) throws IOException {
        final File parent = file.getParentFile();
        if (parent == null) {
            return;
        }
        forceMkdir(parent);
    }

}
