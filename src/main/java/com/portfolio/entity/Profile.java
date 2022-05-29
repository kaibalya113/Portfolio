package com.portfolio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pId;
    private String fName;
    private String mName;
    private String lName;
    private String emailId;
    private String phoneNo;
    private String profilePic;
    private String coverPic;
    @OneToOne(cascade=CascadeType.ALL)
    private User user;
}
