package com.bill.payments.bill.payments.service.impl;

import com.bill.payments.bill.payments.repository.AccountRepository;
import com.bill.payments.bill.payments.repository.entities.Account;
import com.bill.payments.bill.payments.repository.entities.BillPayment;
import com.bill.payments.bill.payments.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public ResponseEntity<Set<Account>> getAccountsByUser(Integer userId) {
        Set<Account> accountsByUser = this.accountRepository.findByUserId(userId);
        return accountsByUser.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                                    : ResponseEntity.ok(accountsByUser);
    }
}
