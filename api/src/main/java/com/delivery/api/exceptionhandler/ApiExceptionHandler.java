package com.delivery.api.exceptionhandler;

import lombok.extern.slf4j.Slf4j;
import com.delivery.api.common.api.Api;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.delivery.api.common.exception.ApiException;

@Slf4j
@RestControllerAdvice
@Order(value = Integer.MIN_VALUE)
public class ApiExceptionHandler {

   @ExceptionHandler(value = ApiException.class)
   public ResponseEntity<Api<Object>> apiException(ApiException apiException){
       log.error("", apiException);

       var errorCode = apiException.getErrorCodeIfs();

       return ResponseEntity
               .status(errorCode.getHttpStatusCode())
               .body(
                       Api.ERROR(errorCode, apiException.getErrorDescription())
               );
   }
}