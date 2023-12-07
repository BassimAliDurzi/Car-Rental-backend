package fortnoxcarrental.repository;

import fortnoxcarrental.domain.entity.CarRental;
import fortnoxcarrental.domain.dto.CarRentalDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRentalRepository extends JpaRepository<CarRental,Long> {
    @Override
    Optional<CarRental> findById(Long id);

    @Override
    List<CarRental> findAll();

}
