package fortnoxcarrental.domain.dto;

import jakarta.validation.ValidationException;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDate;

@Data
@Builder
@ToString

public class CarRentalDTO {

    private Long id;

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

    private Double revenue;


    public CarRentalDTO(Long id, String customerName, int age, String carModel, LocalDate pickUpdate, LocalDate returnDate, Double revenue) {
        this.id = id;
        this.customerName = customerName;
        this.age = age;
        this.carModel = carModel;
        this.pickUpdate = pickUpdate;
        this.returnDate = returnDate;
        this.revenue = revenue;

        validateDates();
    }


    public void validateDates() {
        if (pickUpdate != null && returnDate != null && !returnDate.isAfter(pickUpdate)) {
            throw new ValidationException("Return date must be after pick-up date");
        }
    }


}
