package com.company.onlinestore.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Table(name = "ONLINESTORE_ONLINE_ORDER")
@Entity(name = "onlinestore_OnlineOrder")
@NamePattern("%s|number")
public class OnlineOrder extends StandardEntity {

    private static final long serialVersionUID = -8572973866680594205L;

    @Column(name = "NUMBER")
    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BUYER_ID")
    @NotNull
    private Buyer buyer;

    @Composition
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "onlineOrder")
    private List<ProductList> products;

    @Column(name = "SUM")
    private BigDecimal sum;

    @Min(1)
    @Max(99)
    @Column(name = "DISCOUNT")
    private Integer discount;

    @Column(name = "STATUS")
    private String status;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ProductList> getProducts() {
        return products;
    }

    public void setProducts(List<ProductList> products) {
        this.products = products;
    }
}