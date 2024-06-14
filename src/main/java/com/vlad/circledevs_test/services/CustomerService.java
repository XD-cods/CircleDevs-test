package com.vlad.circledevs_test.services;


import com.vlad.circledevs_test.models.entity.Customer;
import com.vlad.circledevs_test.repositories.CustomerRepo;
import com.vlad.circledevs_test.services.interfaces.CustomerServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements CustomerServiceInterface {
  private final CustomerRepo customerRepo;

  public CustomerService(CustomerRepo customerRepo) {
    this.customerRepo = customerRepo;
  }

  @Override
  public List<Customer> findAll() {
    return customerRepo.findAll();
  }

  @Override
  public Customer findById(int id) {
    return customerRepo.findById(id).orElse(null);
  }

  @Override
  public void save(Customer customer) {
    customerRepo.save(customer);
  }

  @Override
  public void delete(Customer customer) {
    customerRepo.delete(customer);
  }
}
