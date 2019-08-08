package com.kangswx.springbootswagger2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2 {

    /**
     * 生成API对象
     * @return
     */
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //controller包的路径,生成controller对应的API文档
                .apis(RequestHandlerSelectors .basePackage("com.kangswx.springbootswagger2.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 生成API描述信息
     * @return
     */
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Spring整合Swagger2的API")
                .description("简单优雅的rest风格，https://blog.csdn.net/kangswx")
                .termsOfServiceUrl("https://blog.csdn.net/kangswx")
                .version("1.0")
                .build();
    }
}
