package com.vlad.circledevs_test.services;


import com.vlad.circledevs_test.models.entity.Bank;
import com.vlad.circledevs_test.repositories.BankRepo;
import com.vlad.circledevs_test.services.interfaces.BankServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService implements BankServiceInterface {
  private final BankRepo bankRepo;

  public BankService(BankRepo bankRepo) {
    this.bankRepo = bankRepo;
  }

  @Override
  public List<Bank> findAll() {
    return bankRepo.findAll();
  }

  @Override
  public Bank findById(int id) {
    return bankRepo.findById(id).orElse(null);
  }

  @Override
  public void save(Bank customer) {
    bankRepo.save(customer);
  }

  @Override
  public void delete(Bank customer) {
    bankRepo.delete(customer);
  }
}
