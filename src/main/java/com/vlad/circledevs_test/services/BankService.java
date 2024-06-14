package com.vlad.circledevs_test.services;


import com.vlad.circledevs_test.repositories.BankRepo;
import org.springframework.stereotype.Service;

@Service
public class BankService {
  private final BankRepo bankRepo;

  public BankService(BankRepo bankRepo) {
    this.bankRepo = bankRepo;
  }

}
