package lk.ijse.pos.service;

import lk.ijse.pos.dto.OrderDTO;

/**
 * @author : savindaJ
 * @date : 2024-03-29
 * @since : 0.1.0
 **/
public interface OrderService {
    boolean saveOrder(OrderDTO orderDTO);
}
