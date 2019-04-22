package me.hellozin.demospringmvc;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
public class Account {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String username;

    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Transient
    private String notColumnMapping;

}
