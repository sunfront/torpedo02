package com.gradle.torpedo02.domain.member.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gradle.torpedo02.domain.member.domain.Member;
import com.gradle.torpedo02.domain.member.domain.repository.MemberRepository;
import com.gradle.torpedo02.domain.member.exception.MemberException;
import com.gradle.torpedo02.domain.member.exception.MemberExceptionType;
import com.gradle.torpedo02.domain.member.presentation.dto.request.MemberSignInRequestDto;
import com.gradle.torpedo02.domain.member.presentation.dto.request.MemberSignUpRequestDto;
import com.gradle.torpedo02.domain.member.presentation.dto.response.TokenResponseDto;
import com.gradle.torpedo02.domain.member.service.MemberService;
import com.gradle.torpedo02.global.jwt.JwtTokenProvider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public Long join(MemberSignUpRequestDto requestDto) {
        if(memberRepository.findByUserId(requestDto.getUserId()).isPresent()) {
            throw new IllegalArgumentException("이미 가입된 아이디입니다.");
        }

        Member member = memberRepository.save(requestDto.toEntity());
        member.passwordEncode(passwordEncoder);
        member.addUserAuthority();
        return member.getId();
    }
    
    @Transactional
    @Override
    public TokenResponseDto login(MemberSignInRequestDto requestDto) {
        Member member = memberRepository.findByUserId(requestDto.getUserId())
                .orElseThrow(() -> new MemberException(MemberExceptionType.NOT_SIGNUP_EMAIL));
        validateMatchedPassword(requestDto.getPassword(), member.getPassword());

        //TODO : Access Token 과 Refresh Token 을 생성합니다.
        String accessToken = jwtTokenProvider.createAccessToken(member.getUsername(), member.getRole().name());
        String refreshToken = jwtTokenProvider.createRefreshToken();

        //TODO : Refresh Token 을 DB에 저장합니다.
        member.updateRefreshToken(refreshToken);
        memberRepository.save(member);

        return TokenResponseDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }    
    
    private void validateMatchedPassword(String validPassword, String memberPassword) {
        if (!passwordEncoder.matches(validPassword, memberPassword)) {
            throw new MemberException(MemberExceptionType.WRONG_PASSWORD);
        }
    }    
}
