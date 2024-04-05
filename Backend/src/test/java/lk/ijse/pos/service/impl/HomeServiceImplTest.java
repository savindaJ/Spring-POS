package lk.ijse.pos.service.impl;

import lk.ijse.pos.config.WebRootConfig;
import lk.ijse.pos.service.HomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : savindaJ
 * @date : 2024-04-05
 * @since : 0.1.0
 **/
@SpringJUnitConfig(WebRootConfig.class)
@WebAppConfiguration
@Transactional
class HomeServiceImplTest {

    @Autowired
    HomeService homeService;

    @Test
    void getStatus() {
        Map<String, Number> status = homeService.getStatus();
        assertNotNull(status);
        status.forEach((key, value) -> {
            assertNotNull(key);
            assertNotNull(value);
            System.out.println(key + " : " + value);
        });
    }
}