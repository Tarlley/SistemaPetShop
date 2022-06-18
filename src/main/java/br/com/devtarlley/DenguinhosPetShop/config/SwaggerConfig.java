package br.com.devtarlley.DenguinhosPetShop.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

     @Bean
        public Docket petApi(){
         return new Docket(DocumentationType.SWAGGER_2)
                 .select()
                 .apis(RequestHandlerSelectors.basePackage("br.com.devtarlley.DenguinhosPetShop"))
                 .paths(regex("/api.*"))
//                 .paths(regex("/proprietarios.*"))
                 .build()
                 .apiInfo(metaInfo());
     }

     private ApiInfo metaInfo(){
         return new ApiInfo(
                 "Pet API REST",
                 "API REST sistema de petshop",
                 "1.0",
                 "Terms of Service",
                 new Contact("WendelTarlley","www.devtarlley.com.br","wendeltarlley@gmail.com"),
                 "Apache License Version 2.0",
                 "https://www.apache.org/licensen.html", new ArrayList<VendorExtension>()
         );
     }
}
