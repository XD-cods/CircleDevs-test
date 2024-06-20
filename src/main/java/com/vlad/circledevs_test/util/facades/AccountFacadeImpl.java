package com.vlad.circledevs_test.util.facades;

import com.vlad.circledevs_test.models.DTO.AccountDTO;
import com.vlad.circledevs_test.models.entity.Account;
import com.vlad.circledevs_test.services.interfaces.AccountService;
import com.vlad.circledevs_test.util.facades.interfaces.AccountFacade;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountFacadeImpl implements AccountFacade {
  ModelMapper modelMapper = new ModelMapper();
  AccountService accountService;

  public AccountFacadeImpl(AccountService accountService) {
    this.accountService = accountService;
  }

  @Override
  public AccountDTO create(AccountDTO accountDTO) {
    Account newAccount = accountService.save(modelMapper.map(accountDTO,
            Account.class));
    return modelMapper.map(newAccount, AccountDTO.class);
  }

  @Override
  public Boolean existById(int id) {
    return accountService.existsById(id);
  }

  @Override
  public List<AccountDTO> getAll() {
    return accountService.findAll()
            .stream()
            .map(customerAccount -> modelMapper.map(customerAccount, AccountDTO.class))
            .toList();
  }

  @Override
  public AccountDTO getById(Integer id) {
    return modelMapper.map(accountService.findById(id), AccountDTO.class);

  }

  @Override
  public void delete(AccountDTO account) {
    accountService.delete(modelMapper.map(account, Account.class));

  }

  @Override
  public Boolean existByUsername(String username) {
    return accountService.existsByUserName(username);
  }
}
