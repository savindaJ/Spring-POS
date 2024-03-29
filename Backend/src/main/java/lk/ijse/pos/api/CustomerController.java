package lk.ijse.pos.api;

import jakarta.validation.Valid;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.service.CustomerService;
import lk.ijse.pos.service.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author : savindaJ
 * @date : 2024-03-28
 * @since : 0.1.0
 **/
@RestController
@RequestMapping("/customer")
public class CustomerController {

    Logger logger = Logger.getLogger(this.getClass().getName());

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Map<String,String>> saveCustomer(@RequestBody @Valid CustomerDTO customerDTO){
//        throw new CustomerNotFoundException("Customer not found");
        Map<String,String> response = new LinkedHashMap<>();
        response.put("message","Customer saved successfully");
        logger.info(response.toString());
        System.out.println("customerDTO = " + customerDTO);
       /* boolean isSave = customerService.saveCustomer(customerDTO);
        if (!isSave) throw new RuntimeException("Failed to save the customer");*/
        return ResponseEntity.ok(response);
    }
}
