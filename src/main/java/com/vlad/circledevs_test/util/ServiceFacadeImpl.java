package com.vlad.circledevs_test.util;

import com.vlad.circledevs_test.models.DTO.BankDTO;
import com.vlad.circledevs_test.models.DTO.CustomerAccountDTO;
import com.vlad.circledevs_test.models.DTO.CustomerDTO;
import com.vlad.circledevs_test.models.entity.Bank;
import com.vlad.circledevs_test.models.entity.Customer;
import com.vlad.circledevs_test.models.entity.CustomerAccount;
import com.vlad.circledevs_test.services.interfaces.BankService;
import com.vlad.circledevs_test.services.interfaces.CustomerAccountService;
import com.vlad.circledevs_test.services.interfaces.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceFacadeImpl implements ServiceFacade {
  private final CustomerService customerService;
  private final BankService bankService;
  private final CustomerAccountService customerAccountService;

  ModelMapper modelMapper = new ModelMapper();


  public ServiceFacadeImpl(BankService bankService,
                           CustomerService customerService,
                           CustomerAccountService customerAccountService) {
    this.bankService = bankService;
    this.customerService = customerService;
    this.customerAccountService = customerAccountService;
  }

  @Override
  public List<BankDTO> getAllBank() {
    return bankService.findAll()
            .stream()
            .map(bank -> modelMapper.map(bank, BankDTO.class))
            .toList();
  }

  @Override
  public List<CustomerDTO> getAllCustomer() {
    return customerService.findAll()
            .stream()
            .map(customer -> modelMapper.map(customer, CustomerDTO.class))
            .toList();
  }

  @Override
  public List<CustomerAccountDTO> getAllCustomerAccount() {
    return customerAccountService.findAll()
            .stream()
            .map(customerAccount -> modelMapper.map(customerAccount, CustomerAccountDTO.class))
            .toList();
  }

  @Override
  public BankDTO getBankById(Integer id) {
    bankService.findById(id).getCustomers().forEach(customer -> System.out.println(customer.getId()));
    return modelMapper.map(bankService.findById(id), BankDTO.class);
  }

  @Override
  public CustomerDTO getCustomerById(Integer id) {
    return modelMapper.map(customerService.findById(id), CustomerDTO.class);
  }

  @Override
  public CustomerAccountDTO getCustomerAccountById(Integer id) {
    return modelMapper.map(customerAccountService.findById(id), CustomerAccountDTO.class);
  }

  @Override
  public void deleteBank(Integer id) {
    bankService.deleteById(id);
  }

  @Override
  public void deleteCustomer(Integer id) {
    customerService.deleteById(id);
  }

  @Override
  public void deleteAccount(Integer id) {
    customerAccountService.deleteById(id);
  }

  @Override
  public BankDTO createBank(BankDTO bankDTO) {
    bankService.save(modelMapper.map(bankDTO, Bank.class));
    return bankDTO;
  }

  @Override
  public CustomerDTO createCustomer(CustomerDTO customerDTO) {
    customerService.save(modelMapper.map(customerDTO, Customer.class));
    return customerDTO;
  }

  @Override
  public CustomerAccountDTO createAccount(CustomerAccountDTO customerAccountDTO) {
    customerAccountService.save(modelMapper.map(customerAccountDTO, CustomerAccount.class));
    return customerAccountDTO;
  }
}
