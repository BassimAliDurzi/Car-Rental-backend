package fortnoxcarrental.controller;

import fortnoxcarrental.domain.dto.UserDTO;
import fortnoxcarrental.domain.entity.User;
import fortnoxcarrental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> userValidation(@RequestBody UserDTO userDTO) {
        try {
            User loggedInUser = userService.login(userDTO);
            return ResponseEntity.ok("Successfully logged in as " + loggedInUser.getUsername());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + e.getMessage());
        }
    }
}
