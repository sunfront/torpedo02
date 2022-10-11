package com.gradle.torpedo02.domain.member.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberSignInRequestDto {

    private String userId;
    private String password;
}
