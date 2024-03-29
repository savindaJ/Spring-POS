package lk.ijse.pos.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author : savindaJ
 * @date : 2024-03-29
 * @since : 0.1.0
 **/
public class Generator {
    public static String generateCustomerID() {
        String prefix = "CUS-";
        return prefix + UUID.randomUUID().toString().split("-")[0];
    }

    public static String generateItemID() {
        String prefix = "ITM-";
        return prefix + UUID.randomUUID().toString().split("-")[0];
    }

    public static String generateOrderID() {
        String prefix = "ORD-";
        return prefix + UUID.randomUUID().toString().split("-")[0];
    }
}
