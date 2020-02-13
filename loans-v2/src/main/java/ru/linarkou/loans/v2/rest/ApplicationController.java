package ru.linarkou.loans.v2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.linarkou.loans.v2.service.ApplicationService;
import ru.linarkou.loans.v2.dto.ApplicationDTO;

import java.util.List;

@RestController
@RequestMapping("v2")
public class ApplicationController {
    private final ApplicationService service;

    @Autowired
    public ApplicationController(ApplicationService service) {
        this.service = service;
    }

    @GetMapping("application")
    public List<ApplicationDTO> getAllApplications() {
        return service.getAllApplications();
    }

    @PostMapping("application")
    public Long saveApplication(@RequestBody ApplicationDTO application) {
        return service.saveApplication(application);
    }

    @GetMapping(path = "application", params = "firstName")
    public List<ApplicationDTO> getApplicationsByPersonFirstName(
            @RequestParam String firstName) {
        return service.getApplicationsByPersonFirstName(firstName);
    }

    @GetMapping(path = "application", params = "minAmount")
    public List<ApplicationDTO> getApplicationsWithAmountGreaterThan(
            @RequestParam Long minAmount) {
        return service.getApplicationsWithAmountGreaterThan(minAmount);
    }
}
