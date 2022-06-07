package com.bill.payments.bill.payments.service.impl;

import com.bill.payments.bill.payments.repository.BillPaymentRepository;
import com.bill.payments.bill.payments.repository.entities.BillPayment;
import com.bill.payments.bill.payments.service.BillPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BillPaymentServiceImpl implements BillPaymentService {

    private final BillPaymentRepository billPaymentRepository;

    @Override
    public ResponseEntity<Set<BillPayment>> getBillPaymentsByAccount(Integer accountId) {
        Set<BillPayment> bills =
                this.billPaymentRepository.findByAccountId(accountId)
                        .stream().filter(billPayment -> !billPayment.getPaid())
                        .collect(Collectors.toSet());
        return bills.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                            : ResponseEntity.ok(bills);
    }
}
