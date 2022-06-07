package com.bill.payments.bill.payments.service.model;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
public class PayRequest {

    @NotBlank
    private LocalDateTime paidDate;

    @NotBlank
    private Double value;

    @NotBlank
    private Integer installments;

    @NotBlank
    private Integer billPaymentId;

}
