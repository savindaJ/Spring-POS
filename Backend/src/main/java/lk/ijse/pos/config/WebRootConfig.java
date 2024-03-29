package lk.ijse.pos.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author : savindaJ
 * @date : 2024-03-28
 * @since : 0.1.0
 **/
@Configuration
@ComponentScan(basePackages = {"lk.ijse.pos.service","lk.ijse.pos.repo","lk.ijse.pos.advisor"})
@Import(JPAConfig.class)
@PropertySource("classpath:application.properties")
public class WebRootConfig {
}
