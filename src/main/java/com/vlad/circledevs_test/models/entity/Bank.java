package com.vlad.circledevs_test.models.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "bank")
public class Bank {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "bank_id")
  private Integer id;
  @Column(name = "bank_title")
  private String title;
  @Column(name = "address")
  private String address;
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "customer_id")
  private List<Customer> customers;

  public Bank(String address, String title) {
    this.address = address;
    this.title = title;
  }
}