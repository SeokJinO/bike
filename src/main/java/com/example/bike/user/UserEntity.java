package com.example.bike.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.transaction.Transactional;

@ToString
@Setter
@Getter
@Entity(name = "user")
public class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", nullable = false)
    private int seq;


    @Column(name = "ID", nullable = false)
    private String id;

    @Column(name = "PW", nullable = false)
    private String pw;

    @Column(name = "addr")
    private String addr;

    @Column(name = "phone")
    private String phone;

    @Column(name = "birth")
    private String birth;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private genderEnum gender;

    enum genderEnum{
        M, F
    }
}
