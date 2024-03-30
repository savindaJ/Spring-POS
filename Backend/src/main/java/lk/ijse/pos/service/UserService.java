package lk.ijse.pos.service;

import lk.ijse.pos.dto.LoginRequest;
import lk.ijse.pos.dto.UserDTO;

/**
 * @author : savindaJ
 * @date : 2024-03-30
 * @since : 0.1.0
 **/
public interface UserService {
    boolean signUp(UserDTO userDTO);
    boolean findUser(LoginRequest request);
}
