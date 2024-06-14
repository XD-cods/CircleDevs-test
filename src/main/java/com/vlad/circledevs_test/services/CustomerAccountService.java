package com.vlad.circledevs_test.services;


import com.vlad.circledevs_test.models.entity.CustomerAccount;
import com.vlad.circledevs_test.repositories.CustomerAccountRepo;
import com.vlad.circledevs_test.services.interfaces.CustomerAccountServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerAccountService implements CustomerAccountServiceInterface {
  private final CustomerAccountRepo customerAccountRepo;

  public CustomerAccountService(CustomerAccountRepo customerAccountRepo) {
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
  public void save(CustomerAccount customer) {
    customerAccountRepo.save(customer);
  }

  @Override
  public void delete(CustomerAccount customer) {
    customerAccountRepo.delete(customer);
  }
}
