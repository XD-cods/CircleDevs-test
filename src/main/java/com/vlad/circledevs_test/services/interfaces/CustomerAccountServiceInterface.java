package com.vlad.circledevs_test.services.interfaces;

import com.vlad.circledevs_test.models.entity.CustomerAccount;

import java.util.List;

public interface CustomerAccountServiceInterface {
  public List<CustomerAccount> findAll();

  public CustomerAccount findById(int id);

  public void save(CustomerAccount customer);

  public void delete(CustomerAccount customer);
}
