package com.workshop.day24.repo;

public class Queries {
    // For queries from orders table
    public static final String SQL_INSERT_ORDER = """
        INSERT INTO orders (order_id, customer, order_date) 
        VALUES (?, ?, ?)
        """;
    
    // For queries from orders line_items
    public static final String SQL_INSERT_LINE_ITEM = """
        INSERT INTO line_items (quantity, prod_id, order_id)
        VALUES (?, ?, ?)
        """;

    public static final String SQL_GET_PRODUCT_BY_NAME = """
            SELECT * FROM products 
            WHERE prod_name = ?
            """;
}
