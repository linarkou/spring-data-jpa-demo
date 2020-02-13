package ru.linarkou.loans.v2.converter;

import org.springframework.stereotype.Component;
import ru.linarkou.loans.v2.dto.PersonDTO;
import ru.linarkou.loans.v2.model.Application;
import ru.linarkou.loans.v2.model.Person;
import ru.linarkou.loans.v2.dto.ApplicationDTO;

import java.util.stream.Collectors;

@Component
public class Converter {
    public ApplicationDTO convertApplication(Application application) {
        if (application == null) {
            return null;
        }
        ApplicationDTO applicationDTO = convertOnlyApplication(application);
        applicationDTO.setPerson(convertOnlyPerson(application.getPerson()));
        return applicationDTO;
    }

    public PersonDTO convertPerson(Person person) {
        if (person == null) {
            return null;
        }
        PersonDTO personDTO = convertOnlyPerson(person);
        personDTO.setApplications(
                person.getApplications().stream()
                        .map(this::convertOnlyApplication)
                        .collect(Collectors.toList())
        );
        return personDTO;
    }

    public Application convertApplicationDTO(ApplicationDTO dto) {
        if (dto == null) {
            return null;
        }
        Application application = convertOnlyApplicationDTO(dto);
        application.setPerson(convertOnlyPersonDTO(dto.getPerson()));
        return application;
    }

    public Person convertPersonDTO(PersonDTO dto) {
        if (dto == null) {
            return null;
        }
        Person person = convertOnlyPersonDTO(dto);
        person.setApplications(
                dto.getApplications().stream()
                        .map(this::convertOnlyApplicationDTO)
                        .collect(Collectors.toList())
        );
        return person;
    }


    private ApplicationDTO convertOnlyApplication(Application application) {
        return ApplicationDTO.builder()
                .amount(application.getAmount())
                .term(application.getTerm())
                .creationDateTime(application.getCreationDateTime())
                .build();
    }

    private PersonDTO convertOnlyPerson(Person person) {
        return PersonDTO.builder()
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .passport(person.getPassport())
                .build();
    }

    public Application convertOnlyApplicationDTO(ApplicationDTO dto) {
        return Application.builder()
                .amount(dto.getAmount())
                .term(dto.getTerm())
                .creationDateTime(dto.getCreationDateTime())
                .build();
    }

    public Person convertOnlyPersonDTO(PersonDTO dto) {
        return Person.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .passport(dto.getPassport())
                .build();
    }
}
