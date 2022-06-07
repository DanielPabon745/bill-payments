package com.bill.payments.bill.payments.repository;

import com.bill.payments.bill.payments.repository.entities.BillPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface BillPaymentRepository extends JpaRepository<BillPayment, Integer> {

    Set<BillPayment> findByAccountId(Integer accountId);
}
