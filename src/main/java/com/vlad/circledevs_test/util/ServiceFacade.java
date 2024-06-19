package com.vlad.circledevs_test.util;


import com.vlad.circledevs_test.models.DTO.BankDTO;
import com.vlad.circledevs_test.models.DTO.CustomerAccountDTO;
import com.vlad.circledevs_test.models.DTO.CustomerDTO;

import java.util.List;

public interface ServiceFacade {
  List<BankDTO> getAllBank();

  List<CustomerDTO> getAllCustomer();

  List<CustomerAccountDTO> getAllCustomerAccount();

  BankDTO getBankById(Integer id);

  CustomerDTO getCustomerById(Integer id);

  CustomerAccountDTO getCustomerAccountById(Integer id);

  void deleteBank(Integer id);

  void deleteCustomer(Integer id);

  void deleteAccount(Integer id);

  BankDTO createBank(BankDTO bankRequest);

  CustomerDTO createCustomer(CustomerDTO customer);

  CustomerAccountDTO createAccount(CustomerAccountDTO customer);

  BankDTO updateBank(BankDTO bankRequest);

  CustomerDTO updateCustomer(CustomerDTO customer);

  CustomerAccountDTO updateAccount(CustomerAccountDTO customer);
}
