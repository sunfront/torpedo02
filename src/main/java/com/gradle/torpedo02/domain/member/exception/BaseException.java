package com.gradle.torpedo02.domain.member.exception;

public abstract class BaseException extends RuntimeException {
    public abstract BaseExceptionType getExceptionType();
}
