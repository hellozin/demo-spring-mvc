package me.hellozin.demospringmvc;

import javax.persistence.Embeddable;

/* 이것도 Entity 가 될 수 있지만 Account entity 에 생명주기가 속해 있어 종속적이다. */
@Embeddable
public class Address {

    private String street;

    private String city;

    private String state;

    private String zipCode;

}
