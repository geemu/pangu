package com.github.geemu.generate;

import com.github.geemu.generate.utils.FileUtils;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * FreemarkerEngine
 * @author 陈方明  cfmmail@sina.com
 * @since 2022-03-26 14:05:45
 */
@Slf4j
@Getter
public class FreemarkerEngine {

    /**
     * 将模板转化成为文件
     * @param template 模板
     * @param context 渲染上下文参数信息
     * @param outPath 输出路径
     * @param fileOverride 是否覆盖原有文件
     */
    public void writer(Template template, Map<String, Object> context, String outPath, boolean fileOverride) {
        if (null == outPath) {
            return;
        }
        File file = new File(outPath);
        boolean exist = file.exists();
        if (exist && !fileOverride) {
            return;
        }
        if (!exist) {
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
            log.error("模板写出异常,e", e);
        }
    }

    /**
     * 将模板转化成为文件
     * @param template 模板内容
     * @param context 渲染上下文参数信息
     * @param outPath 输出路径
     * @param fileOverride 是否覆盖原有文件
     */
    public void writer(String template, Map<String, Object> context, String outPath, boolean fileOverride) {
        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        configuration.setDefaultEncoding(StandardCharsets.UTF_8.name());
        configuration.setLocalizedLookup(Boolean.TRUE);
        configuration.setLocale(Locale.SIMPLIFIED_CHINESE);
        configuration.setDateFormat("yyyy-MM-dd");
        configuration.setDateTimeFormat("yyyy-MM-dd HH:mm:ss");
        configuration.setOutputEncoding(StandardCharsets.UTF_8.name());
        StringTemplateLoader templateLoader = new StringTemplateLoader();
        configuration.setTemplateLoader(templateLoader);
        Template tpl;
        try {
            tpl = new Template("", null, new StringReader(template), configuration, StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            log.error("获取模板异常,e", e);
            return;
        }
        this.writer(tpl, context, outPath, fileOverride);
    }

    public static void main(String[] args) throws Exception {
        FreemarkerEngine engine = new FreemarkerEngine();
        Map<String, Object> context = new HashMap<>(16);
        context.put("userName", "dsadadsadsadaddsadadadad");
        context.put("age", 11);
        engine.writer("${userName}", context, "C:\\Users\\chenfangming\\Desktop\\a.txt", Boolean.TRUE);
    }

}
