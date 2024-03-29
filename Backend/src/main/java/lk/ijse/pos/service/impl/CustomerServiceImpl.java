package lk.ijse.pos.service.impl;

import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.repo.CustomerRepo;
import lk.ijse.pos.service.CustomerService;
import lk.ijse.pos.service.exception.CustomerNotFoundException;
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

    /**
     * @param customerRepo CustomerRepo
     * @param modelMapper ModelMapper
     */
    public CustomerServiceImpl(CustomerRepo customerRepo, ModelMapper modelMapper) {
        this.customerRepo = customerRepo;
        this.modelMapper = modelMapper;
    }

    /**
     * @param customerDTO CustomerDTO
     * @return boolean
     */
    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) {
        Customer save = customerRepo.save(modelMapper.map(customerDTO, Customer.class));
        return save != null;
    }

    /**
     * @return List
     */
    @Override
    public List getAllCustomers() {
        List<Customer> all = customerRepo.findAll();
        return modelMapper.map(all, List.class);
    }

    /**
     * @param id String
     * @return boolean
     */
    @Override
    public boolean deleteCustomer(String id) {
        if (!customerRepo.existsById(id)) {
            throw new CustomerNotFoundException("No customer exist for given id...!");
        }
        customerRepo.deleteById(id);
        return true;
    }

    /**
     * @param customerDTO CustomerDTO
     * @return boolean
     */
    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) {
        if (!customerRepo.existsById(customerDTO.getCusId())) {
            throw new CustomerNotFoundException("No customer exist for given id...!");
        }
        Customer save = customerRepo.save(modelMapper.map(customerDTO, Customer.class));
        return save != null;
    }

    /**
     * @return int
     */
    @Override
    public int getCustomerCount() {
        return customerRepo.getCustomerCount();
    }

    /**
     * @param customerId String
     * @return CustomerDTO
     */
    @Override
    public CustomerDTO getCustomer(String customerId) {
        Customer referenceById = customerRepo.findById(customerId).get();
        System.out.println(referenceById);
        return modelMapper.map(referenceById, CustomerDTO.class);
    }
}
