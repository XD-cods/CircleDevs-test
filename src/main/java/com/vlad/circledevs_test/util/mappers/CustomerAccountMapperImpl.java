package com.vlad.circledevs_test.util.mappers;

import com.vlad.circledevs_test.models.DTO.CustomerAccountDTO;
import com.vlad.circledevs_test.models.entity.CustomerAccount;
import com.vlad.circledevs_test.util.mappers.interfaces.CustomerAccountMapper;
import com.vlad.circledevs_test.util.mappers.interfaces.CustomerMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerAccountMapperImpl implements CustomerAccountMapper {

  private final CustomerMapper customerMapper;

  public CustomerAccountMapperImpl(CustomerMapper customerMapper) {
    this.customerMapper = customerMapper;
  }

  @Override
  public CustomerAccountDTO toDTO(CustomerAccount customerAccount) {
    return new CustomerAccountDTO(customerAccount.getId(),
            customerAccount.getUsername(),
            customerAccount.getPassword(),
            customerAccount.getCashAmount());
  }


  @Override
  public CustomerAccount fromDTO(CustomerAccountDTO customerAccountDTO) {
    return new CustomerAccount(customerAccountDTO.getId(),
            customerAccountDTO.getUsername(),
            customerAccountDTO.getPassword(),
            customerAccountDTO.getCashAmount());
  }
}
