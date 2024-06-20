package com.vlad.circledevs_test.services.interfaces;

import com.vlad.circledevs_test.models.entity.Bank;

public interface BankService extends Service<Bank> {
  public Boolean existBankByTitle(String title);
}
