package fortnoxcarrental.startup;

import fortnoxcarrental.domain.entity.Car;
import fortnoxcarrental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CarDataLoader implements CommandLineRunner {

    @Autowired
    private CarRepository carRepository;
    @Override
    public void run(String... args) throws Exception {
        carRepository.save(new Car("Volvo S60", 1500.00, true));
        carRepository.save(new Car("Volkswagen Golf", 1333.00, true));
        carRepository.save(new Car("Ford Mustang", 3000.00, true));
        carRepository.save(new Car("Ford Transit", 2400.00, true));

    }
}