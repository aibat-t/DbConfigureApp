package kz.aibat.dbconfigureapp.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class People {

    private Long id;
    private String name;
    private String surname;
    private LocalDateTime birthDate;
    private String email;
}
