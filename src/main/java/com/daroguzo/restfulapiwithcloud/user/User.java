package com.daroguzo.restfulapiwithcloud.user;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private LocalDateTime joinDate;



}
