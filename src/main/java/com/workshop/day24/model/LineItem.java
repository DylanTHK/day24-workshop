package com.workshop.day24.model;


public class LineItem {
    private Integer id;
    private String productName;
    private Float unitPrice;
    private Integer quantity;
    private Integer productId; // to link products table

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
