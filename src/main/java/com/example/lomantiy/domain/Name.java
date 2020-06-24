package com.example.lomantiy.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@EqualsAndHashCode
public class Name {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String first;
    public String middle;
    public String last;

    protected Name(){}
    public Name(String first, String middle, String last){
        this.first=first;
        this.middle=middle;
        this.last = last;
    }
}
