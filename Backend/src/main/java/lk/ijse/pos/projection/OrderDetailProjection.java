package lk.ijse.pos.projection;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.EntityResult;
import jakarta.persistence.SqlResultSetMapping;
import lk.ijse.pos.projection.impl.OrderDetailProjectionImpl;

import java.sql.Timestamp;

/**
 * @author : savindaJ
 * @date : 2024-03-29
 * @since : 0.1.0
 **/
public interface OrderDetailProjection {
    String getOrderId();

    String getCustomerId();

    String getItemCode();

    Integer getOrderQuantity();

    Timestamp getOrderDate();

}
