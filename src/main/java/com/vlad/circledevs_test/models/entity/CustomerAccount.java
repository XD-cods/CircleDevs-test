package com.vlad.circledevs_test.models.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAccount {
  @Id
  @GeneratedValue
  @Column(name = "account_id")
  private Integer id;
  @Column(name = "username")
  private String username;
  @Column(name = "password")
  private String password;
  @Column(name = "cash_amount")
  private int cashAmount;
  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;
}
