package com.vlad.circledevs_test.services;


import com.vlad.circledevs_test.models.entity.Bank;
import com.vlad.circledevs_test.repositories.BankRepo;
import com.vlad.circledevs_test.services.interfaces.BankService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {
  private final BankRepo bankRepo;

  public BankServiceImpl(BankRepo bankRepo) {
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
  public void save(Bank bank) {
    bankRepo.save(bank);
  }

  @Override
  public void deleteById(Integer id) {
    bankRepo.deleteById(id);
  }

  @Override
  public void update(Bank bank) {
    bankRepo.save(bank);
  }

  @Override
  public List<Bank> findAllById(List<Integer> ids) {
    return bankRepo.findAllById(ids);
  }
}
