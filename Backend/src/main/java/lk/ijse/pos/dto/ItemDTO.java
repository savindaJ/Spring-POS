package lk.ijse.pos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : savindaJ
 * @date : 2024-03-29
 * @since : 0.1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO implements SuperDTO{
    private String itemCode;
    @NotBlank(message = "Item Description is mandatory")
    @Pattern(regexp = "^[A-Za-z ]{3,}$", message = "Item Description should contain at least 3 characters")
    private String description;
    @NotNull(message = "Item Unit Price is mandatory")
    private Double unitPrice;
    @NotNull(message = "Item Quantity on Hand is mandatory")
    private Integer qty;

}
