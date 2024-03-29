package lk.ijse.pos.repo;

import lk.ijse.pos.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author : savindaJ
 * @date : 2024-03-29
 * @since : 0.1.0
 **/
public interface ItemRepo extends JpaRepository<Item,String> {

    @Query(value = "SELECT COUNT(*) FROM Item", nativeQuery = true)
    Integer getItemCount();
}
