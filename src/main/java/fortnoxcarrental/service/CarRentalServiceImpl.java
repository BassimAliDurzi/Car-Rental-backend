package fortnoxcarrental.service;

import fortnoxcarrental.domain.dto.CarRentalDTO;
import fortnoxcarrental.domain.entity.Car;
import fortnoxcarrental.domain.entity.CarRental;
import fortnoxcarrental.repository.CarRentalRepository;
import fortnoxcarrental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

        List<CarRental> lastReservation = carRentalRepository.findTop1ByCarOrderByReturnDateDesc(car);

        if (!lastReservation.isEmpty() && dto.getPickUpdate().isBefore(lastReservation.get(0).getReturnDate())) {
            throw new IllegalArgumentException("Car is not available for this date");
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

    @Override
    public List<CarRentalDTO> findAll() {
        List<CarRental> carRentals = carRentalRepository.findAll();
        return carRentals.stream()
                .map(this::mapToCarRentalDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CarRental findById(Long id) {
        return carRentalRepository.findById(id)
                .orElse(null);
    }
    private CarRentalDTO mapToCarRentalDTO(CarRental carRental) {
        return CarRentalDTO.builder()
                .id(carRental.getId())
                .customerName(carRental.getCustomerName())
                .age(carRental.getAge())
                .carModel(carRental.getCar().getModel())
                .pickUpdate(carRental.getPickUpdate())
                .returnDate(carRental.getReturnDate())
                .revenue(carRental.getRevenue())
                .build();
    }
}


