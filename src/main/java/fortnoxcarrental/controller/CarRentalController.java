package fortnoxcarrental.controller;

import fortnoxcarrental.domain.dto.CarRentalDTO;
import fortnoxcarrental.domain.entity.Car;
import fortnoxcarrental.domain.entity.CarRental;
import fortnoxcarrental.service.CarRentalServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@RequestMapping("/api/v1/FortnoxCarRental")
@RestController
public class CarRentalController {

    private final CarRentalServiceImpl carRentalService;

    @Autowired
    public CarRentalController(CarRentalServiceImpl carRentalService) {
        this.carRentalService = carRentalService;
    }

    @PostMapping
    public ResponseEntity<CarRental> doRegisterOrder(@RequestBody @Valid CarRentalDTO dto) {
        System.out.println("DTO: " + dto);
        CarRental response = carRentalService.registerOrder(dto);
        return ResponseEntity.ok().body(response);
    }


}
