package com.company.onlinestore.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Table(name = "ONLINESTORE_BUYER")
@Entity(name = "onlinestore_Buyer")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamePattern("%s|id")
public class Buyer extends StandardEntity {
    private static final long serialVersionUID = 8878967410472223607L;
}