package com.vlad.circledevs_test.repositories;

import com.vlad.circledevs_test.models.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepo extends JpaRepository<Bank, Integer> {
  public Boolean existsBankByTitle(String title);

  public Boolean existsById(int id);
}

