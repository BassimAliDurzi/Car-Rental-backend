package fortnoxcarrental.repository;

import fortnoxcarrental.domain.entity.CarRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRentalRepository extends JpaRepository<CarRental,Long> {

    @Query("SELECT cr from CarRental cr")
    List<CarRental> findAllCarRental();
}
