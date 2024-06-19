package com.vlad.circledevs_test.controllers;

import com.vlad.circledevs_test.models.DTO.BankDTO;
import com.vlad.circledevs_test.util.ServiceFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("bank")
public class BankController {
  private final ServiceFacade serviceFacade;

  public BankController(ServiceFacade serviceFacade) {
    this.serviceFacade = serviceFacade;
  }

  @GetMapping
  public List<BankDTO> getAllBank() {
    return serviceFacade.getAllBank();
  }

  @GetMapping("{id}")
  public BankDTO getBankById(@PathVariable int id) {
    return serviceFacade.getBankById(id);
  }

  @PostMapping
  public BankDTO addBank(@RequestBody BankDTO bank) {
    return serviceFacade.createBank(bank);
  }

  @PatchMapping
  public BankDTO updateBank(@RequestBody BankDTO bank) {
    return serviceFacade.updateBank(bank);
  }
}
