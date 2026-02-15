package com.example.chat_application.controller.security;

import com.example.chat_application.repository.entity.Users;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class LoginUserDetails implements UserDetails {

    private Users user;
    private final Collection<? extends GrantedAuthority> authorities;

    // コンストラクタをシンプルにする
    public LoginUserDetails(Users user) {
        this.user = user;
        // 判定をやめて、全員に一律で最低限の権限（ROLE_USER）を与える
        this.authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return user.getMailaddress();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public boolean isEnabled() {
        return !user.getIsStopped();
    }

}