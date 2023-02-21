package com.workshop.day24.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.workshop.day24.exception.OrderException;
import com.workshop.day24.model.LineItem;
import com.workshop.day24.model.Order;
import com.workshop.day24.repo.LineRepo;
import com.workshop.day24.service.OrderService;

import static com.workshop.day24.Util.CalcUtil.*;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(path="/order")
public class CartController {
    
    @Autowired
    private LineRepo lineRepo;

    @Autowired
    private OrderService orderSvc;

    // method to update cart
    @PostMapping(consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateCart(@RequestBody MultiValueMap<String, String> form,
        HttpSession session, Model model) {
        
        // view form input
        System.out.println("Form: " + form);
        
        // if session exists: retrieve
        // if does not exist: create new session "cart"
        Order order = (Order) session.getAttribute("cart");
        if (null == order) {
            // create Order Object (generate OrderID, add orderDate, add customerName)
            session.setAttribute("cart", new Order(form));
            order = (Order) session.getAttribute("cart");
        }
        
        // adding new product to order
        String prodName = form.getFirst("product");
        LineItem li = lineRepo.getProductByName(prodName);
        li.setQuantity(Integer.parseInt(form.getFirst("quantity")));
        order.addLineItem(li);

        Float totalPrice = calculateTotalPrice(order);

        // insert session object to model
        model.addAttribute("order", order);
        model.addAttribute("total", totalPrice);

        return "order";
    }

    @PostMapping(path="/checkout")
    public String checkout(HttpSession session, Model model) throws OrderException {
        Order sessOrder = (Order) session.getAttribute("cart");
        System.out.println("Sess Order: " + sessOrder);
        
        // insert session details to SQL
        String confirmationId = orderSvc.insertOrderDetails(sessOrder);
        System.out.println("Confirmation ID: " + confirmationId);
        model.addAttribute("confirmationId", confirmationId);

        // end session
        session.invalidate();

        return "checkout";
    }
    
}
