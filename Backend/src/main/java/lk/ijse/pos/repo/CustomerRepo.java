package lk.ijse.pos.repo;

import lk.ijse.pos.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author : savindaJ
 * @date : 2024-03-29
 * @since : 0.1.0
 **/
public interface CustomerRepo extends JpaRepository<Customer,String> {

    /**
     * @return Integer
     */
    @Query(value = "SELECT COUNT(*) FROM Customer", nativeQuery = true)
    Integer getCustomerCount();
}
