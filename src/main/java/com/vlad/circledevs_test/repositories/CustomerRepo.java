package com.vlad.circledevs_test.repositories;

import com.vlad.circledevs_test.models.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
