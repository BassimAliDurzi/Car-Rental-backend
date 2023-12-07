package fortnoxcarrental.service;

import fortnoxcarrental.domain.dto.CarDTO;
import fortnoxcarrental.domain.dto.CarRentalDTO;
import fortnoxcarrental.domain.entity.Car;
import fortnoxcarrental.domain.entity.CarRental;

public interface CarService {
    Car addCar(CarDTO dto);
    Car selectCar(CarDTO dto);
}
