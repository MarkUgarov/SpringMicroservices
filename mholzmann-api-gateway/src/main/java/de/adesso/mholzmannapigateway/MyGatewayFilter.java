package de.adesso.mholzmannapigateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpMethod;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

public class MyGatewayFilter implements GatewayFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            HttpMethod method =  exchange.getRequest().getMethod();
            URI uri = exchange.getRequest().getURI();
            String message = String.format("I am a custom prefilter and can do whatever i want. I was called for method %s and URI %s", method, uri.toString());
            System.out.println(message);
        }));
    }
}
