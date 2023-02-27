package com.company.onlinestore.entity;

import com.company.application.entity.StoreProduct;
import com.haulmont.cuba.core.app.UniqueNumbersService;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Table(name = "ONLINESTORE_ONLINE_ORDER")
@Entity(name = "onlinestore_OnlineOrder")
public class OnlineOrder extends StandardEntity {
    private static final long serialVersionUID = -8572973866680594205L;

    @Column(name = "NUMBER")
    private String number; //todo добавить вычисление через UniqueNumbersAPI

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BUYER_ID")
    @NotNull
    private Buyer buyer;

    @NotNull
    @OneToMany
    private List<StoreProduct> productList;

    @Transient
    private BigDecimal sum;

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

    public List<StoreProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<StoreProduct> productList) {
        this.productList = productList;
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
}