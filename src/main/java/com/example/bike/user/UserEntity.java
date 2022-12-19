package com.example.bike.user;

import lombok.*;

import javax.persistence.*;

@Entity(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", nullable = false)
    private Integer seq;


    private String id;

    private String pw;

    private String addr;

    private String phone;

    private String birth;

    @Enumerated(EnumType.STRING)
    private genderEnum gender;

    enum genderEnum{
        M, F
    }
}
