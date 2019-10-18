package com.tbl.ssj.bo.security;

import com.tbl.ssj.bo.AccountBO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {
    AccountBO accountBO;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return accountBO.getPassword();
    }

    @Override
    public String getUsername() {
        return accountBO.getUserName();
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

    public CustomUserDetails(AccountBO accountBO) {
        this.accountBO = accountBO;
    }

    public AccountBO getAccountBO() {
        return accountBO;
    }

    public void setAccountBO(AccountBO accountBO) {
        this.accountBO = accountBO;
    }
}
