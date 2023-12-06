package fortnoxcarrental.service;

import fortnoxcarrental.domain.dto.CarRentalDTO;
import fortnoxcarrental.domain.entity.Car;
import fortnoxcarrental.domain.entity.CarRental;
import fortnoxcarrental.repository.CarRentalRepository;
import fortnoxcarrental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarRentalServiceImpl implements CarRentalService {

    private final CarRentalRepository carRentalRepository;
    private final CarRepository carRepository;

    @Autowired
    public CarRentalServiceImpl(CarRentalRepository carRentalRepository, CarRepository carRepository) {
        this.carRentalRepository = carRentalRepository;
        this.carRepository = carRepository;
    }

    @Override
    public CarRental registerOrder(CarRentalDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("CarRental is null");
        }

        Car car = carRepository.findById(dto.getCarModel())
                .orElseThrow(() -> new IllegalArgumentException("Car model is not valid"));

        if (!car.getAvailable()) {
            throw new IllegalArgumentException("Car is not available for rental");
        }

        CarRental carRentalEntity = CarRental.builder()
                .customerName(dto.getCustomerName())
                .age(dto.getAge())
                .car(car)
                .pickUpdate(dto.getPickUpdate())
                .returnDate(dto.getReturnDate())
                .build();

        CarRental savedCarRental = carRentalRepository.save(carRentalEntity);
        car.setAvailable(false);
        carRepository.save(car);

        return savedCarRental;
    }
}


