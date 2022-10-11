package com.gradle.torpedo02.domain.member.service;

import com.gradle.torpedo02.domain.member.presentation.dto.request.MemberSignInRequestDto;
import com.gradle.torpedo02.domain.member.presentation.dto.request.MemberSignUpRequestDto;
import com.gradle.torpedo02.domain.member.presentation.dto.response.TokenResponseDto;


public interface MemberService {

    Long join(MemberSignUpRequestDto requestDto);
    
    TokenResponseDto login(MemberSignInRequestDto requestDto);
}
