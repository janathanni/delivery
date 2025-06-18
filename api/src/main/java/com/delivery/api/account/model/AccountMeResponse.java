package com.delivery.api.account.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccountMeResponse {
    private String email;
    private String name;
    private LocalDateTime registeredAt;
}
