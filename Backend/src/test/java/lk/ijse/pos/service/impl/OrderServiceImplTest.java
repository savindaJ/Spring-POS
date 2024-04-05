package lk.ijse.pos.service.impl;

import lk.ijse.pos.config.WebRootConfig;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.dto.OrderDTO;
import lk.ijse.pos.dto.OrderDetailDTO;
import lk.ijse.pos.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
class OrderServiceImplTest {

    @Autowired
    OrderService orderService;

    @Test
    void saveOrder() {
        ArrayList<ItemDTO> items = new ArrayList<>();
        items.add(new ItemDTO("ITM-bbbdb846", "Item 1", 100.0, 10));

        boolean b = orderService.saveOrder(new OrderDTO(
                "OD-001",
                "CUS-bb3e5d1d",
                items
        ));
        System.out.println(b); // true
    }

    @Test
    void getAllOrders() {
        List<OrderDetailDTO> allOrders = orderService.getAllOrders();
        assertTrue(!allOrders.isEmpty());
    }

    @Test
    void getOrderCount() {
        int orderCount = orderService.getOrderCount();
        assertTrue(orderCount > 0);
    }

    @Test
    void getOrderDetailCount() {
        int orderDetailCount = orderService.getOrderDetailCount();
        assertTrue(orderDetailCount > 0);
    }

    @Test
    void geyIncome() {
        double income = orderService.getIncome();
        assertTrue(income > 0);
    }
}