package com.vlad.circledevs_test.util.mappers;

import com.vlad.circledevs_test.models.DTO.CustomerDTO;
import com.vlad.circledevs_test.models.entity.Customer;
import com.vlad.circledevs_test.util.mappers.interfaces.CustomerAccountMapper;
import com.vlad.circledevs_test.util.mappers.interfaces.CustomerMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl implements CustomerMapper {

  private final CustomerAccountMapper customerAccountMapper;

  public CustomerMapperImpl(CustomerAccountMapper customerAccountMapper) {
    this.customerAccountMapper = customerAccountMapper;
  }

  @Override
  public CustomerDTO toDTO(Customer customer) {
    return new CustomerDTO(customer.getId(),
            customer.getFirstName(),
            customer.getLastName(),
            customer.getCustomerAccounts()
            .stream()
            .map(customerAccountMapper::toDTO)
            .toList());
  }

  @Override
  public Customer fromDTO(CustomerDTO customerDTO) {
    return new Customer(customerDTO.getId(),
            customerDTO.getFirstName(),
            customerDTO.getLastName(),
            customerDTO.getCustomerAccounts()
            .stream()
            .map(customerAccountMapper::fromDTO)
            .toList());
  }
}
