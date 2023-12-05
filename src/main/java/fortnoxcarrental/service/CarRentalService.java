package fortnoxcarrental.service;

import fortnoxcarrental.domain.dto.CarRentalDTO;
import fortnoxcarrental.domain.entity.CarRental;


public interface CarRentalService {
    CarRental registerOrder(CarRentalDTO dto);

}
