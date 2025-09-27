package com.example.mscustomer.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionConstants {
    UNEXPECTED_EXCEPTION("UNEXPECTED_EXCEPTION", "Unexpected exception occurred"),
    HTTP_METHOD_IS_NOT_CORRECT("HTTP_METHOD_IS_NOT_CORRECT", "http method is not correct"),
    CUSTOMER_NOT_FOUND("CUSTOMER_NOT_FOUND", "Customer not found by id");

    private final String code;
    private final String message;
}