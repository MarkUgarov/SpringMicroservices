package de.adesso.mholzmannresilienceclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class    ResilienceRestController {
    private final CcLeaderService service;

    public ResilienceRestController(CcLeaderService service) {
        this.service = service;
    }

    @GetMapping("/ccleader")
    public String ccLeader() {
        return service.ccLeader();
    }
}
