package com.portfolio.service;

import com.portfolio.config.UserProfile;
import com.portfolio.dao.UserDao;
import com.portfolio.entity.Profile;
import com.portfolio.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUserPhoneNo(username); // username describe user email Id
        if(Objects.isNull(user)){
            throw new UsernameNotFoundException("User Not Found");
        }

        UserProfile profile = new UserProfile(user);
        return profile;
    }

    public User saveUser(User user){
        User u = new User();
        u.setProfile(null);
        u.setCreatedOn(new Date());
        u.setActive(true);
        u.setEmailId(user.getEmailId());
        u.setPassword(user.getPassword());
        u.setPhoneNo(user.getPhoneNo());
        u.setRole("ROLE_USER");
        Profile p = new Profile();
        p.setPhoneNo(user.getPhoneNo());
        p.setEmailId(user.getEmailId());
        u.setProfile(p);

        return userDao.save(u);
    }

    public User findByUserPhoneNo(String phoneNo){
        return userDao.findByPhoneNo(phoneNo);
    }

}
