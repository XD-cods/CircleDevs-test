package com.vlad.circledevs_test;


import com.vlad.circledevs_test.models.DTO.BankDTO;
import com.vlad.circledevs_test.models.DTO.CustomerAccountDTO;
import com.vlad.circledevs_test.models.DTO.CustomerDTO;

import java.util.List;

public interface Facade {
  public void createBank();


  List<BankDTO> getAllBank();

  List<CustomerDTO> getAllCustomer();

  List<CustomerDTO> getAllCustomerAccount();

  BankDTO getBankById(Integer id);

  CustomerDTO getCustomerById(Integer id);

  CustomerAccountDTO getCustomerAccountById(Integer id);


  void deleteBank(Integer id);

  void deleteCustomer(Integer id);

  void deleteAccount(Integer id);

  BankDTO createBank(String address, String title);

  CustomerDTO createCustomer();

  CustomerAccountDTO createAccount();
}
