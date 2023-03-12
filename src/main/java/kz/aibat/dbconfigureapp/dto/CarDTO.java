package kz.aibat.dbconfigureapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class CarDTO {

    private String brand;

    private MotorDTO motor;

    private List<WheelDTO> wheelList;
}
