package com.vlad.circledevs_test.services;


import com.vlad.circledevs_test.models.entity.Account;
import com.vlad.circledevs_test.repositories.AccountRepo;
import com.vlad.circledevs_test.services.interfaces.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
  private final AccountRepo accountRepo;

  public AccountServiceImpl(AccountRepo accountRepo) {
    this.accountRepo = accountRepo;
  }

  @Override
  public List<Account> findAll() {
    return accountRepo.findAll();
  }

  @Override
  public Account findById(int id) {
    return accountRepo.findById(id).orElse(null);
  }

  @Override
  public Account save(Account account) {
    return accountRepo.save(account);
  }

  @Override
  public void deleteById(Integer id) {
    accountRepo.deleteById(id);
  }

}
