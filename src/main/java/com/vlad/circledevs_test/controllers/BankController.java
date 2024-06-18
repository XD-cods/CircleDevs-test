package com.vlad.circledevs_test.controllers;

import com.vlad.circledevs_test.util.ServiceFacadeImpl;
import com.vlad.circledevs_test.models.DTO.BankDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {
  private final ServiceFacadeImpl facadeImpl;

  public BankController(ServiceFacadeImpl facadeImpl) {
    this.facadeImpl = facadeImpl;
  }

  @GetMapping
  public List<BankDTO> getAllBank() {
    return facadeImpl.getAllBank();
  }
}
