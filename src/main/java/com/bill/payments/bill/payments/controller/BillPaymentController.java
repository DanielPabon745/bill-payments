package com.bill.payments.bill.payments.controller;

import com.bill.payments.bill.payments.repository.entities.BillPayment;
import com.bill.payments.bill.payments.service.BillPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bill-payments")
public class BillPaymentController {

    private final BillPaymentService billPaymentService;

    @GetMapping
    public ResponseEntity<Set<BillPayment>> getBillsByAccount(
            @RequestParam(value = "account_id") Integer accountId) {
        return this.billPaymentService.getBillPaymentsByAccount(accountId);
    }

}
