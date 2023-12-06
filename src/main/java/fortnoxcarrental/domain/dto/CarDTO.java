package fortnoxcarrental.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString

public class CarDTO {

    @NotBlank(message = "Model cannot be blank")
    private String model;

}
