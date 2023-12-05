package fortnoxcarrental.repository;

import fortnoxcarrental.domain.entity.CarRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRentalRepository extends JpaRepository<CarRental,Long> {
}
