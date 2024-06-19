package com.vlad.circledevs_test.services;


import com.vlad.circledevs_test.models.entity.CustomerAccount;
import com.vlad.circledevs_test.repositories.CustomerAccountRepo;
import com.vlad.circledevs_test.services.interfaces.CustomerAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerAccountServiceImpl implements CustomerAccountService {
  private final CustomerAccountRepo customerAccountRepo;

  public CustomerAccountServiceImpl(CustomerAccountRepo customerAccountRepo) {
    this.customerAccountRepo = customerAccountRepo;
  }

  @Override
  public List<CustomerAccount> findAll() {
    return customerAccountRepo.findAll();
  }

  @Override
  public CustomerAccount findById(int id) {
    return customerAccountRepo.findById(id).orElse(null);
  }

  @Override
  public CustomerAccount save(CustomerAccount customerAccount) {
    return customerAccountRepo.save(customerAccount);
  }

  @Override
  public void deleteById(Integer id) {
    customerAccountRepo.deleteById(id);
  }

  @Override
  public CustomerAccount update(CustomerAccount customerAccount) {
    return customerAccountRepo.save(customerAccount);
  }

}
