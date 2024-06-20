package com.vlad.circledevs_test.controllers;

import com.vlad.circledevs_test.models.DTO.BankDTO;
import com.vlad.circledevs_test.util.facades.interfaces.BankFacade;
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
@RequestMapping("bank")
public class BankController {
  private final BankFacade bankFacade;

  public BankController(BankFacade bankFacade) {
    this.bankFacade = bankFacade;
  }

  @GetMapping
  public ResponseEntity<List<BankDTO>> getAllBank() {
    return ResponseEntity.ok(bankFacade.getAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<BankDTO> getBankById(@PathVariable int id) {
    if (!bankFacade.existById(id)) {
      return ResponseEntity.notFound().build();
    }
    BankDTO bankDTO = bankFacade.getById(id);
    return ResponseEntity.ok(bankDTO);
  }

  @PostMapping
  public ResponseEntity<BankDTO> addBank(@RequestBody BankDTO bank) {
    if (bankFacade.existBankByTitle(bank.getTitle())) {
      return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    return ResponseEntity.ok(bankFacade.create(bank));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteBank(@PathVariable int id) {
    if (!bankFacade.existById(id)) {
      return ResponseEntity.notFound().build();
    }
    BankDTO bankDTO = bankFacade.getById(id);
    bankFacade.delete(bankDTO);
    return ResponseEntity.noContent().build();
  }
}
