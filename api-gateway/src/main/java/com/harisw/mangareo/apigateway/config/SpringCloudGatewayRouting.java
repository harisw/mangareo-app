package com.harisw.mangareo.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudGatewayRouting {
    @Bean
    public RouteLocator configureRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("manga-service", r->r.path("/manga/**").uri("http://localhost:8081"))
                .route("authId", r->r.path("/auth/**").uri("http://localhost:8082"))
                .build();
    }
}
