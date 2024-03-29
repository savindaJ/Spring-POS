package lk.ijse.pos.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Embeddable
public class OrderDetailPK implements Serializable {

    @Column(name = "order_id", length = 50)
    private String orderId;
    @Column(name = "item_code", length = 50)
    private String itemId;

    /**
     * No argument constructor
     */
    public OrderDetailPK() {

    }
}
