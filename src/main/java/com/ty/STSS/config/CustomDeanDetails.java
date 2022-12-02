package com.ty.STSS.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ty.STSS.dto.Dean;
import com.ty.STSS.dto.Student;


@SuppressWarnings("serial")
public class CustomDeanDetails implements UserDetails {

    private Dean dean ;

    public CustomDeanDetails(Dean dean) {
        super();
        this.dean=dean;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(dean.getRole()));
    }

    @Override
    public String getPassword() {
        return dean.getPassword();
    }

    @Override
    public String getUsername() {
       return dean.getName();
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
}
