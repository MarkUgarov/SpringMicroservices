package de.adesso.mholzmannfeignclient;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import feign.Feign;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FeignRestController {


    private final AdessiFeignInterface adessiService;

    private final EurekaClient eurekaClient;

    public FeignRestController(AdessiFeignInterface adessiFeignInterface, EurekaClient eurekaClient) {
        this.adessiService = adessiFeignInterface;
        this.eurekaClient = eurekaClient;
    }

    @GetMapping("/services")
    public String getServices() {
        Application application = eurekaClient.getApplication("adesso-mholzmann-microservice");
        List<InstanceInfo> instances = application.getInstances();

        return instances.stream()
                .map(instanceInfo -> instanceInfo.getHostName() + ":" + instanceInfo.getPort())
                .collect(Collectors.joining(" | "));
    }

    @GetMapping("/firstName")
    public String getFirstName() {
        AdessiFeignInterface feignClient = Feign.builder()
                .contract(new SpringMvcContract())
                .target(AdessiFeignInterface.class, "http://localhost:8091");

        return feignClient.getFirstName();
    }

    @GetMapping("/cc")
    public String fullName() {
        return adessiService.getFirstName() + " " +
                adessiService.getLastName();
    }
}