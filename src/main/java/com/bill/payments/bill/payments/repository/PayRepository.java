package com.bill.payments.bill.payments.repository;

import com.bill.payments.bill.payments.repository.entities.Pay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayRepository extends JpaRepository<Pay, Integer> {
}
