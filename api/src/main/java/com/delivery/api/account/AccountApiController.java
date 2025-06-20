package com.delivery.api.account;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.db.account.AccountRepository;
import com.delivery.api.account.model.AccountMeResponse;
import com.delivery.db.account.AccountEntity;
import com.delivery.api.common.api.Api;
import com.delivery.api.common.error.UserErrorCode;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    @GetMapping("/me")
    public Api<AccountMeResponse> me() {
        var response =  AccountMeResponse.builder()
                                         .name("홍길동")
                                         .email("niniz@gmail.com")
                                         .registeredAt(LocalDateTime.now())
                                         .build();
        
        var str = "안녕하세요";
        var age = Integer.parseInt(str);

        return Api.OK(response);
    }
}
