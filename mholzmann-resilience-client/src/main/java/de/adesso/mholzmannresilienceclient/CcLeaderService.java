package de.adesso.mholzmannresilienceclient;

import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CcLeaderService {

    private final RestTemplate restTemplate;
    private final CircuitBreakerFactory circuitBreakerFactory;

    public CcLeaderService(RestTemplate restTemplate, CircuitBreakerFactory circuitBreakerFactory) {
        this.restTemplate = restTemplate;
        this.circuitBreakerFactory = circuitBreakerFactory;
    }

    public String ccLeader() {
        CircuitBreaker circuitbreaker = circuitBreakerFactory.create("circuitbreaker");
        String url = "http://localhost:8091/adessi/ccleader";

        return circuitbreaker.run(() -> restTemplate.getForObject(url, String.class), throwable -> ccLeaderFallback());
    }

    public String ccLeaderFallback() {
        return "Ist doch egal, wir haben flache Hierarchien ;-)!";
    }
}
