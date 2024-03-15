package de.adesso.mholzmannloadbalancerclient;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import reactor.core.publisher.Flux;

import java.util.List;

public class ServiceInstanceListSupplierImpl implements ServiceInstanceListSupplier {

    private final String serviceId;

    public ServiceInstanceListSupplierImpl(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String getServiceId() {
        return serviceId;
    }

    @Override
    public Flux<List<ServiceInstance>> get() {
        String serviceId = getServiceId();
        return Flux.just(List.of(
                new DefaultServiceInstance(serviceId + "1", serviceId, "localhost", 8091, false),
                new DefaultServiceInstance(serviceId + "2", serviceId, "localhost", 8092, false),
                new DefaultServiceInstance(serviceId + "3", serviceId, "localhost", 8093, false)));
    }
}
