package com.workshop.day24.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.workshop.day24.model.Order;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(path="/cart")
public class CartController {
    
    // method to update cart
    @PostMapping(consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateCart(@RequestBody MultiValueMap<String, String> form,
        HttpSession session, Model model) {
        
        // if does not exist: null
        Order order = (Order) session.getAttribute("cart");
        if (null == order) {
            session.setAttribute("cart", new Order(form));
            order = (Order) session.getAttribute("cart");
        }

        // pass session object into model
        System.out.println("Session Value (After): " + session.getAttribute("cart"));
        
        System.out.println("Form: " + form);

        // create Order Object (generate OrderID, add orderDate, add customerName)
        System.out.println("Order Content: " + order);

        model.addAttribute("order", order);

        System.out.println("Session 1: " + session.getAttribute("cart"));
        return "order";
    }
}
