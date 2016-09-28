package com.sotas.billboard05;

import com.sotas.billboard05.entity.Agent;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class AuthUser implements UserDetails {
    private Agent agent;
    public AuthUser(Agent agent) {
        this.agent = agent;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> res = new HashSet<GrantedAuthority>();
        res.add(new SimpleGrantedAuthority("ROLE_USER"));
        return res;
    }

    @Override
    public String getPassword() {
        return agent.getPassword();
    }

    @Override
    public String getUsername() {
        return agent.getLogin();
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

    public Agent getAgent() {
        return agent;
    }
}
