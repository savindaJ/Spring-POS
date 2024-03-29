package lk.ijse.pos.repo;

import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.SqlResultSetMappings;
import lk.ijse.pos.dto.OrderDetailDTO;
import lk.ijse.pos.entity.Orders;
import lk.ijse.pos.projection.OrderDetailProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author : savindaJ
 * @date : 2024-03-29
 * @since : 0.1.0
 **/
public interface OrderRepo extends JpaRepository<Orders, String> {
    @Query(value = "SELECT o.order_id AS orderId, o.customer_id AS customerId, od.item_code AS itemCode, od.order_quantity AS orderQuantity, o.order_date AS orderDate " +
            "FROM orders o " +
            "JOIN order_detail od ON o.order_id = od.order_id", nativeQuery = true)
    List<OrderDetailProjection> getAllOrderDetails();
}
