package lk.ijse.pos.api;

import jakarta.validation.Valid;
import lk.ijse.pos.dto.OrderDTO;
import lk.ijse.pos.dto.OrderDetailDTO;
import lk.ijse.pos.projection.OrderDetailProjection;
import lk.ijse.pos.service.OrderService;
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
@RequestMapping("/order")
public class OrderController {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/nextId")
    public ResponseEntity<?> getNextOrderID(){
        return ResponseEntity.ok(Generator.generateOrderID());
    }
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,String>> saveCustomer(@RequestBody @Valid OrderDTO orderDTO){

        Map<String,String> response = new LinkedHashMap<>();
        if (!orderService.saveOrder(orderDTO)) throw new RuntimeException("Failed to save the order");
        response.put("message","Order saved successfully");
        logger.info(response.toString());
        return ResponseEntity.created(null).body(response);
    }


    @GetMapping("/orderdetails")
    public List<OrderDetailDTO> getOrderDetails(){
        return orderService.getAllOrders();
    }
}
