package com.zvl.theraven_technical_task.repository;

import com.zvl.theraven_technical_task.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
