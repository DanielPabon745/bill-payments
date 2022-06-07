package com.bill.payments.bill.payments.service;

import com.bill.payments.bill.payments.repository.entities.BillPayment;
import com.bill.payments.bill.payments.repository.entities.Pay;
import com.bill.payments.bill.payments.service.model.PayRequest;
import org.springframework.http.ResponseEntity;

public interface PayService {

    ResponseEntity<BillPayment> doPayment(PayRequest pay);
}
