package com.timsource.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductSalePK implements Serializable {
    private Long productId;
    private Long saleId;

    public ProductSalePK() {
    }

    public ProductSalePK(Long productId, Long saleId) {
        this.productId = productId;
        this.saleId = saleId;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
