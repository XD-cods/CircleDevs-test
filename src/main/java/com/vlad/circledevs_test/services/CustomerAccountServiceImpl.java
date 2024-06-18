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
  public void save(CustomerAccount customerAccount) {
    customerAccountRepo.save(customerAccount);
  }

  @Override
  public void deleteById(Integer id) {
    customerAccountRepo.deleteById(id);
  }

  @Override
  public void update(CustomerAccount customerAccount) {
    customerAccountRepo.save(customerAccount);
  }

  @Override
  public List<CustomerAccount> findAllById(List<Integer> ids) {
    return customerAccountRepo.findAllById(ids);
  }
}
