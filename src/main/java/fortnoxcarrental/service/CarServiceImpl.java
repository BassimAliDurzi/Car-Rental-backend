package fortnoxcarrental.service;

import fortnoxcarrental.domain.dto.CarDTO;
import fortnoxcarrental.domain.entity.Car;
import fortnoxcarrental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car selectCar(CarDTO dto) {
        if (dto == null) throw new IllegalArgumentException("Car is null");

        Car carEntity = Car.builder()
                .model(dto.getModel())
                .build();

        Car savedSelectedCar = carRepository.save(carEntity);


        return savedSelectedCar;
    }
}
