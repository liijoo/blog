package com.example.blog.config;

import com.example.blog.common.SwaggerCore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {
    @Bean
    Docket systemIndexApi() {
        return SwaggerCore.defaultDocketBuilder("接口领域模型定义", "com.example.blog", "blog");
    }
}
