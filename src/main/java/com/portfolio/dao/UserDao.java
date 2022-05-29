package com.portfolio.dao;

import com.portfolio.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByPhoneNo(String phoneNo);
}
