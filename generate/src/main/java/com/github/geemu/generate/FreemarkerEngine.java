package com.github.geemu.generate;

import com.github.geemu.generate.utils.FileUtils;
import com.github.geemu.generate.utils.RuntimeUtils;
import com.github.geemu.generate.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.ap.shaded.freemarker.template.Configuration;
import org.mapstruct.ap.shaded.freemarker.template.Template;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * FreemarkerEngine
 * @author 陈方明  cfmmail@sina.com
 * @since 2022-03-26 14:05:45
 */
@Slf4j
public class FreemarkerEngine {

    private Configuration configuration;

    /**
     * 初始化模板引擎
     */
    public void init() {

    }

    /**
     * 检查是否应该创建文件
     * @param file         文件
     * @param fileOverride 是否覆盖已有文件
     * @return 是否创建文件
     */
    protected boolean shouldCreate(File file, boolean fileOverride) {
        return !file.exists() || fileOverride;
    }

    /**
     * 输出文件
     * @param file         文件
     * @param context      渲染信息
     * @param templatePath 模板路径
     * @param fileOverride 是否覆盖已有文件
     */
    protected void outputFile(File file, Map<String, Object> context, String templatePath, boolean fileOverride) {
        if (null == file || null == context || null == templatePath) {
            throw new IllegalArgumentException("参数不能为空");
        }
        if (!shouldCreate(file, fileOverride)) {
            return;
        }
        try {
            boolean exist = file.exists();
            if (!exist) {
                File parentFile = file.getParentFile();
                FileUtils.forceMkdir(parentFile);
            }
            this.writer(context, templatePath, file);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * 将模板转化成为文件
     * @param context      渲染信息
     * @param templatePath 模板文件
     * @param outputFile   文件生成的目录
     * @throws Exception 异常
     */
    public void writer(Map<String, Object> context, String templatePath, File outputFile) throws Exception {
        Template template = configuration.getTemplate(templatePath);
        try (FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
            template.process(context, new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
        }
    }

    /**
     * 打开输出目录
     */
    public void open() {
        String outDir = "";
        boolean open = Boolean.TRUE;
        if (StringUtils.isBlank(outDir) || !new File(outDir).exists()) {
            System.err.println("未找到输出目录：" + outDir);
        } else if (open) {
            try {
                RuntimeUtils.openDir(outDir);
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

}
