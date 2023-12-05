package fortnoxcarrental.domain.entity;

import jakarta.persistence.*;
import lombok.*;

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
    private Integer id;

    private String model;

    @Column(nullable = false)
    private double rentPerDay;

    @Column()
    private Boolean available;

    public Car(String model, double rentPerDay, Boolean available) {
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.available = available;
    }

    public Car(String model, double rentPerDay) {
        this.model = model;
        this.rentPerDay = rentPerDay;
    }
}
