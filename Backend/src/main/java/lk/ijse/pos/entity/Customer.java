package lk.ijse.pos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : savindaJ
 * @date : 2024-03-28
 * @since : 0.1.0
 **/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @Column(name = "customer_id", length = 50)
    private String cusId;
    @Column(name = "customer_name", length = 50)
    private String name;
    @Column(name = "customer_address", length = 50)
    private String address;
    @Column(name = "customer_salary")
    private Double salary;
}
