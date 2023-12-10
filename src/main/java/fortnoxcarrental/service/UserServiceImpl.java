package fortnoxcarrental.service;

import fortnoxcarrental.domain.dto.UserDTO;
import fortnoxcarrental.domain.entity.User;
import fortnoxcarrental.repository.CarRentalRepository;
import fortnoxcarrental.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CarRentalRepository carRentalRepository;

    public UserServiceImpl(UserRepository userRepository, CarRentalRepository carRentalRepository) {
        this.userRepository = userRepository;
        this.carRentalRepository = carRentalRepository;
    }

    @Override
    public User login(UserDTO userDTO) {
        if (userDTO == null || userDTO.getUsername() == null || userDTO.getPassword() == null) {
            throw new IllegalArgumentException("Invalid user");
        }

        Optional<User> optionalUser = userRepository.findById(userDTO.getUsername());

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(userDTO.getPassword())) {
                carRentalRepository.findAll();

                return user;
            } else {
                throw new IllegalArgumentException("Invalid password");
            }
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }

}
