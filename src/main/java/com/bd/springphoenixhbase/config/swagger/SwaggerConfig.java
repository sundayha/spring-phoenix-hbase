package com.bd.springphoenixhbase.config.swagger;

//import com.nd.svd.api.common.constants.SystemConstants;
//import org.apache.commons.lang3.StringUtils;
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

import java.util.ArrayList;
import java.util.List;

/**
 * SwaggerConfig
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket operationLogApi() {
            return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfoOnline())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bd.springphoenixhbase"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建人：张博【zhangb@lianliantech.cn】
     * 时间：2017/10/23 上午10:38
     *
     * @apiNote 添加swagger全局文档的参数，
     */
    private List<Parameter> setHeaderToken() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("Authorization").description("token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return pars;
    }

    private ApiInfo apiInfoOnline() {
        return new ApiInfoBuilder()
            .title("")
            .description("")
            .version("")
            .build();
    }

}
