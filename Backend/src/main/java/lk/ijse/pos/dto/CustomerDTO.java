package lk.ijse.pos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : savindaJ
 * @date : 2024-03-28
 * @since : 0.1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO implements SuperDTO{
    @Null(message = "Customer ID is mandatory")
    private String cusId;
    @NotBlank(message = "Name is mandatory")
    @Pattern(regexp = "^[A-Za-z ]*$",message = "Name is invalid")
    private String name;
    @NotBlank(message = "Address is mandatory")
    @Pattern(regexp = "^[A-Za-z0-9, ]*$",message = "Address is invalid")
    private String address;
    @NotNull(message = "Salary is mandatory")
    private Double salary;
}
