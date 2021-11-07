package com.github.geemu.pangu.backend.app;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 后台管理程序入口
 * @author 陈方明  cfmmail@sina.com
 * @since 2021-01-17 22:20
 */
@SpringBootApplication
public class BackendApp {

    /**
     * 主函数
     * @param args 运行参数
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BackendApp.class);
        app.setAllowBeanDefinitionOverriding(Boolean.TRUE);
        app.setWebApplicationType(WebApplicationType.SERVLET);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
