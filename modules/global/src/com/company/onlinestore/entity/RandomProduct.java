package com.company.onlinestore.entity;

import com.company.application.entity.Product;
import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseUuidEntity;

import java.math.BigDecimal;
import java.util.Objects;

@MetaClass(name = "onlinestore_RandomProduct")
@NamePattern("%s |product")
public class RandomProduct extends BaseUuidEntity {
    private static final long serialVersionUID = -4219836015514419786L;

    @MetaProperty
    private Product product;

    @MetaProperty
    private Integer amount;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @MetaProperty
    private BigDecimal price;

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RandomProduct that = (RandomProduct) o;
        return Objects.equals(product.getName(), that.product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), product);
    }
}