package com.bill.payments.bill.payments.service;

import com.bill.payments.bill.payments.repository.entities.BillPayment;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface BillPaymentService {

    ResponseEntity<Set<BillPayment>> getBillPaymentsByAccount(Integer accountId);
}
