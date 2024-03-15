package de.adesso.adessomholzmannmicroservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdessiRestController implements AdessiRestInterface {

    @Value("${course}")
    private String course;

    @Value("${server.port}")
    private String port;

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


    @GetMapping("/adessi/courseAttended")
    public String getCourse() {
        return course;
    }

    @GetMapping("/")
    public String getPort(){
        return port;
    }
}
