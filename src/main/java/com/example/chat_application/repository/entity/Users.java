package com.example.chat_application.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name= "users")
@Getter
@Setter
public class Users {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String mailaddress;

    @Column
    private String password;

    @Column
    private String userName;

    @Column
    private Boolean isStopped;

    @Column
    private Timestamp createdAt;

    @Column
    private Timestamp updatedAt;
}
