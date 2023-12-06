package fortnoxcarrental.domain.dto;

import fortnoxcarrental.domain.entity.Car;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class CarRentalDTO {

    @NotBlank
    private String customerName;

    @NotNull
    @Min(18)
    private int age;

    //@NotNull
    CarDTO car;


    @NotNull
    @Future
    private LocalDate pickUpdate;

    @NotNull
    @Future
    private LocalDate returnDate;

    public Car getCar() {
        return null;
    }
}
