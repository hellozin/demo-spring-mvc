package me.hellozin.demospringmvc;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Account {

    @Id @GeneratedValue
    private Long id;

//    @Column 생략
    private String username;

    private String password;

}
