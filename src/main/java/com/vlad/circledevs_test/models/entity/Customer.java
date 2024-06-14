package com.vlad.circledevs_test.models.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "customer_id")
  private Integer id;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  @ManyToOne
  @JoinColumn(name = "bank_id")
  private Bank bank;
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "account_id")
  private List<CustomerAccount> customerAccounts;

  public Customer(Bank bank, String firstName, String lastName) {
    this.bank = bank;
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
