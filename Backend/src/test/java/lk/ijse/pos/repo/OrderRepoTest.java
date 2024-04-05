package lk.ijse.pos.repo;

import lk.ijse.pos.config.WebRootConfig;
import lk.ijse.pos.projection.OrderDetailProjection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : savindaJ
 * @date : 2024-04-05
 * @since : 0.1.0
 **/
@SpringJUnitConfig(WebRootConfig.class)
@WebAppConfiguration
@Transactional
class OrderRepoTest {

    @Autowired OrderRepo orderRepo;

    @Test
    void getAllOrderDetails() {
        List<OrderDetailProjection> allOrderDetails = orderRepo.getAllOrderDetails();
        allOrderDetails.forEach((projection)->{
            System.out.println(projection.getOrderId());
            System.out.println(projection.getCustomerId());
            System.out.println(projection.getItemCode());
            System.out.println(projection.getOrderQuantity());
            System.out.println(projection.getOrderDate());
        });
    }

    @Test
    void getOrderCount() {
        Integer orderCount = orderRepo.getOrderCount();
        System.out.println(orderCount);
    }

    @Test
    void orderDetailCount() {
        Integer orderDetailCount = orderRepo.orderDetailCount();
        System.out.println(orderDetailCount);
    }

    @Test
    void getIncome() {
        Double income = orderRepo.getIncome();
        System.out.println(income);
    }
}