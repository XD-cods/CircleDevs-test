package com.vlad.circledevs_test.controllers;

import com.vlad.circledevs_test.models.DTO.CustomerAccountDTO;
import com.vlad.circledevs_test.util.ServiceFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("account")
public class CustomerAccountController {
  private final ServiceFacade serviceFacade;

  public CustomerAccountController(ServiceFacade serviceFacade) {
    this.serviceFacade = serviceFacade;
  }

  @GetMapping
  public List<CustomerAccountDTO> getAllCustomerAccount() {
    return serviceFacade.getAllCustomerAccount();
  }

  @GetMapping("{id}")
  public CustomerAccountDTO getCustomerAccountById(@PathVariable int id) {
    return serviceFacade.getCustomerAccountById(id);
  }
}
