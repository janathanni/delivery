package com.delivery.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum UserErrorCode implements ErrorCodeIfs {
    USER_NOT_FOUND(200, 200, "성공");

    private final Integer httpStatusCode;
    private final Integer errorCode;
    private final String description;
}
