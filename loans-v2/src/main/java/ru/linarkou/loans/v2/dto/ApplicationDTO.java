package ru.linarkou.loans.v2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDTO {
    private Long amount;
    private Integer term;
    private PersonDTO person;
    private LocalDateTime creationDateTime;
}
