package com.gradle.torpedo02.domain.member.presentation.dto;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gradle.torpedo02.domain.member.presentation.dto.request.MemberSignInRequestDto;
import com.gradle.torpedo02.domain.member.presentation.dto.request.MemberSignUpRequestDto;
import com.gradle.torpedo02.domain.member.presentation.dto.response.TokenResponseDto;
import com.gradle.torpedo02.domain.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/join")
    public Long join(@RequestBody MemberSignUpRequestDto requestDto) {
        return memberService.join(requestDto);
    }
    
    @PostMapping("/login")
    public TokenResponseDto login(@RequestBody @Valid MemberSignInRequestDto requestDto) {
        return memberService.login(requestDto);
    }    
}
