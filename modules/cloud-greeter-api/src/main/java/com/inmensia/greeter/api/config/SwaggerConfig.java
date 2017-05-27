package com.inmensia.greeter.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
class SwaggerConfig {

  @Bean
  public Docket greeterApi() {
    return new Docket(DocumentationType.SWAGGER_2).groupName("greeter-api")
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
        .paths(PathSelectors.any())
        .build()
        .pathMapping("/")
        .genericModelSubstitutes(ResponseEntity.class)
        .useDefaultResponseMessages(false);
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Greeter-API")
        .description("Greeter API")
        .version("0.1.0-SNAPSHOT")
        .license("MIT")
        .licenseUrl("https://choosealicense.com/licenses/mit/")
        .build();
  }
}