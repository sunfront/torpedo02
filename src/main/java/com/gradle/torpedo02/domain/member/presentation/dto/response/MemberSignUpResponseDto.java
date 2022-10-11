package com.gradle.torpedo02.domain.member.presentation.dto.response;

import com.gradle.torpedo02.domain.member.domain.Member;

import lombok.Getter;

@Getter
public class MemberSignUpResponseDto {

    private Long id;
    private String email;
    private String userId;
    private String name;
    private String password;

    public MemberSignUpResponseDto(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.userId = member.getUserId();
        this.name = member.getName();
        this.password = member.getPassword();
    }
}
