package com.vlad.circledevs_test.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankDTO {
  private Integer id;
  private String title;
  private String address;
  private List<CustomerDTO> customers;

  public BankDTO(String title, String address) {
    this.title = title;
    this.address = address;
  }
}