package com.workshop.day24.model;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class Order {
    private String orderId;
    private Date orderDate;
    private String customerName;
    private List<LineItem> lineItems = new LinkedList<LineItem>();

    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public List<LineItem> getLineItems() {
        return lineItems;
    }
    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }
    public void addOrderDetails(LineItem lineItem) {
        this.lineItems.add(lineItem);
    }

    public String generateId() {

        return "";
    }

    public static Order create() {
        Order o = new Order();


        return o;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", customerName=" + customerName
                + ", lineItems=" + lineItems + "]";
    }

}
