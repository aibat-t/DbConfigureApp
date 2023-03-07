package kz.aibat.dbconfigureapp.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PersonDTO {

    private String name;
    private String surname;
    private LocalDateTime birthDate;
    private String email;
}
