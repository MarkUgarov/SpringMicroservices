package de.adesso.uebung1;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdessiRestController implements AdessiRestInterface {
    @Override
    public String getFirstName() {
        return "Mark";
    }

    @Override
    public String getLastName() {
        return "Holzmann";
    }

    @Override
    public String getLineOfBusiness() {
        return "Java";
    }

    @Override
    public String getCompetenceCenter() {
        return "LOB Cross Industries DEV";
    }

    @Override
    public String getCompetenceCenterLeader() {
        return "who knows?";
    }

    @Override
    public String getJobDescription() {
        return "Developer";
    }
}
