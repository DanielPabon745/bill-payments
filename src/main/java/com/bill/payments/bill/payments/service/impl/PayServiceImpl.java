package com.bill.payments.bill.payments.service.impl;

import com.bill.payments.bill.payments.repository.BillPaymentRepository;
import com.bill.payments.bill.payments.repository.PayRepository;
import com.bill.payments.bill.payments.repository.entities.BillPayment;
import com.bill.payments.bill.payments.repository.entities.Pay;
import com.bill.payments.bill.payments.service.PayService;
import com.bill.payments.bill.payments.service.model.PayRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PayServiceImpl implements PayService {

    private final PayRepository payRepository;
    private final BillPaymentRepository billPaymentRepository;

    @Override
    public ResponseEntity<BillPayment> doPayment(PayRequest pay) {
        BillPayment billPaymentSaved = this.billPaymentRepository.findById(pay.getBillPaymentId())
                .map(billPayment ->
                    {
                        billPayment.setInstallments(billPayment.getInstallments() - pay.getInstallments());
                        billPayment.setBalancePaid(billPayment.getBalancePaid() + pay.getValue());
                        billPayment.setBalancePayable(billPayment.getBalancePayable() - pay.getValue());
                        if (billPayment.getBalancePayable() <= 0) {
                            billPayment.setPaid(true);
                        }
                        return this.billPaymentRepository.save(billPayment);
                    }).orElse(null);

        Pay payment = new Pay();
        payment.setBillPayment(billPaymentSaved);
        payment.setInstallments(pay.getInstallments());
        payment.setValue(pay.getValue());
        payment.setPaidDate(pay.getPaidDate());

        this.payRepository.save(payment);

        return Objects.nonNull(billPaymentSaved) ? ResponseEntity.ok(billPaymentSaved)
                                                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
