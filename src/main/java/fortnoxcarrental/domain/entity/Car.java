package fortnoxcarrental.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString

@Entity
public class Car{

    @Id
    @Column(updatable = false)
    private String model;

    @Column(nullable = false)
    private double rentPerDay;

    private Boolean available;

    @OneToMany(mappedBy = "car")
    private Set<CarRental> carRentals = new HashSet<>();

    public Car(String model, double rentPerDay, Boolean available) {
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.available = available;
    }

    public Car(String model, double rentPerDay) {
        this.model = model;
        this.rentPerDay = rentPerDay;
    }

    public Car(String model) {
        this.model = model;
    }

}
