package fortnoxcarrental.domain.dto;

import jakarta.validation.ValidationException;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@ToString

public class CarRentalDTO {

    @NotBlank(message = "You must type your name")
    private String customerName;

    @NotNull(message = "You must type your age")
    @Min(18)
    private int age;

    @NotNull(message = "You must choose your car")
    private String carModel;

    @NotNull(message = "You must choose pick-up date")
    @Future
    private LocalDate pickUpdate;

    @NotNull(message = "You must choose return date")
    @Future
    private LocalDate returnDate;


    public CarRentalDTO(String customerName, int age, String carModel, LocalDate pickUpdate, LocalDate returnDate) {
        this.customerName = customerName;
        this.age = age;
        this.carModel = carModel;
        this.pickUpdate = pickUpdate;
        this.returnDate = returnDate;
        validateDates();
    }


    public void validateDates() {
        if (pickUpdate != null && returnDate != null && !returnDate.isAfter(pickUpdate)) {
            throw new ValidationException("Return date must be after pick-up date");
        }
    }
}
