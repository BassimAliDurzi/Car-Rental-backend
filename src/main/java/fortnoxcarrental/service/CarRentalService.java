package fortnoxcarrental.service;

import fortnoxcarrental.domain.entity.CarRental;
import fortnoxcarrental.domain.dto.CarRentalDTO;

import java.util.List;


public interface CarRentalService {
    CarRental registerOrder(CarRentalDTO dto);
    List<CarRentalDTO> findAll();
    CarRental findById(Long id);
}
