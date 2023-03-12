package kz.aibat.dbconfigureapp.mapper;

import kz.aibat.dbconfigureapp.dto.CarDTO;
import kz.aibat.dbconfigureapp.model.vehicle.Car;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarDTO carToCarDTO(Car car);

    Car carDTOToCar(CarDTO carDTO);

    List<CarDTO> carListToCarDTOList(List<Car> carList);
}
