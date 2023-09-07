package com.edu.analysis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 解决跨域问题的配置类
@Configuration
public class MyConfig implements WebMvcConfigurer {

    // 配置跨域访问规则
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")  // 允许所有来源
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")  // 允许的请求方法
                .allowCredentials(true)  // 允许携带凭证（例如：Cookies）
                .maxAge(3600)  // 设置预检请求的有效期（秒）
                .allowedHeaders("*");  // 允许的请求头
    }

    // 配置静态资源映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 配置静态资源路径映射，将URL路径映射到classpath中的静态资源目录
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/static/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
    }
}
