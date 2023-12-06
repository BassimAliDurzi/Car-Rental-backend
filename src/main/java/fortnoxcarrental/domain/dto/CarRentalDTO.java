package fortnoxcarrental.domain.dto;

import fortnoxcarrental.domain.entity.Car;
import jakarta.validation.ValidationException;
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

    @NotNull
    private String carModel;


    @NotNull
    @Future
    private LocalDate pickUpdate;

    @NotNull
    @Future
    private LocalDate returnDate;

    public Car getCar() {
        return null;
    }

    public void validateDates() {
        if (pickUpdate != null && returnDate != null && returnDate.isBefore(pickUpdate)) {
            throw new ValidationException("Return date must be after pick-up date");
        }
    }

}
