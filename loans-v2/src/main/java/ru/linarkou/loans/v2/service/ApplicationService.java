package ru.linarkou.loans.v2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.linarkou.loans.v2.model.Application;
import ru.linarkou.loans.v2.converter.Converter;
import ru.linarkou.loans.v2.dto.ApplicationDTO;
import ru.linarkou.loans.v2.repository.ApplicationRepository;
import ru.linarkou.loans.v2.repository.PersonRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final PersonRepository personRepository;
    private final Converter converter;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository,
                              PersonRepository personRepository,
                              Converter converter) {
        this.applicationRepository = applicationRepository;
        this.personRepository = personRepository;
        this.converter = converter;
    }

    @Transactional
    public Optional<Application> getById(Long id) {
        return applicationRepository.findById(id.toString());
    }

    //UPD: конвертация в DTO + @Transactional
    @Transactional
    public List<ApplicationDTO> getAllApplications() {
        List<Application> applications = applicationRepository.findAll();
        return applications.stream()
                .map(converter::convertApplication)
                .collect(Collectors.toList());
    }

    // UPD: добавил поиск существующего пользователя по номеру паспорта перед сохранением
    @Transactional
    public Long saveApplication(ApplicationDTO appDTO) {
        Application application = converter.convertApplicationDTO(appDTO);

        personRepository.findPersonByPassport(appDTO.getPerson().getPassport())
                    .ifPresent(foundPerson -> application.setPerson(foundPerson));

        Application savedApplication = applicationRepository.save(application);
        return savedApplication.getId();
    }

    @Transactional
    public List<ApplicationDTO> getApplicationsByPersonFirstName(String firstName) {
        List<Application> applications = applicationRepository.findAllByPerson_FirstName(firstName);
        return applications.stream()
                .map(converter::convertApplication)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ApplicationDTO> getApplicationsWithAmountGreaterThan(Long minAmount) {
        List<Application> applications = applicationRepository.findAllByAmountGreaterThan(minAmount);
        return applications.stream()
                .map(converter::convertApplication)
                .collect(Collectors.toList());
    }
}
