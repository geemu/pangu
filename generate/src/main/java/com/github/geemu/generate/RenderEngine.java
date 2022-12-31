package com.github.geemu.generate;

import com.github.geemu.generate.utils.FileUtils;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 * FreemarkerEngine
 * @author 陈方明  cfmmail@sina.com
 * @since 2022-03-26 14:05:45
 */
@Slf4j
public class RenderEngine {

    /** 配置 **/
    private static final Configuration CONFIGURATION = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);

    static {
        CONFIGURATION.setDefaultEncoding(StandardCharsets.UTF_8.name());
        CONFIGURATION.setLocalizedLookup(Boolean.TRUE);
        CONFIGURATION.setLocale(Locale.SIMPLIFIED_CHINESE);
        CONFIGURATION.setDateFormat("yyyy-MM-dd");
        CONFIGURATION.setDateTimeFormat("yyyy-MM-dd HH:mm:ss");
        CONFIGURATION.setOutputEncoding(StandardCharsets.UTF_8.name());
        CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        StringTemplateLoader templateLoader = new StringTemplateLoader();
        CONFIGURATION.setTemplateLoader(templateLoader);
    }

    /**
     * 添加模板
     * @param name 模板名称
     * @param templateContent 模板内容
     */
    public static void addTemplate(String name, String templateContent, boolean override) {
        Template tpl = (Template) CONFIGURATION.getCacheStorage().get(name);
        if (null != tpl && !override) {
            return;
        }
        try {
            tpl = new Template(name, name, new StringReader(templateContent), CONFIGURATION, StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            log.error("添加模板异常,e", e);
            return;
        }
        CONFIGURATION.getCacheStorage().put(name, tpl);
    }

    /**
     * 获取模板
     * @param name 模板名称
     */
    public static Template getTemplate(String name) {
        return (Template) CONFIGURATION.getCacheStorage().get(name);
    }

    /**
     * 渲染模板
     * @param template 模板
     * @param context 渲染上下文参数信息
     * @param outPath 输出路径
     */
    public static void render(Template template, Object context, String outPath) {
        if (null == template || null == outPath) {
            return;
        }
        File file = new File(outPath);
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            boolean success = FileUtils.forceMkdir(parentFile);
            if (!success) {
                log.error("文件夹创建失败,directory:{}", parentFile);
                return;
            }
        }
        try {
            try (FileOutputStream fos = new FileOutputStream(file)) {
                template.process(context, new OutputStreamWriter(fos, StandardCharsets.UTF_8));
            }
        } catch (Exception e) {
            log.error("模板渲染异常,e", e);
        }
    }

    /**
     * 将模板转化成为文件
     * @param templateContent 模板内容
     * @param context 渲染上下文参数信息
     * @param outPath 输出路径
     */
    public static void render(String templateContent, Object context, String outPath) {
        RenderEngine.addTemplate("", templateContent, Boolean.TRUE);
        Template tpl = RenderEngine.getTemplate("");
        if (null == tpl) {
            return;
        }
        RenderEngine.render(tpl, context, outPath);
    }

}
