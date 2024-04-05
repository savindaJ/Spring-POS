package lk.ijse.pos.service.impl;

import lk.ijse.pos.config.WebRootConfig;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.service.CustomerService;
import lk.ijse.pos.service.exception.CustomerNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : savindaJ
 * @date : 2024-04-05
 * @since : 0.1.0
 **/
@SpringJUnitConfig(classes = WebRootConfig.class)
@WebAppConfiguration
@Transactional
class CustomerServiceImplTest {

    @Autowired
    CustomerService customerService;

    @Test
    void saveCustomer() {
        assertTrue(customerService.saveCustomer(new CustomerDTO(
                "",
                "savinda",
                "Matara",
                12122.67
        ))); // save the customer passed in the parameter
    }

    @Test
    void getAllCustomers() {
        assertNotNull(customerService.getAllCustomers()); // get all the customers
        assertEquals(new ArrayList<Customer>() {
        }, customerService.getAllCustomers()); // check the list is empty
    }

    @Test
    void deleteCustomer() {
        assertEquals(true, customerService.deleteCustomer("CUS-80ebdda8")); // delete the customer
        assertThrows(CustomerNotFoundException.class, () -> customerService.deleteCustomer("CUS-qwqwqwqw")); // check the exception
    }

    @Test
    void updateCustomer() {
        assertTrue(customerService.updateCustomer(new CustomerDTO(
                "CUS-80ebdda8",
                "savinda",
                "Matara",
                12122.67
        ))); // update the customer
        assertThrows(
                CustomerNotFoundException.class,
                () -> customerService.updateCustomer(new CustomerDTO(
                        "CUS-qwqwqwqw",
                        "savinda",
                        "Matara",
                        12122.67
                ))); // check the exception
    }

    @Test
    void getCustomerCount() {
        assertEquals(0, customerService.getCustomerCount()); // get the customer count
    }

    @Test
    void getCustomer() {
        assertThrows(
                CustomerNotFoundException.class,
                () -> customerService.getCustomer("CUS-qwqwqwqw")); // check the exception
    }
}