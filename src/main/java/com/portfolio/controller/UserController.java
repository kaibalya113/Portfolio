package com.portfolio.controller;

import com.portfolio.entity.User;
import com.portfolio.service.UserService;
import com.portfolio.utility.JWTUtility;
import com.portfolio.utility.JwtReponse;
import com.portfolio.utility.JwtRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTUtility jwtUtility;

    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody JwtRequest jwtRequest) throws Exception {
        // Authenticate Username and password using authentication manager
        // from srpring security
        log.debug("Enter");
        // if valid then create jwt token
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword())
            );
        }catch (BadCredentialsException b ){
            throw  new Exception("Invalid Credentials", b);
        }
        catch (Exception e){
            log.error(e.getMessage());
        }
        log.debug("HI");
        final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());
        final String token = jwtUtility.generateToken(userDetails);
        log.debug(token);
        return ResponseEntity.ok().body(new JwtReponse(token));
    }

    
}
