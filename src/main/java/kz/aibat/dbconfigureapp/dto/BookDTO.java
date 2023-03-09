package kz.aibat.dbconfigureapp.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookDTO {
    private String name;
    private BigDecimal price;
}
