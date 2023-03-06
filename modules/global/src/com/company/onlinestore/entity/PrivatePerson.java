package com.company.onlinestore.entity;

import com.company.application.entity.Address;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.EmbeddedParameters;

import javax.persistence.*;

@Entity(name = "onlinestore_PrivatePerson")
@Table(name = "ONLINESTORE_PRIVATE_PERSON")
@NamePattern("%s|buyerType")
public class PrivatePerson extends Buyer {
    private static final long serialVersionUID = -5234581133760921413L;

    @Column(name = "FULL_NAME_PRIVATE")
    private String fullNamePrivate;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "SECOND_NAME")
    private String secondName;

    @Column(name = "PATRONYMIC")
    private String patronymic;

    @Embedded
    @EmbeddedParameters(nullAllowed = false)
    private Address address;

    @Column(name = "EMAIL")
    private String email;

    public PrivatePerson() {
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFullNamePrivate() {
        return fullNamePrivate;
    }

    public void setFullNamePrivate(String fullNamePrivate) {
        this.fullNamePrivate = fullNamePrivate;
    }
}