package com.example.lomantiy.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@EqualsAndHashCode
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String street;
    public String city;
    public String state;
    public String zip;

    protected Address(){}
    public Address (String street, String city, String state, String zip){
        this.street=street;
        this.city=city;
        this.state=state;
        this.zip=zip;
    }
}
