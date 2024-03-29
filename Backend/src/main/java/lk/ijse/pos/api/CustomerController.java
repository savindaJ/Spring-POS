package lk.ijse.pos.api;

import jakarta.validation.Valid;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.service.CustomerService;
import lk.ijse.pos.util.Generator;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author : savindaJ
 * @date : 2024-03-28
 * @since : 0.1.0
 **/
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/customer")
public class CustomerController {
    /**
     * Logger
     */
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final CustomerService customerService;

    /**
     * @param customerService CustomerService
     */
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * @return List<CustomerDTO>
     */
    @GetMapping
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    /**
     * @param customerDTO CustomerDTO
     * @return ResponseEntity<Map < String, String>>
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,String>> saveCustomer(@RequestBody @Valid CustomerDTO customerDTO){
        customerDTO.setCusId(Generator.generateCustomerID());
        Map<String,String> response = new LinkedHashMap<>();
        if (!customerService.saveCustomer(customerDTO)) throw new RuntimeException("Failed to save the customer");
        response.put("message","Customer saved successfully");
        logger.info(response.toString());
        return ResponseEntity.created(null).body(response);
    }

    /**
     * @param id String
     * @return ResponseEntity<Map < String, String>>
     */
    @DeleteMapping
    public ResponseEntity<Map<String,String>> deleteCustomer(@RequestParam("id") String id){
        Map<String,String> response = new LinkedHashMap<>();
        if (!customerService.deleteCustomer(id)) throw new RuntimeException("Failed to delete the customer");
        response.put("message","Customer deleted successfully");
        logger.info(response.toString());
        return ResponseEntity.ok(response);
    }

    /**
     * @param customerDTO CustomerDTO
     * @return ResponseEntity<Map < String, String>>
     */
    @PutMapping
    public ResponseEntity<Map<String,String>> updateCustomer(@RequestBody @Valid CustomerDTO customerDTO){
        Map<String,String> response = new LinkedHashMap<>();
        if (!customerService.updateCustomer(customerDTO)) throw new RuntimeException("Failed to update the customer");
        response.put("message","Customer updated successfully");
        logger.info(response.toString());
        return ResponseEntity.ok(response);
    }
}
