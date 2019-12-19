package com.transactions.ms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	@Bean
	public Docket customerSwagger() {
		return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(
                    RequestHandlerSelectors
                    .basePackage("com.transactions.ms.controller"))
            .paths(PathSelectors.any())
            .build();
}
	
	
	/*@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.enable(true)
				.select()
				.paths(PathSelectors.ant("/customers/ms/controller/**"))
				.build();
		
	}
	
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Reactive Services")
				.description("Reactive Services DEMo")
				.version("2.0")
				.build();
	}*/
}
