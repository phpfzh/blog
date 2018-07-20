package com.jxkj.cjm.common.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
         System.out.println("================createRestApi=============================");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //.apis(RequestHandlerSelectors.basePackage("com.jxkj.cjm.controller"))
                 .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))  //只显示加了注解的api
                 .paths(PathSelectors.regex("/api.*"))
                 .build()
                 .globalOperationParameters(setHeaderToken());
    }

 /*   @Bean
    public Docket createRestPub(){
        System.out.println("================createRestPub=============================");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //.apis(RequestHandlerSelectors.basePackage("com.jxkj.cjm.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))  //只显示加了注解的api
                .paths(PathSelectors.any())
                .build();
    }*/

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("管理系统")
                .description("api 接口文档")
                .termsOfServiceUrl("http://localhost:8080/swagger-ui.html")
                //.contact(contact)
                .version("1.0")
                .build();
    }

    private List<Parameter> setHeaderToken() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("token")
                .description("token")
                .defaultValue("Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJidXM1MjgwIiwiYXVkIjoid2ViIiwiYmFzZUlkIjoiMTIiLCJleHAiOjE1MzIwODI1ODIsImlhdCI6MTUzMjA3ODk4Mn0.f-BBt6j01V-OJnBNuiz-cyOOkInBXfsWOkAduUme1j6sgbDIys5kaKrknU-665M6tRr0OGHedKdLjJSPe_iCxA")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false).build();
        pars.add(tokenPar.build());
        return pars;
    }

}
