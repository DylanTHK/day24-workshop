package com.workshop.day24.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workshop.day24.exception.OrderException;
import com.workshop.day24.model.Order;
import com.workshop.day24.repo.LineRepo;
import com.workshop.day24.repo.OrderRepo;

@Service
public class OrderService {
    
    @Autowired
    LineRepo lineRepo;

    @Autowired
    OrderRepo orderRepo;

    // if over, throw OrderException (ends transaction)
    @Transactional(rollbackFor = OrderException.class)
    public String insertOrderDetails(Order o) throws OrderException {
        System.out.println("Inserting from OrderSvc");
        String errorMessage = "Max 3 items in cart";

        
        // insert order (OrderRepo)
        orderRepo.insertOrder(o);
        // insert line items (LineRepo)
        lineRepo.insertLineItems(o);
        
        // check if lineItems length <= 3
        if(o.getLineItems().size() > 3) {
            throw new OrderException(errorMessage);
        }
        
        return o.getOrderId();
    }
}
