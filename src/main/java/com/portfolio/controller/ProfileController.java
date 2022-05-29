package com.portfolio.controller;

import com.portfolio.entity.Profile;
import com.portfolio.utility.AuthenticationUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/profile")
public class ProfileController {


    @Autowired
    private ProfileService profileService;
    public ResponseEntity<?> getUserProfile(){
        return null;
    }

    @PostMapping("/update")
    public ResponseEntity<?> saveUserProfile(@RequestBody Profile profile){
        String username = AuthenticationUtility.getUserName();
        if(username == null){
            return ResponseEntity.notFound().build();
        }
        Profile profile1 =

        return null;
    }
}
