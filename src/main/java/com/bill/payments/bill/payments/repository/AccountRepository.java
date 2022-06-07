package com.bill.payments.bill.payments.repository;

import com.bill.payments.bill.payments.repository.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Set<Account> findByUserId(Integer userId);
}
