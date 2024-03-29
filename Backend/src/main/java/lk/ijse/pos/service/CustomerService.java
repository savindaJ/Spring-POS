package lk.ijse.pos.service;

import lk.ijse.pos.dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : savindaJ
 * @date : 2024-03-28
 * @since : 0.1.0
 **/
public interface CustomerService {
    /**
     * @param customerDTO CustomerDTO
     * @return boolean
     */
    boolean saveCustomer(CustomerDTO customerDTO);

    /**
     * @return List<CustomerDTO>
     */
    List<CustomerDTO> getAllCustomers();

    /**
     * @param id String
     * @return boolean
     */
    boolean deleteCustomer(String id);

    /**
     * @param customerDTO CustomerDTO
     * @return boolean
     */
    boolean updateCustomer(CustomerDTO customerDTO);

    /**
     * @return int
     */
    int getCustomerCount();

    /**
     * @param customerId String
     * @return CustomerDTO
     */
    CustomerDTO getCustomer(String customerId);
}
