package com.vlad.circledevs_test.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
  private Integer id;
  private String firstName;
  private String lastName;
  private List<CustomerAccountDTO> customerAccounts;
}
