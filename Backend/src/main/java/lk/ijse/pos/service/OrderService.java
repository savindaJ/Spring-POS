package lk.ijse.pos.service;

import lk.ijse.pos.dto.OrderDTO;
import lk.ijse.pos.dto.OrderDetailDTO;
import lk.ijse.pos.projection.OrderDetailProjection;

import java.util.List;

/**
 * @author : savindaJ
 * @date : 2024-03-29
 * @since : 0.1.0
 **/
public interface OrderService {
    boolean saveOrder(OrderDTO orderDTO);

    List<OrderDetailDTO> getAllOrders();

    Integer getOrderCount();

    Integer getOrderDetailCount();

    Double geyIncome();
}
