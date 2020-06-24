package com.example.lomantiy.domain;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@EqualsAndHashCode
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    @NotNull(message="who is the owner of this ad?")
    @OneToOne(cascade=CascadeType.ALL)
    public Name name;
    @NotNull(message="please,give an address")
            @OneToOne(cascade=CascadeType.ALL)
    public Address address;
    @NotNull(message="please, provide phone number")
    @OneToMany(cascade=CascadeType.ALL)
    public List<Phone> phone;
    @Email(message= "Insert valid email.")
    public String email;
    protected Contact(){}
    public Contact(Name name,Address address,List<Phone> phone,String email){
        this.name=name;
        this.address=address;
        this.phone = phone;
        this.email=email;
    }

    public long getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public List<Phone> getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
