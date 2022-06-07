package com.bill.payments.bill.payments.controller;

import com.bill.payments.bill.payments.repository.entities.BillPayment;
import com.bill.payments.bill.payments.repository.entities.Pay;
import com.bill.payments.bill.payments.service.PayService;
import com.bill.payments.bill.payments.service.model.PayRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
@RequiredArgsConstructor
public class PayController {

    private final PayService payService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BillPayment> doPayment(@RequestBody PayRequest pay) {
        return this.payService.doPayment(pay);
    }
}
