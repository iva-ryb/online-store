package com.company.onlinestore.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;

@Table(name = "ONLINESTORE_BUYER")
@Entity(name = "onlinestore_Buyer")
@Inheritance(strategy = InheritanceType.JOINED)
@NamePattern("%s|buyerType")
public abstract class Buyer extends StandardEntity {
    private static final long serialVersionUID = 8878967410472223607L;

    @Column(name = "TYPE")
    private String buyerType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private ExtUser user;

    public BuyerType getBuyerType() {
        return buyerType == null ? null : BuyerType.fromId(buyerType);
    }

    public void setBuyerType(BuyerType buyerType) {
        this.buyerType = buyerType == null ? null : buyerType.getId();
    }

    public ExtUser getUser() {
        return user;
    }

    public void setUser(ExtUser user) {
        this.user = user;
    }
}