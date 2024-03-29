package lk.ijse.pos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : savindaJ
 * @date : 2024-03-29
 * @since : 0.1.0
 **/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @Column(name = "item_code", length = 50)
    private String itemCode;
    @Column(name = "item_description", length = 50)
    private String description;
    @Column(name = "item_price")
    private Double unitPrice;
    @Column(name = "item_quantity")
    private Integer qty;
}
