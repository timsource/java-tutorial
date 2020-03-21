package com.timsource.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_SALE")
public class ProductSale {

    @Column(name = "QUANTITY")
    private int quantity;

    @EmbeddedId
    private ProductSalePK id;

    public ProductSalePK getId() {
        return id;
    }

    public void setId(ProductSalePK id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "saleId", insertable = false, updatable = false)
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "productId", insertable = false, updatable = false)
    private Product product;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Sale getSale() {
        return sale;
    }

    public Product getProduct() {
        return product;
    }
}
