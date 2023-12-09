package fortnoxcarrental.controller;

import fortnoxcarrental.domain.dto.CarRentalDTO;
import fortnoxcarrental.domain.entity.CarRental;
import fortnoxcarrental.service.CarRentalServiceImpl;
import fortnoxcarrental.service.CarServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/v1/FortnoxCarRental")
@RestController
public class CarRentalController {
    private final CarRentalServiceImpl carRentalService;

    @Autowired
    public CarRentalController(CarRentalServiceImpl carRentalService, CarServiceImpl carService) {
        this.carRentalService = carRentalService;
    }

    @PostMapping
    public ResponseEntity<CarRental> doRegisterOrder(@RequestBody @Valid CarRentalDTO dto) {
        System.out.println("DTO: " + dto);
        CarRental responseBody = carRentalService.registerOrder(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<CarRentalDTO> getCarRentalByID(@PathVariable Long id) {
        System.out.println("----->>>>>( Car Rental ID: " + id + " )<<<<<-----");
        CarRental carRental = carRentalService.findById(id);

        if (carRental == null) throw new IllegalArgumentException("No CarRental order was found with the ID: " + id);
        CarRentalDTO carRentalDTO = convertToDTO(carRental);
            return ResponseEntity.ok(carRentalDTO);
    }

    @GetMapping("/carrentals")
     public ResponseEntity<List<CarRentalDTO>> getAll() {
        System.out.println("----->>>>>( All Car Rental Orders )<<<<<-----");
        List<CarRentalDTO> carRentals = carRentalService.findAll();

        if (carRentals != null && !carRentals.isEmpty()) {
            return ResponseEntity.ok(carRentals);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    private CarRentalDTO convertToDTO(CarRental carRental) {
        return CarRentalDTO.builder()
                .customerName(carRental.getCustomerName())
                .age(carRental.getAge())
                .carModel(carRental.getCar().getModel())
                .pickUpdate(carRental.getPickUpdate())
                .returnDate(carRental.getReturnDate())
                .revenue((carRental.getRevenue()))
                .build();
    }
}
