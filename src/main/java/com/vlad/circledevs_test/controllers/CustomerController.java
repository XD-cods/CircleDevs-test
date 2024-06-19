package com.vlad.circledevs_test.controllers;

import com.vlad.circledevs_test.models.DTO.CustomerDTO;
import com.vlad.circledevs_test.util.facades.interfaces.CustomerFacade;
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
@RequestMapping("customer")
public class CustomerController {
  private final CustomerFacade customerFacade;

  public CustomerController(CustomerFacade customerFacade) {
    this.customerFacade = customerFacade;
  }

  @GetMapping
  public List<CustomerDTO> getAllCustomers() {
    return customerFacade.getAll();
  }

  @GetMapping("{id}")
  public CustomerDTO getCustomerById(@PathVariable int id) {
    return customerFacade.getById(id);
  }

  @PostMapping
  public CustomerDTO addAccount(@RequestBody CustomerDTO customer) {
    return customerFacade.create(customer);
  }


  @DeleteMapping("{id}")
  public HttpStatus deleteById(@PathVariable int id) {
    customerFacade.delete(id);
    return HttpStatus.OK;
  }
}
