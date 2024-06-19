package com.vlad.circledevs_test.services;


import com.vlad.circledevs_test.models.entity.Customer;
import com.vlad.circledevs_test.repositories.CustomerRepo;
import com.vlad.circledevs_test.services.interfaces.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
  private final CustomerRepo customerRepo;

  public CustomerServiceImpl(CustomerRepo customerRepo) {
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
  public Customer save(Customer customer) {
    return customerRepo.save(customer);
  }

  @Override
  public void deleteById(Integer id) {
    customerRepo.deleteById(id);
  }

  @Override
  public Customer update(Customer customer) {
    return customerRepo.save(customer);
  }
}
