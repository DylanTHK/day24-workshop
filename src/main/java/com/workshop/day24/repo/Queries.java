package com.workshop.day24.repo;

public class Queries {
    public static final String SQL_INSERT_ORDER = """
        INSERT INTO orders (order_id, customer, order_date) 
        VALUES (?, ?, ?)
        """;
    
    public static final String SQL_INSERT_LINE_ITEM = """
        INSERT INTO line_items (quantity, prod_id, order_id)
        VALUES (?, ?, ?)
        """;
}
