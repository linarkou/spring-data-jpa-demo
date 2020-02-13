package ru.linarkou.loans.v2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    private String firstName;
    private String lastName;
    private String passport;
    private List<ApplicationDTO> applications;
}
