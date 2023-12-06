package fortnoxcarrental.service;

import fortnoxcarrental.domain.dto.CarDTO;
import fortnoxcarrental.domain.dto.CarRentalDTO;
import fortnoxcarrental.domain.entity.CarRental;

import java.util.List;


public interface CarRentalService {
    CarRental registerOrder(CarRentalDTO dto);
    List<CarRental> getAll();

}
