package de.adesso.mholzmannloadbalancerclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class LoadBalancerRestController {

    private final WebClient.Builder loadBalancedWebClientBuilder;

    public LoadBalancerRestController(WebClient.Builder loadBalancedWebClientBuilder) {
        this.loadBalancedWebClientBuilder = loadBalancedWebClientBuilder;
    }

    @GetMapping("/")
    public Mono<String> getMono() {
        return loadBalancedWebClientBuilder.build()
                .get().uri("http://adessi/")
                .retrieve().bodyToMono(String.class);
    }
}
