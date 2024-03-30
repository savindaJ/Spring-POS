package lk.ijse.pos.api;

import jakarta.validation.Valid;
import lk.ijse.pos.dto.LoginRequest;
import lk.ijse.pos.dto.UserDTO;
import lk.ijse.pos.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : savindaJ
 * @date : 2024-03-30
 * @since : 0.1.0
 **/
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    /**
     * @param userService : UserService
     */
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    /**
     * @param user : UserDTO
     * @return : ResponseEntity<String>
     */
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody @Valid UserDTO user) {
        System.out.println(user);
        boolean isSignUp = userService.signUp(user);
        if (isSignUp) {
            return new ResponseEntity<>("User Registered Successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("User Registration Failed", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * @param loginRequest : LoginRequest
     * @return : ResponseEntity<Map<String, String>>
     */
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody @Valid LoginRequest loginRequest) {
        boolean user = userService.findUser(loginRequest);
        Map<String, String> message = new HashMap<>();
        if (user) {
            message.put("message", "User Login Successfully");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "User Login Failed");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }
}
