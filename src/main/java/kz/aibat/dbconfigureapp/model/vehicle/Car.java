package kz.aibat.dbconfigureapp.model.vehicle;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand")
    private String brand;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Motor motor;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Wheel> wheelList;
}
