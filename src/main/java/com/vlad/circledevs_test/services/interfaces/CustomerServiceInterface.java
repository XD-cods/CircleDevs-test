package com.vlad.circledevs_test.services.interfaces;

import com.vlad.circledevs_test.models.entity.Customer;

import java.util.List;

public interface CustomerServiceInterface {
  public List<Customer> findAll();

  public Customer findById(int id);

  public void save(Customer customer);

  public void delete(Customer customer);
}
