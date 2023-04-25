package com.example.url.shortner.microservices.apigateway;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UrlRoutes {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){

        return builder.routes()
                .route(r ->r.path("/submiturl")
                        .filters(f -> f.rewritePath("/submiturl", "/validation")) // Rewrite the path from "/get" to "/validation"
                        .uri("http://localhost:8000/"))
                .build();
    }
}
