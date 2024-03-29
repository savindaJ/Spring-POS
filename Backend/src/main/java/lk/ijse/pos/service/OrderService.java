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
    /**
     * @param orderDTO OrderDTO
     * @return boolean
     */
    boolean saveOrder(OrderDTO orderDTO);

    /**
     * @return List<OrderDetailDTO>
     */
    List<OrderDetailDTO> getAllOrders();

    /**
     * @return List<OrderDetailProjection>
     */
    Integer getOrderCount();

    /**
     * @return List<OrderDetailProjection>
     */
    Integer getOrderDetailCount();

    /**
     * @return Double
     */
    Double geyIncome();
}
