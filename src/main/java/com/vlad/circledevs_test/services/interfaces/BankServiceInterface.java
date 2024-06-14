package com.vlad.circledevs_test.services.interfaces;

import com.vlad.circledevs_test.models.entity.Bank;

import java.util.List;

public interface BankServiceInterface {
  public List<Bank> findAll();

  public Bank findById(int id);

  public void save(Bank customer);

  public void delete(Bank customer);
}
