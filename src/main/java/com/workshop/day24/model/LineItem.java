package com.workshop.day24.model;

import org.springframework.util.MultiValueMap;

public class LineItem {
    private Integer id; // delete if not required
    private String productName; // from form
    private Integer quantity; // from form
    private Float unitPrice; // query sql
    private Integer productId; // query sql

    public LineItem() {
    }

    public LineItem(MultiValueMap<String, String> form) {
        
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getProduct() {
        return productName;
    }
    public void setProduct(String product) {
        this.productName = product;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Float getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }
    public Integer getProductId() {
        return productId;
    }
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "LineItem [id=" + id + ", product=" + productName + ", unitPrice=" + unitPrice + ", quantity=" + quantity
                + ", productId=" + productId + "]";
    }

}
