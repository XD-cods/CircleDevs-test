package com.vlad.circledevs_test.util.facades;

import com.vlad.circledevs_test.models.DTO.CustomerDTO;
import com.vlad.circledevs_test.models.entity.Customer;
import com.vlad.circledevs_test.services.interfaces.CustomerService;
import com.vlad.circledevs_test.util.facades.interfaces.CustomerFacade;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerFacadeImpl implements CustomerFacade {
  ModelMapper modelMapper = new ModelMapper();
  CustomerService customerService;

  public CustomerFacadeImpl(CustomerService customerService) {
    this.customerService = customerService;
  }

  @Override
  public List<CustomerDTO> getAll() {
    return customerService.findAll()
            .stream()
            .map(customer -> modelMapper.map(customer, CustomerDTO.class))
            .toList();
  }

  @Override
  public CustomerDTO getById(Integer id) {
    return modelMapper.map(customerService.findById(id), CustomerDTO.class);

  }

  @Override
  public void delete(Integer id) {
    customerService.deleteById(id);

  }

  @Override
  public CustomerDTO create(CustomerDTO customerDTO) {
    Customer newCustomer = customerService.save(modelMapper.map(customerDTO, Customer.class));
    return modelMapper.map(newCustomer, CustomerDTO.class);
  }

}
