package com.portfolio.utility;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationUtility {

    public static String getUserName(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        if(userDetails != null){
            return userDetails.getUsername();
        }
        return null;
    }
}
