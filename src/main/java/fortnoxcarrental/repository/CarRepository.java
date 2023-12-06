package fortnoxcarrental.repository;

import fortnoxcarrental.domain.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {
    @Override
    Optional<Car> findById(String model);

    @Override
    List<Car> findAll();

    @Modifying
    @Query("update Car  c set c.available = :available where c.model = :model")
    void updateAvailable(@Param("model") String model, @Param("available") boolean available);
}
