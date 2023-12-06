package fortnoxcarrental.service;

import fortnoxcarrental.domain.dto.CarDTO;
import fortnoxcarrental.domain.dto.CarRentalDTO;
import fortnoxcarrental.domain.entity.CarRental;
import fortnoxcarrental.repository.CarRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarRentalServiceImpl implements CarRentalService {

    private final CarRentalRepository carRentalRepository;

    @Autowired
    public CarRentalServiceImpl(CarRentalRepository carRentalRepository) {
        this.carRentalRepository = carRentalRepository;
    }

    @Override
    public CarRental registerOrder(CarRentalDTO dto) {
        if (dto == null) throw new IllegalArgumentException("CarRental is null");

        CarRental carRentalEntity = CarRental.builder()
                .customerName(dto.getCustomerName())
                .age(dto.getAge())
                .car(dto.getCar())
                .pickUpdate(dto.getPickUpdate())
                .returnDate(dto.getReturnDate())
                .build();

        CarRental savedCarRental = carRentalRepository.save(carRentalEntity);

        return savedCarRental;
    }

    @Override
    public List<CarRental> getAll() {
        return null;
    }
}
