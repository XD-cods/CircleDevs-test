package com.vlad.circledevs_test.controllers;

import com.vlad.circledevs_test.models.DTO.AccountDTO;
import com.vlad.circledevs_test.util.facades.interfaces.AccountFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<List<AccountDTO>> getAllCustomerAccount() {
    return ResponseEntity.ok(accountFacade.getAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<AccountDTO> getCustomerAccountById(@PathVariable int id) {
    if (!accountFacade.existById(id)) {
      return ResponseEntity.notFound().build();
    }
    AccountDTO accountDTO = accountFacade.getById(id);
    return ResponseEntity.ok(accountDTO);
  }

  @PostMapping
  public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO customerAccount) {
    if (accountFacade.existByUsername(customerAccount.getUsername())) {
      return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    return ResponseEntity.ok(accountFacade.create(customerAccount));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> delete(@PathVariable int id) {
    if (!accountFacade.existById(id)) {
      return ResponseEntity.notFound().build();
    }
    AccountDTO accountDTO = accountFacade.getById(id);
    accountFacade.delete(accountDTO);
    return ResponseEntity.noContent().build();
  }
}
