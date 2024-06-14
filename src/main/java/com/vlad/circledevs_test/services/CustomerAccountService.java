package com.vlad.circledevs_test.services;


import com.vlad.circledevs_test.repositories.CustomerAccountRepo;
import org.springframework.stereotype.Service;

@Service
public class CustomerAccountService {
  private final CustomerAccountRepo customerAccountRepo;

  public CustomerAccountService(CustomerAccountRepo customerAccountRepo) {
    this.customerAccountRepo = customerAccountRepo;
  }
}
