package lk.ijse.pos.repo;

import lk.ijse.pos.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : savindaJ
 * @date : 2024-03-29
 * @since : 0.1.0
 **/
public interface OrderRepo extends JpaRepository<Orders, String> {
}
