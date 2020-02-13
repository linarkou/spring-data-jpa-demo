package ru.linarkou.loans.v1.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.linarkou.loans.v1.model.Application;
import ru.linarkou.loans.v1.service.ApplicationService;

import java.util.List;

@RestController
@RequestMapping("v1")
public class ApplicationController {
    private final ApplicationService service;

    @Autowired
    public ApplicationController(ApplicationService service) {
        this.service = service;
    }

    @GetMapping("application")
    public List<Application> getAllApplications() {
        List<Application> applications = service.getAllApplications();
        return applications;
    }

    // если бы у нас был не @RestController, а @Controller
    // то надо писать следующие аннотации
    @PostMapping("application")
    @ResponseBody
    public Application saveApplication(@RequestBody Application application) {
        return service.saveApplication(application);
    }
}
