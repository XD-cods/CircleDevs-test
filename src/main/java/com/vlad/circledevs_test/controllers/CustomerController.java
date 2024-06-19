package com.vlad.circledevs_test.controllers;

import com.vlad.circledevs_test.models.DTO.CustomerDTO;
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
@RequestMapping("customer")
public class CustomerController {
  private final ServiceFacade serviceFacade;

  public CustomerController(ServiceFacade serviceFacade) {
    this.serviceFacade = serviceFacade;
  }

  @GetMapping
  public List<CustomerDTO> getAllCustomers() {
    return serviceFacade.getAllCustomer();
  }

  @GetMapping("{id}")
  public CustomerDTO getCustomerById(@PathVariable int id) {
    return serviceFacade.getCustomerById(id);
  }

  @PostMapping
  public CustomerDTO addAccount(@RequestBody CustomerDTO customer) {
    return serviceFacade.createCustomer(customer);
  }

  @PatchMapping
  public CustomerDTO updateBank(@RequestBody CustomerDTO customer) {
    return serviceFacade.updateCustomer(customer);
  }
}
