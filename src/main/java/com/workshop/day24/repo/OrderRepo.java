package com.workshop.day24.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.workshop.day24.model.Order;

import static com.workshop.day24.repo.Queries.*;

@Repository
public class OrderRepo {
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public void insertOrder(Order o) {
        System.out.println("Inserting Order");
        jdbcTemplate.update(SQL_INSERT_ORDER, 
            o.getOrderId(), 
            o.getCustomerName(), 
            o.getOrderDate());
    }

}
