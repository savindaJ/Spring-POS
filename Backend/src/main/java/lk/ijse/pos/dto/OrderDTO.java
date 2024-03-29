package lk.ijse.pos.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * @author : savindaJ
 * @date : 1/13/2024
 * @since : 0.1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements SuperDTO{
    @NotNull(message = "Order ID can't be null")
    private String orderId;
    @NotNull(message = "Customer ID can't be null")
    private String customerId;
    @NotNull(message = "Item List can't be null")
    private ArrayList<ItemDTO> itemList;
}
