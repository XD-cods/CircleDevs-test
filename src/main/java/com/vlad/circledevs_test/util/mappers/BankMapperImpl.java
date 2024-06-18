package com.vlad.circledevs_test.util.mappers;

import com.vlad.circledevs_test.models.DTO.BankDTO;
import com.vlad.circledevs_test.models.entity.Bank;
import com.vlad.circledevs_test.util.mappers.interfaces.BankMapper;
import com.vlad.circledevs_test.util.mappers.interfaces.CustomerMapper;
import org.springframework.stereotype.Component;

@Component
public class BankMapperImpl implements BankMapper {

  private final CustomerMapper customerMapper;

  public BankMapperImpl(CustomerMapper customerMapper) {
    this.customerMapper = customerMapper;
  }

  @Override
  public BankDTO toDTO(Bank bank) {
    return new BankDTO(bank.getId(),
            bank.getTitle(),
            bank.getAddress(),
            bank.getCustomers()
            .stream()
            .map(customerMapper::toDTO)
            .toList());
  }

  @Override
  public Bank fromDTO(BankDTO bankDTO) {
    return new Bank(bankDTO.getId(),
            bankDTO.getTitle(),
            bankDTO.getAddress(),
            bankDTO.getCustomers()
            .stream()
            .map(customerMapper::fromDTO)
            .toList());
  }
}
