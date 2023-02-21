package com.workshop.day24.model;

public class LineItem {
    private String productName; // from form
    private Integer quantity; // from form
    private Float unitPrice; // query sql
    private Integer productId; // query sql (for inserting to SQL table)

    public LineItem() {
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String product) {
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
        return "LineItem [productName=" + productName + ", quantity=" + quantity + ", unitPrice=" + unitPrice
                + ", productId=" + productId + "]";
    }

}
