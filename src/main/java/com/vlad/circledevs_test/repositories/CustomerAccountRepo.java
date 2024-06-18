package com.vlad.circledevs_test.repositories;

import com.vlad.circledevs_test.models.entity.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerAccountRepo extends JpaRepository<CustomerAccount, Integer> {

}
