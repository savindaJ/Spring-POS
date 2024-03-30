package lk.ijse.pos.repo;

import lk.ijse.pos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : savindaJ
 * @date : 2024-03-30
 * @since : 0.1.0
 **/
public interface UserRepo extends JpaRepository<User, String>{
    User findByGmail(String gmail);
}
