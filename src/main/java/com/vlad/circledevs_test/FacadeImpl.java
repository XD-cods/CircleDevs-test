package com.vlad.circledevs_test;

import com.vlad.circledevs_test.models.DTO.BankDTO;
import com.vlad.circledevs_test.models.DTO.CustomerAccountDTO;
import com.vlad.circledevs_test.models.DTO.CustomerDTO;
import com.vlad.circledevs_test.services.interfaces.BankServiceInterface;
import com.vlad.circledevs_test.services.interfaces.CustomerAccountServiceInterface;
import com.vlad.circledevs_test.services.interfaces.CustomerServiceInterface;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FacadeImpl implements Facade {
  private final CustomerServiceInterface customerService;
  private final BankServiceInterface bankService;
  private final CustomerAccountServiceInterface customerAccountService;


  public FacadeImpl(CustomerServiceInterface customerService,
                    BankServiceInterface bankService,
                    CustomerAccountServiceInterface customerAccountService) {
    this.customerService = customerService;
    this.bankService = bankService;
    this.customerAccountService = customerAccountService;
  }

  @Override
  public void createBank() {

  }

  @Override
  public List<BankDTO> getAllBank() {
    return List.of();
  }

  @Override
  public List<CustomerDTO> getAllCustomer() {
    return List.of();
  }

  @Override
  public List<CustomerDTO> getAllCustomerAccount() {
    return List.of();
  }

  @Override
  public BankDTO getBankById(Integer id) {
    return null;
  }

  @Override
  public CustomerDTO getCustomerById(Integer id) {
    return null;
  }

  @Override
  public CustomerAccountDTO getCustomerAccountById(Integer id) {
    return null;
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
  public BankDTO createBank(String address, String title) {
    return null;
  }

  @Override
  public CustomerDTO createCustomer() {
    return null;
  }

  @Override
  public CustomerAccountDTO createAccount() {
    return null;
  }
}
