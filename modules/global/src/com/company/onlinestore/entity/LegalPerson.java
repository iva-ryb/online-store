package com.company.onlinestore.entity;

import com.company.application.entity.Address;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.EmbeddedParameters;

import javax.persistence.*;

@Entity(name = "onlinestore_LegalPerson")
@Table(name = "ONLINESTORE_LEGAL_PERSON")
@NamePattern("%s|fullNameLegal")
public class LegalPerson extends Buyer {
    private static final long serialVersionUID = -4901702845873708688L;

    @Column(name = "FULL_NAME_LEGAL")
    private String fullNameLegal;

    @Column(name = "NAME")
    private String name;

    @Embedded
    @EmbeddedParameters(nullAllowed = false)
    private Address address;

    @Column(name = "EMAIL")
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private ExtUser user;

    public LegalPerson() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getFullNameLegal() {
        return fullNameLegal;
    }

    public void setFullNameLegal(String fullNameLegal) {
        this.fullNameLegal = fullNameLegal;
    }

    public ExtUser getUser() {
        return user;
    }

    public void setUser(ExtUser user) {
        this.user = user;
    }
}