package lk.ijse.pos.service.impl;

import lk.ijse.pos.service.CustomerService;
import lk.ijse.pos.service.HomeService;
import lk.ijse.pos.service.ItemService;
import lk.ijse.pos.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : savindaJ
 * @date : 2024-03-29
 * @since : 0.1.0
 **/
@Service
public class HomeServiceImpl implements HomeService {

    private final CustomerService customerService;

    private final ItemService itemService;

    private final OrderService orderService;

    /**
     * @param customerService CustomerService
     * @param itemService     ItemService
     * @param orderService    OrderService
     */
    public HomeServiceImpl(CustomerService customerService, ItemService itemService, OrderService orderService) {
        this.customerService = customerService;
        this.itemService = itemService;
        this.orderService = orderService;
    }

    /**
     * @return Map<String, Number>
     */
    @Override
    public Map<String, Number> getStatus() {
        HashMap<String, Number> list = new HashMap<>();
        list.put("customerCount", customerService.getCustomerCount());
        list.put("itemCount", itemService.getItemCount());
        list.put("orderCount", orderService.getOrderCount());
        list.put("orderDetailCount", orderService.getOrderDetailCount());
        list.put("income", orderService.getIncome());
        return list;
    }
}
