package alisson.FirstWebAPI.doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
@EnableSwagger2

public class SwaggerConfig {

    private Contact contact(){
        return new Contact("Your name",
                "http://www.yourwebsite.com",
                "yourEmail@email.com");
    }

    private ApiInfoBuilder apiInfoBuilder(){

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("Title - Postgres Rest API");
        apiInfoBuilder.description("My First Rest API using Postgres");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Terms of Service: Open Source");
        apiInfoBuilder.license("Alisson - AlissonCompany");
        apiInfoBuilder.licenseUrl("http://www.myWebite.com");
        apiInfoBuilder.contact(this.contact());

        return apiInfoBuilder;

    }

    @Bean
    public Docket docketAPI(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("alisson.FirstWebAPI.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.apiInfoBuilder().build())
                .consumes(new HashSet<String>(Arrays.asList("application/json")))
                .produces(new HashSet<String>(Arrays.asList("application/json")));

        return docket;

    }
}