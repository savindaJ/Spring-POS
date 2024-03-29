package lk.ijse.pos.service.impl;

import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.repo.CustomerRepo;
import lk.ijse.pos.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : savindaJ
 * @date : 2024-03-28
 * @since : 0.1.0
 **/
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepo customerRepo, ModelMapper modelMapper) {
        this.customerRepo = customerRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) {
        Customer save = customerRepo.save(modelMapper.map(customerDTO, Customer.class));
        return save != null;
    }

    @Override
    public List getAllCustomers() {
        List<Customer> all = customerRepo.findAll();
        return modelMapper.map(all, List.class);
    }

    @Override
    public boolean deleteCustomer(String id) {
        Customer referenceById = customerRepo.getReferenceById(id);
        System.out.println(referenceById);
        customerRepo.deleteById(id);
        return true;
    }
}
