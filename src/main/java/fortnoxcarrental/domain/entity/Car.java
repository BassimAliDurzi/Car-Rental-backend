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

@Entity
public class Car{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    private String model;

    @Column(nullable = false)
    private double rentPerDay;

    @Column()
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
