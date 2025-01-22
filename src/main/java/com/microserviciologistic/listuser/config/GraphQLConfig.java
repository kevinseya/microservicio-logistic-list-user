package com.microserviciologistic.listuser.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.server.WebGraphQlInterceptor;
import org.springframework.context.annotation.Bean;

@Configuration
public class GraphQLConfig {

    @Bean
    public WebGraphQlInterceptor loggingInterceptor() {
        return (webGraphQlRequest, chain) -> {
            return chain.next(webGraphQlRequest);
        };
    }
}