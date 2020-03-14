package com.evan.wj.config;

import com.evan.wj.interceptor.LoginInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.*;

@SpringBootConfiguration
public class MyWebConfigurer implements WebMvcConfigurer{


    @Override
    public void addCorsMappings(CorsRegistry registry){
        //所有请求允许跨域
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins("http://localhost:8080")
                .allowedMethods("POST","GET","PUT","OPTIONS","DELETE")
                .allowedHeaders("*")
                .maxAge(3600);

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api/file/**").addResourceLocations("file:" + "d:/workspace/img/");
    }



}
