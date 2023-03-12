package kz.aibat.dbconfigureapp.dbconnections.repositories;

import kz.aibat.dbconfigureapp.model.vehicle.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepositories extends JpaRepository<Car, Long> {
    Car getCarById(Long id);
}
