package de.adesso.mholzmannapigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route("rewritepath2_test", route -> route
                        .order(0)
                        .path("/mein/firstName")
                        .filters(f ->
                                f.rewritePath("/mein/firstName", "/adessi/lastName")
                        )
                        .uri("http://localhost:8091")
                )
                .route("rewritepath_test", route -> route
                        .order(1)
                        .path("/mein/**")
                        .filters(f ->
                                f.rewritePath("/mein/(?<segment>.*)", "/adessi/$\\{segment}")
                        )
                        .uri("http://localhost:8091")
                )
                .route("rewritepath3_test", route -> route
                        .order(3)
                        .path("/meinsAuch/**")
                        .filters(f -> {
                                    f.rewritePath("/meinsAuch/(?<segment>.*)", "/adessi/$\\{segment}");
                                    return f.filter(new MyGatewayFilter());
                                }
                        )
                        .uri("http://localhost:8091")
                )
                .build();
    }

}
