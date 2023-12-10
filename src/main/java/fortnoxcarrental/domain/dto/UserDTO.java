package fortnoxcarrental.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString

public class UserDTO {

    @NotBlank(message = "Please fill out username.")
    private String username;

    @NotBlank(message = "Please fill out password.")
    private String password;

    private String role;

    public UserDTO(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
