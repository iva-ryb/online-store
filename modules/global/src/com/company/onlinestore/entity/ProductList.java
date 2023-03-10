package com.company.onlinestore.entity;

import com.company.application.entity.Product;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "ONLINESTORE_PRODUCT_LIST")
@Entity(name = "onlinestore_ProductList")
@NamePattern("%s|product")
public class ProductList extends StandardEntity {
    private static final long serialVersionUID = -381407695247593676L;

    @Column(name = "AMOUNT")
    private Integer amount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name = "PRICE")
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ONLINEORDER_ID")
    private OnlineOrder onlineOrder;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setOnlineOrder(OnlineOrder onlineOrder) {
        this.onlineOrder = onlineOrder;
    }

    public OnlineOrder getOnlineOrder() {
        return onlineOrder;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }
}