package de.adesso.mholzmannloadbalancerclient;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class LoadBalanceConfig {

    @Bean
    @Primary
    public ServiceInstanceListSupplier getAdessiServiceInstanceListSupplier() {
        return new ServiceInstanceListSupplierImpl("adessi");
    }
}
