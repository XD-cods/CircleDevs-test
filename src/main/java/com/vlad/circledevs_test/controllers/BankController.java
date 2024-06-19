package com.vlad.circledevs_test.controllers;

import com.vlad.circledevs_test.models.DTO.BankDTO;
import com.vlad.circledevs_test.util.facades.interfaces.BankFacade;
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
@RequestMapping("bank")
public class BankController {
  private final BankFacade bankFacade;

  public BankController(BankFacade bankFacade) {
    this.bankFacade = bankFacade;
  }

  @GetMapping
  public List<BankDTO> getAllBank() {
    return bankFacade.getAll();
  }

  @GetMapping("{id}")
  public BankDTO getBankById(@PathVariable int id) {
    return bankFacade.getById(id);
  }

  @PostMapping
  public BankDTO addBank(@RequestBody BankDTO bank) {
    return bankFacade.create(bank);
  }

  @DeleteMapping("{id}")
  public HttpStatus deleteBank(@PathVariable int id) {
    bankFacade.delete(id);
    return HttpStatus.OK;
  }
}
