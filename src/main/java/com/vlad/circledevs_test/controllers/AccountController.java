package com.vlad.circledevs_test.controllers;

import com.vlad.circledevs_test.models.DTO.AccountDTO;
import com.vlad.circledevs_test.util.facades.interfaces.AccountFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {
  private final AccountFacade accountFacade;

  public AccountController(AccountFacade accountFacade) {
    this.accountFacade = accountFacade;
  }

  @GetMapping
  public List<AccountDTO> getAllCustomerAccount() {
    return accountFacade.getAll();
  }

  @GetMapping("{id}")
  public AccountDTO getCustomerAccountById(@PathVariable int id) {
    return accountFacade.getById(id);
  }

  @PostMapping
  public AccountDTO addAccount(@RequestBody AccountDTO customerAccount) {
    return accountFacade.create(customerAccount);
  }

  @DeleteMapping("{id}")
  public HttpStatus delete(@PathVariable int id) {
    accountFacade.delete(id);
    return HttpStatus.OK;
  }
}
