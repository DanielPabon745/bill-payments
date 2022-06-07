package com.bill.payments.bill.payments.controller;

import com.bill.payments.bill.payments.repository.entities.Account;
import com.bill.payments.bill.payments.repository.entities.BillPayment;
import com.bill.payments.bill.payments.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<Set<Account>> getAccountsByUser(
            @RequestParam(value = "user_id") Integer userId) {
        return this.accountService.getAccountsByUser(userId);
    }

}
