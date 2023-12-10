package fortnoxcarrental.service;


import fortnoxcarrental.domain.dto.UserDTO;
import fortnoxcarrental.domain.entity.User;

public interface UserService {
    User login(UserDTO userDTO);
}
