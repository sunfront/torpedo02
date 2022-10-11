package com.gradle.torpedo02.domain.member.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
//@DynamicUpdate
//@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "MEMBER")
public class Member implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;
    
    @Column(length = 100, nullable = false)
    private String userId;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 200, nullable = false)
    private String password;

    @Column(length = 100, nullable = false)
    private String name;
    
    private String refreshToken;    

    @Enumerated(EnumType.STRING)
    private Role role;

    public void addUserAuthority() {
        this.role = Role.USER;
    }

    public void passwordEncode(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auth = new ArrayList<>();
        auth.add(new SimpleGrantedAuthority(role.name()));
        return auth;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }    
    
    @Builder
    public Member(Long id, String email, 
    		String password, String name, 
    		String userId) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.userId = userId;
    }    
}    