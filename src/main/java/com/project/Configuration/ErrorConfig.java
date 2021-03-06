package com.project.Configuration;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorConfig {
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryWebServerFactoryCustomizer(){
        return factory -> {
            ErrorPage errorPage404=new ErrorPage(HttpStatus.NOT_FOUND,"/error/404.html");
            ErrorPage errorPage500=new ErrorPage(HttpStatus.SERVICE_UNAVAILABLE,"/error/500.html");
            factory.addErrorPages(errorPage404);
            factory.addErrorPages(errorPage500);
        };
    }
}
