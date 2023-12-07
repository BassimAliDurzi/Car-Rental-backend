package fortnoxcarrental.controller;

import fortnoxcarrental.domain.dto.CarDTO;
import fortnoxcarrental.domain.entity.Car;
import fortnoxcarrental.service.CarServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    private final CarServiceImpl carService;

    @Autowired
    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }


    @PostMapping
    public ResponseEntity<Car> selectCar(@RequestBody @Valid CarDTO dto) {
        System.out.println("DTO: " + dto);
        Car response = carService.selectCar(dto);
        return ResponseEntity.ok().body(response);


    }

}
