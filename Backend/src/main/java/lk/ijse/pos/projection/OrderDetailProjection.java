package lk.ijse.pos.projection;

import java.sql.Timestamp;

/**
 * @author : savindaJ
 * @date : 2024-03-29
 * @since : 0.1.0
 **/
public interface OrderDetailProjection {
    /**
     * @return orderId
     */
    String getOrderId();

    /**
     * @return customerId
     */
    String getCustomerId();

    /**
     * @return itemCode
     */
    String getItemCode();

    /**
     * @return orderQuantity
     */
    Integer getOrderQuantity();

    /**
     * @return orderDate
     */
    Timestamp getOrderDate();

}
