package com.gradle.torpedo02.domain.member.exception;

import org.springframework.http.HttpStatus;

public interface BaseExceptionType {
    int getErrorCode();

    HttpStatus getHttpStatus();

    String getErrorMessage();
}
