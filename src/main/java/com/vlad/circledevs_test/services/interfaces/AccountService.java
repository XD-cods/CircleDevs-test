package com.vlad.circledevs_test.services.interfaces;

import com.vlad.circledevs_test.models.entity.Account;

public interface AccountService extends Service<Account> {
  public Boolean existsByUserName(String userName);
}
