package ru.linarkou.loans.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.linarkou.loans.v1.model.Application;
import ru.linarkou.loans.v1.repository.ApplicationRepository;

import java.util.List;
import java.util.Optional;

@Service // @Component с бизнес логикой
public class ApplicationService {
    // @Autowired // над полем не рекомендуется
    private final ApplicationRepository repository;

    @Autowired  // лучше через конструктор
    public ApplicationService(ApplicationRepository repository) {
        this.repository = repository;
    }

    public Optional<Application> getById(Long id) {
        return repository.findById(id);
    }

    public List<Application> getAllApplications() {
        return repository.findAll();
    }

    public Application saveApplication(Application app) {
        return repository.save(app);
    }
}
