package lk.ijse.pos.service.impl;

import lk.ijse.pos.config.WebRootConfig;
import lk.ijse.pos.dto.LoginRequest;
import lk.ijse.pos.dto.UserDTO;
import lk.ijse.pos.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : savindaJ
 * @date : 2024-04-05
 * @since : 0.1.0
 **/
@SpringJUnitConfig(WebRootConfig.class)
@WebAppConfiguration
@Transactional
class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    void signUp() {
        boolean b = userService.signUp(new UserDTO(
                "thantrige32@gmail.com",
                "Savinda",
                "212121",
                "21212"
        ));
        assertTrue(b);
    }

    @Test
    void findUser() {
        assertThrows(RuntimeException.class, () -> userService.findUser(new LoginRequest("sasas", "sasas")));
    }
}