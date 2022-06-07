package com.bill.payments.bill.payments.repository.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "BANKS")
public class Bank implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(name = "NAME")
    private String name;

    @NotBlank
    @Column(name = "NIT")
    private String nit;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
//
//    @JsonIgnore
//    @OneToMany(targetEntity = Account.class)
//    private List<Account> accounts;
}
