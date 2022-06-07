package com.bill.payments.bill.payments.repository.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "PAYS")
public class Pay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "PAID_DATE")
    private LocalDateTime paidDate;

    @Column(name = "VALUE")
    private Double value;

    @Column(name = "INSTALLMENTS")
    private Integer installments;

    @ManyToOne
    @JoinColumn(name = "BILL_PAYMENT_ID")
    private BillPayment billPayment;


}
