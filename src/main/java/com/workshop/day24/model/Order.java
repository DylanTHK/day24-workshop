package com.workshop.day24.model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.util.MultiValueMap;

public class Order {
    private String orderId;
    private LocalDate orderDate;
    private String customerName;
    private List<LineItem> lineItems = new LinkedList<LineItem>();

    public Order() {
    }

    public Order(MultiValueMap<String, String> form) {
        this.orderId = generateRandomId();
        this.orderDate = LocalDate.now();
        this.customerName = form.getFirst("customerName");
    }

    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public LocalDate getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDate orderDate) {
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
    public void addLineItem(LineItem lineItem) {
        this.lineItems.add(lineItem);
    }

    // method to generate 8 char ID
    public String generateRandomId() {
        String id = UUID.randomUUID().toString().substring(0,8); 
        System.out.println("UUID: " + id);
        return id;
    }

    // public static Order create() {
    //     Order o = new Order();

    //     return o;
    // }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", customerName=" + customerName
                + ", lineItems=" + lineItems + "]";
    }

}
