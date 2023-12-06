package fortnoxcarrental.service;

import fortnoxcarrental.domain.dto.CarDTO;
import fortnoxcarrental.domain.entity.Car;

public interface CarService {
    Car selectCar(CarDTO dto);
}
