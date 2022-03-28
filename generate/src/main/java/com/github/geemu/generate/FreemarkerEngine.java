package com.github.geemu.generate;

import com.github.geemu.generate.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.ap.shaded.freemarker.template.Configuration;
import org.mapstruct.ap.shaded.freemarker.template.Template;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Map;

import static org.mapstruct.ap.shaded.freemarker.template.Configuration.VERSION_2_3_21;

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
    public FreemarkerEngine init() {
        configuration = new Configuration(VERSION_2_3_21);
        configuration.setDefaultEncoding(StandardCharsets.UTF_8.name());
        configuration.setClassForTemplateLoading(FreemarkerEngine.class, "/");
        configuration.setLocalizedLookup(Boolean.TRUE);
        configuration.setLocale(Locale.SIMPLIFIED_CHINESE);
        configuration.setDateFormat("yyyy-MM-dd");
        configuration.setDateTimeFormat("yyyy-MM-dd HH:mm:ss");
        configuration.setOutputEncoding(StandardCharsets.UTF_8.name());
        return this;
    }

    /**
     * 输出文件
     * @param file         文件
     * @param context      渲染信息
     * @param templatePath 模板路径
     * @param fileOverride 是否覆盖已有文件
     */
    protected void outputFile(File file, Map<String, Object> context, String templatePath, boolean fileOverride) {
        if (!file.exists() || fileOverride) {
            return;
        }
        try {
            boolean exist = file.exists();
            if (!exist) {
                File parentFile = file.getParentFile();
                FileUtils.forceMkdir(parentFile);
            }
            this.writer(context, templatePath, file);
        } catch (Exception e) {
            throw new RuntimeException(e);
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

}
