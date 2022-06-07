package com.bill.payments.bill.payments.repository.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "BILL_PAYMENTS")
public class BillPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "BALANCE_PAYABLE")
    private Double balancePayable;

    @Column(name = "BALANCE_PAID")
    private Double balancePaid;

    @Column(name = "CREATION_DATE")
    private LocalDateTime creationDate;

    @Column(name = "INSTALLMENTS")
    private Integer installments;

    @Column(name = "IS_PAID")
    private Boolean paid;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

}
