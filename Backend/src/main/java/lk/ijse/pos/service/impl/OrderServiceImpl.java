package lk.ijse.pos.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.dto.OrderDTO;
import lk.ijse.pos.dto.OrderDetailDTO;
import lk.ijse.pos.embedded.OrderDetailPK;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.entity.OrderDetail;
import lk.ijse.pos.entity.Orders;
import lk.ijse.pos.projection.OrderDetailProjection;
import lk.ijse.pos.projection.impl.OrderDetailProjectionImpl;
import lk.ijse.pos.repo.OrderRepo;
import lk.ijse.pos.service.CustomerService;
import lk.ijse.pos.service.ItemService;
import lk.ijse.pos.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : savindaJ
 * @date : 2024-03-29
 * @since : 0.1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {

    private final CustomerService customerService;

    private final ItemService itemService;

    private final ModelMapper modelMapper;

    private final OrderRepo orderRepo;

    /**
     * @param customerService CustomerService
     * @param itemService     ItemService
     * @param modelMapper     ModelMapper
     * @param orderRepo       OrderRepo
     */
    public OrderServiceImpl(CustomerService customerService, ItemService itemService, ModelMapper modelMapper, OrderRepo orderRepo) {
        this.customerService = customerService;
        this.itemService = itemService;
        this.modelMapper = modelMapper;
        this.orderRepo = orderRepo;
    }

    /**
     * @param orderDTO OrderDTO
     * @return boolean
     */
    @Override
    @Transactional
    public boolean saveOrder(OrderDTO orderDTO) {
        List<OrderDetail> detailList = new ArrayList<>();
        CustomerDTO customerDTO = customerService.getCustomer(orderDTO.getCustomerId());
        orderDTO.getItemList().forEach(itemDTO -> {
            Item item = itemService.getItem(itemDTO.getItemCode());
            item.setQty(item.getQty() - itemDTO.getQty());
            itemService.updateItem(modelMapper.map(item, ItemDTO.class));
            detailList.add(new OrderDetail(new OrderDetailPK(orderDTO.getOrderId(), itemDTO.getItemCode()), itemDTO.getQty()));
        });
        Orders save = orderRepo.save(new Orders(orderDTO.getOrderId(), modelMapper.map(customerDTO, Customer.class), detailList));
        return save != null;
    }

    /**
     * @return List<OrderDetailDTO>
     */
    @Override
    public List<OrderDetailDTO> getAllOrders() {
        List<OrderDetailDTO> orderDetailDTOS = new ArrayList<>();
        for (OrderDetailProjection allOrderDetail : orderRepo.getAllOrderDetails()) {
            Date date = new Date(allOrderDetail.getOrderDate().getTime());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = dateFormat.format(date);
            System.out.println(formattedDate);
            orderDetailDTOS.add(new OrderDetailDTO(allOrderDetail.getOrderId(), allOrderDetail.getCustomerId(), allOrderDetail.getItemCode(), allOrderDetail.getOrderQuantity(), formattedDate));
        }
        return orderDetailDTOS;
    }

    /**
     * @return Integer
     */
    @Override
    public Integer getOrderCount() {
        return orderRepo.getOrderCount();
    }

    /**
     * @return Integer
     */
    @Override
    public Integer getOrderDetailCount() {
        return orderRepo.orderDetailCount();
    }

    /**
     * @return Double
     */
    @Override
    public Double geyIncome() {
        return orderRepo.getIncome();
    }
}
