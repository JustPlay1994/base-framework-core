package com.justplay1994.github.baseframework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Package: com.justplay1994.github.baseframework.config
 * @Project: base-framework
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/10/22 9:07
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/22 9:07
 * @Update_Description: huangzezhou 补充
 **/
@Configuration
@EnableSwagger2
public class Swagger2Config {
    //swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                        //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.justplay1994.github.baseframework.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("JustPlay1994 Base Framework")
                        //创建人
                .contact(new Contact("JustPlay1994", "https://github.com/JustPlay1994/base-framework", ""))
                        //版本号
                .version("1.0")
                        //描述
                .description("API 描述")
                .build();
    }


}
