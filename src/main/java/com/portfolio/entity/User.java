package com.portfolio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String emailId;
    private String phoneNo;
    private String role;
    private String password;
    private Date createdOn;
    private boolean isActive;
    @OneToOne(cascade=CascadeType.ALL)
    private Profile profile;
}
