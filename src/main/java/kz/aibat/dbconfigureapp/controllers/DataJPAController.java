package kz.aibat.dbconfigureapp.controllers;

import kz.aibat.dbconfigureapp.dto.CarDTO;
import kz.aibat.dbconfigureapp.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa")
@RequiredArgsConstructor
public class DataJPAController {

    private final CarService carService;

    @GetMapping()
    public List<CarDTO> getList(){
        return carService.getCarList();
    }

    @GetMapping("/{id}")
    public CarDTO getCarById(@PathVariable("id") Long id) {
        return carService.getCarById(id);
    }

    @PostMapping()
    public void createCar(@RequestBody CarDTO carDTO){
        carService.saveCar(carDTO);
    }

    @PatchMapping("/{id}")
    public void updateCar(@RequestBody CarDTO carDTO, @PathVariable("id") Long id){
        carService.updateCar(id, carDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable("id") Long id){
        carService.deleteCar(id);
    }
}
