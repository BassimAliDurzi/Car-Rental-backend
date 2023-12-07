package fortnoxcarrental.repository;

import fortnoxcarrental.domain.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {
    @Override
    Optional<Car> findById(String model);

    @Override
    List<Car> findAll();

}
