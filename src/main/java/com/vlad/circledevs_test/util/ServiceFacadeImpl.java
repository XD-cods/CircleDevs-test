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
  public BankDTO createBank(BankDTO bank) {
    Bank newBank = bankService.save(modelMapper.map(bank, Bank.class));
    return modelMapper.map(newBank, BankDTO.class);
  }

  @Override
  public CustomerDTO createCustomer(CustomerDTO customer) {
    Customer newCustomer = customerService.save(modelMapper.map(customer, Customer.class));
    return modelMapper.map(newCustomer, CustomerDTO.class);
  }

  @Override
  public CustomerAccountDTO createAccount(CustomerAccountDTO customerAccount) {
    CustomerAccount newCustomerAccount = customerAccountService.save(modelMapper.map(customerAccount,
            CustomerAccount.class));
    return modelMapper.map(newCustomerAccount,CustomerAccountDTO.class);
  }

  @Override
  public CustomerAccountDTO updateAccount(CustomerAccountDTO customer) {
    CustomerAccount newCustomerAccount = customerAccountService.save(modelMapper.map(customer,
            CustomerAccount.class));
    return modelMapper.map(newCustomerAccount,CustomerAccountDTO.class);
  }

  @Override
  public BankDTO updateBank(BankDTO bank) {
    Bank newBank = bankService.save(modelMapper.map(bank, Bank.class));
    return modelMapper.map(newBank, BankDTO.class);
  }

  @Override
  public CustomerDTO updateCustomer(CustomerDTO customer) {
    Customer newCustomer = customerService.save(modelMapper.map(customer, Customer.class));
    return modelMapper.map(newCustomer, CustomerDTO.class);
  }
}
