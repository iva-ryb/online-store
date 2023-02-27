package com.company.onlinestore.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.Extends;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;

@Entity(name = "sec$ExtUser")
@NamePattern("%s %s|name,login")
@Extends(User.class)
public class ExtUser extends User {
    private static final long serialVersionUID = 2051524652017573197L;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BUYER_ID")
    private Buyer buyer;

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
}