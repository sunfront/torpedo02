package com.gradle.torpedo02.domain.member.presentation.dto.request;

import com.gradle.torpedo02.domain.member.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberSignUpRequestDto {

	private String userId;
    private String email;
    private String password;
    private String name;

    public Member toEntity() {
        return Member.builder()
                .userId(userId)
                .email(email)
                .password(password)
                .name(name)
                .build();
    }
}
