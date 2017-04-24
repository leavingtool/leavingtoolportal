package com.dynagility.leavingtoolportal.security;

import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    public boolean checkAuthentication() {
        return true;
    }

    public boolean checkAuthorization() {
        return true;
    }
    public static PrincipalUser getPrincipalUser()
    {
       if (SecurityContextHolder.getContext().getAuthentication() != null) {
        return (PrincipalUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       } else {
         return null;
       }
    }

}
