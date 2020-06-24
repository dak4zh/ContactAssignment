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
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String number;
    public String type;
    protected Phone(){}
    public Phone(String number, String type){
        this.number=number;
        this.type=type;
    }
}
