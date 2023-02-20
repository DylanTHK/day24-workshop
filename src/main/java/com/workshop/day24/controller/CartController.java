package com.workshop.day24.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/cart")
public class CartController {
    
    // method to update cart
    @PostMapping(consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateCart(@RequestBody MultiValueMap<String, String> cartItems) {
        System.out.println("Cart: " + cartItems);

        return "order";
    }
}
