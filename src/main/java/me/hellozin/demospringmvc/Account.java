package me.hellozin.demospringmvc;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "home_street"))
    })
    private Address homeAddress;

    @OneToMany(mappedBy = "owner")
    private Set<Study> studies = new HashSet<>();

    public void addStudy(Study study) {
        this.getStudies().add(study);
        study.setOwner(this);
    }
}
