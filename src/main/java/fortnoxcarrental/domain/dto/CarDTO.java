package fortnoxcarrental.domain.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString

public class CarDTO {

    @NotBlank(message = "Model cannot be blank")
    private String model;

    @NotNull(message = "You should type the rent per day for this model")
    private double rentPerDay;

    private boolean available;


    public CarDTO(String model, double rentPerDay, boolean available) {
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.available = available;

    }
}
