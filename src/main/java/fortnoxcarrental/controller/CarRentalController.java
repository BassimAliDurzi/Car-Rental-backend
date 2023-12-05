package fortnoxcarrental.controller;


import fortnoxcarrental.domain.dto.CarRentalDTO;
import fortnoxcarrental.domain.entity.CarRental;
import fortnoxcarrental.service.CarRentalServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
