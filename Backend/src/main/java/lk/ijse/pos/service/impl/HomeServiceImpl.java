package lk.ijse.pos.service.impl;

import lk.ijse.pos.service.CustomerService;
import lk.ijse.pos.service.HomeService;
import lk.ijse.pos.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public HomeServiceImpl(CustomerService customerService, ItemService itemService) {
        this.customerService = customerService;
        this.itemService = itemService;
    }


    @Override
    public Map<String,Integer> getStatus() {
        HashMap<String, Integer> list = new HashMap<>();
        list.put("customerCount",customerService.getCustomerCount());
        list.put("itemCount",itemService.getItemCount());
        return list;
    }
}
