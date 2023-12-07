package fortnoxcarrental.controller;

import fortnoxcarrental.domain.dto.CarRentalDTO;
import fortnoxcarrental.domain.entity.CarRental;
import fortnoxcarrental.service.CarRentalServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<CarRentalDTO> getCarRentalByID(@PathVariable Long id) {

        CarRental carRental = carRentalService.findById(id);

        if (carRental != null) {
            CarRentalDTO carRentalDTO = convertToDTO(carRental);
            return ResponseEntity.ok(carRentalDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/carrentals")
    public ResponseEntity<List<CarRentalDTO>> getAll() {
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
                .build();
    }
}
