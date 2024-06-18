package com.vlad.circledevs_test.util;

import com.vlad.circledevs_test.models.DTO.BankDTO;
import com.vlad.circledevs_test.models.DTO.CustomerAccountDTO;
import com.vlad.circledevs_test.models.DTO.CustomerDTO;
import com.vlad.circledevs_test.services.interfaces.BankService;
import com.vlad.circledevs_test.services.interfaces.CustomerAccountService;
import com.vlad.circledevs_test.services.interfaces.CustomerService;
import com.vlad.circledevs_test.util.mappers.interfaces.BankMapper;
import com.vlad.circledevs_test.util.mappers.interfaces.CustomerAccountMapper;
import com.vlad.circledevs_test.util.mappers.interfaces.CustomerMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceFacadeImpl implements ServiceFacade {
  private final CustomerService customerService;
  private final BankService bankService;
  private final CustomerAccountService customerAccountService;

  private final CustomerAccountMapper customerAccountMapper;
  private final BankMapper bankMapper;
  private final CustomerMapper customerMapper;


  public ServiceFacadeImpl(CustomerService customerService,
                           BankService bankService,
                           CustomerAccountService customerAccountService,
                           CustomerAccountMapper customerAccountMapperImpl,
                           BankMapper bankMapperImpl,
                           CustomerMapper customerMapperImpl) {
    this.customerService = customerService;
    this.bankService = bankService;
    this.customerAccountService = customerAccountService;
    this.customerAccountMapper = customerAccountMapperImpl;
    this.bankMapper = bankMapperImpl;
    this.customerMapper = customerMapperImpl;
  }

  @Override
  public List<BankDTO> getAllBank() {
    return bankService.findAll()
            .stream()
            .map(bankMapper::toDTO)
            .toList();
  }

  @Override
  public List<CustomerDTO> getAllCustomer() {
    return customerService.findAll()
            .stream()
            .map(customerMapper::toDTO)
            .toList();
  }

  @Override
  public List<CustomerAccountDTO> getAllCustomerAccount() {
    return customerAccountService.findAll()
            .stream()
            .map(customerAccountMapper::toDTO)
            .toList();
  }

  @Override
  public BankDTO getBankById(Integer id) {
    return bankMapper.toDTO(bankService.findById(id));
  }

  @Override
  public CustomerDTO getCustomerById(Integer id) {
    return customerMapper.toDTO(customerService.findById(id));
  }

  @Override
  public CustomerAccountDTO getCustomerAccountById(Integer id) {
    return customerAccountMapper.toDTO(customerAccountService.findById(id));
  }

  @Override
  public void deleteBank(Integer id) {

  }

  @Override
  public void deleteCustomer(Integer id) {

  }

  @Override
  public void deleteAccount(Integer id) {

  }

  @Override
  public BankDTO createBank(BankDTO bankDTO) {
    return null;
  }

  @Override
  public CustomerDTO createCustomer(CustomerDTO customer) {
    return null;
  }

  @Override
  public CustomerAccountDTO createAccount(CustomerAccountDTO customer) {
    return null;
  }
}
