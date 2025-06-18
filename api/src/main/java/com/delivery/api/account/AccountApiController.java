package com.delivery.api.account;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.db.account.AccountRepository;
import com.delivery.api.account.model.AccountMeResponse;
import com.delivery.db.account.AccountEntity;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    private final AccountRepository accountRepository;

    @GetMapping("/me")
    public AccountMeResponse me() {
        return AccountMeResponse.builder()
            .name("홍길동")
            .email("niniz@gmail.com")
            .registeredAt(LocalDateTime.now())
            .build();
    }
}
