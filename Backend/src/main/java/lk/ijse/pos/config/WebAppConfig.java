package lk.ijse.pos.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author : savindaJ
 * @date : 2024-03-28
 * @since : 0.1.0
 **/
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"lk.ijse.pos.api","lk.ijse.pos.util"})
public class WebAppConfig {
}
