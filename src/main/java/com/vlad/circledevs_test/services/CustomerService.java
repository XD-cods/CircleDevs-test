package com.vlad.circledevs_test.services;


import com.vlad.circledevs_test.models.entity.Customer;
import com.vlad.circledevs_test.repositories.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
  private final CustomerRepo customerRepo;

  public CustomerService(CustomerRepo customerRepo) {
    this.customerRepo = customerRepo;
  }

  public List<Customer> findAll() {
    return customerRepo.findAll();
  }
}
