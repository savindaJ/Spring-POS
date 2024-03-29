package lk.ijse.pos.service;

import lk.ijse.pos.dto.CustomerDTO;
import org.springframework.stereotype.Service;

/**
 * @author : savindaJ
 * @date : 2024-03-28
 * @since : 0.1.0
 **/
public interface CustomerService {
    boolean saveCustomer(CustomerDTO customerDTO);
}
