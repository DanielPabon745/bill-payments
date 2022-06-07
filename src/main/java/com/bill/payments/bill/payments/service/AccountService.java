package com.bill.payments.bill.payments.service;

import com.bill.payments.bill.payments.repository.entities.Account;
import com.bill.payments.bill.payments.repository.entities.BillPayment;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface AccountService {

    ResponseEntity<Set<Account>> getAccountsByUser(Integer userId);
}
