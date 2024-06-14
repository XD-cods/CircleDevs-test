package com.vlad.circledevs_test.models.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAccountDTO {
  private Integer id;
  private String username;
  private String password;
  private int cashAmount;
  private CustomerDTO customer;

  public CustomerAccountDTO(String username, String password) {
    this.username = username;
    this.password = password;
  }
}