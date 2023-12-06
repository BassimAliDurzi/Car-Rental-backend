package fortnoxcarrental.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString


@Entity
public class CarRental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "model")
    private Car car;

    private LocalDateTime createDate;

    @Column(nullable = false)
    private LocalDate pickUpdate;

    @Column(nullable = false)
    private LocalDate returnDate;

    private Double revenue;


    public CarRental(String customerName, int age, Car car, LocalDate pickUpdate, LocalDate returnDate) {
        this.customerName = customerName;
        this.age = age;
        this.car = car;
        this.pickUpdate = pickUpdate;
        this.returnDate = returnDate;
    }

    public CarRental(Long id, String customerName, int age, Car car, LocalDateTime createDate, LocalDate pickUpdate, LocalDate returnDate, Double revenue) {
        this.id = id;
        this.customerName = customerName;
        this.age = age;
        this.car = car;
        this.createDate = LocalDateTime.now();
        this.pickUpdate = pickUpdate;
        this.returnDate = returnDate;
        this.revenue = revenue;
    }


    @PrePersist
    public void calculateRevenue() {
        createDate = LocalDateTime.now();
        if (pickUpdate != null && returnDate != null && car != null) {
            long days = returnDate.toEpochDay() - pickUpdate.toEpochDay();
            revenue = days * car.getRentPerDay();
        }
    }
}
