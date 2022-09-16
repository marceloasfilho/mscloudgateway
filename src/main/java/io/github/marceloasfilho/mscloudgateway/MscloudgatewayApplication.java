package io.github.marceloasfilho.mscloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "io.github.marceloasfilho.mscloudgateway")
@EnableEurekaClient
@EnableDiscoveryClient
public class MscloudgatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MscloudgatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder
                .routes()
                .route(r -> r.path("/clientes/**").uri("lb://MSCLIENTES/"))
                .build();
    }
}
