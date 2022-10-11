package com.gradle.torpedo02.domain.member.exception;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public class MemberException extends BaseException {
    private BaseExceptionType exceptionType;

    @Override
    public BaseExceptionType getExceptionType() {
        return exceptionType;
    }
}
