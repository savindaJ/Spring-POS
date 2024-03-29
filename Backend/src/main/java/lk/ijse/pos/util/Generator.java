package lk.ijse.pos.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author : savindaJ
 * @date : 2024-03-29
 * @since : 0.1.0
 **/
public class Generator {
    /**
     * @return a randomly generated customer ID
     */
    public static String generateCustomerID() {
        String prefix = "CUS-";
        return prefix + UUID.randomUUID().toString().split("-")[0];
    }

    /**
     * @return a randomly generated item ID
     */
    public static String generateItemID() {
        String prefix = "ITM-";
        return prefix + UUID.randomUUID().toString().split("-")[0];
    }

    /**
     * @return a randomly generated order ID
     */
    public static String generateOrderID() {
        String prefix = "ORD-";
        return prefix + UUID.randomUUID().toString().split("-")[0];
    }
}
