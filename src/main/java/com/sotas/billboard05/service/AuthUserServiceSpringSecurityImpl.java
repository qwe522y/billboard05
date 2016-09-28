package com.sotas.billboard05.service;

import com.sotas.billboard05.AuthUser;
import com.sotas.billboard05.exception.GetAuthUserError;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthUserServiceSpringSecurityImpl implements AuthUserService {
    @Override
    public AuthUser getAuthUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        if(context == null) throw new GetAuthUserError();
        Authentication auth = context.getAuthentication();
        if(auth == null) throw new GetAuthUserError();
        Object e = auth.getPrincipal();
        if(e == null) throw new GetAuthUserError();
        return (AuthUser) e;
    }
}
