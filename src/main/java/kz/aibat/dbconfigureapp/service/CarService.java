package kz.aibat.dbconfigureapp.service;

import kz.aibat.dbconfigureapp.dbconnections.repositories.CarRepositories;
import kz.aibat.dbconfigureapp.dto.CarDTO;
import kz.aibat.dbconfigureapp.mapper.CarMapper;
import kz.aibat.dbconfigureapp.model.vehicle.Car;
import kz.aibat.dbconfigureapp.model.vehicle.Motor;
import kz.aibat.dbconfigureapp.model.vehicle.Wheel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepositories carRepositories;
    private final CarMapper carMapper;

    public List<CarDTO> getCarList(){
        return carMapper.carListToCarDTOList(carRepositories.findAll());
    }

    public CarDTO getCarById(Long id){
        return carMapper.carToCarDTO(carRepositories.getCarById(id));
    }

    public void saveCar(CarDTO carDTO){
        Car car = carMapper.carDTOToCar(carDTO);
        carRepositories.save(car);
    }

    public void updateCar(Long id, CarDTO carDTO){
        Car currentCar = carRepositories.getCarById(id);
        Car updatedCar = carMapper.carDTOToCar(carDTO);

        currentCar.setBrand(updatedCar.getBrand());

        Motor motor = currentCar.getMotor();
        motor.setHorsePower(updatedCar.getMotor().getHorsePower());
        motor.setSerialNumber(updatedCar.getMotor().getSerialNumber());
        currentCar.setMotor(motor);

        List<Wheel> wheelList = currentCar.getWheelList();
        List<Wheel> updatedWheelList = updatedCar.getWheelList();
        int increment = 0;
        for(Wheel w: updatedWheelList){
            Wheel wheel = wheelList.get(increment);
            wheel.setBrand(w.getBrand());
            wheel.setSize(w.getSize());
            increment++;
        }

        currentCar.setWheelList(wheelList);

        carRepositories.save(currentCar);
    }

    public void deleteCar(Long id) {
        carRepositories.deleteById(id);
    }
}
