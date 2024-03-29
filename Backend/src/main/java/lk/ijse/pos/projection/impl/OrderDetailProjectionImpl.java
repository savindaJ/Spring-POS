package lk.ijse.pos.projection.impl;

import lk.ijse.pos.projection.OrderDetailProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

/**
 * @author : savindaJ
 * @date : 2024-03-29
 * @since : 0.1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailProjectionImpl implements OrderDetailProjection {
    private String orderId;
    private String customerId;
    private String itemCode;
    private Integer orderQuantity;
    @CreationTimestamp
    private Timestamp orderDate;
}
