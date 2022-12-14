package com.gradle.torpedo02.domain.member.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberExceptionType implements BaseExceptionType {
    ALREADY_EXIST_EMAIL(600, HttpStatus.OK, "이미 존재하는 이메일입니다."),
    NOT_SIGNUP_EMAIL(601, HttpStatus.OK, "가입되지 않은 이메일입니다."),
    WRONG_PASSWORD(602, HttpStatus.OK, "비밀번호가 일치하지 않습니다."),
    NOT_FOUND_MEMBER(603, HttpStatus.OK, "존재하지 않는 회원입니다."),
    REQUIRED_DO_LOGIN(604, HttpStatus.OK, "로그인이 필요합니다.");

    private int errorCode;
    private HttpStatus httpStatus;
    private String errorMessage;

    @Override
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }
}
