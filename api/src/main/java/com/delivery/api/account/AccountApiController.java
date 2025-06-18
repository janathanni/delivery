package com.delivery.api.account;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.db.account.AccountRepository;
import com.delivery.db.account.AccountEntity;

import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    private final AccountRepository accountRepository;

    @GetMapping("")
    public void save() {
        var account = AccountEntity.builder().build();
        accountRepository.save(account);
    }
}
