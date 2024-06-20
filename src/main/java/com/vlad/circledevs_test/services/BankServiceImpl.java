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
  public Bank save(Bank bank) {
    return bankRepo.save(bank);
  }

  @Override
  public void delete(Bank bank) {
    bankRepo.delete(bank);
  }

  @Override
  public Boolean existsById(int id) {
    return bankRepo.existsById(id);
  }

  @Override
  public Boolean existBankByTitle(String title) {
    return bankRepo.existsBankByTitle(title);
  }
}
