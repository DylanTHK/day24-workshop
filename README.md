# day24-workshop
Updating order tables with Transactions

## Tables
- orders (order_id, customer , order_date)
- line_items (line_id, quantity, prod_id, order_id)
- products (prod_id, prod_name, prod_price)

## JDBC Template requirements
1. Controller (Manage Http Requests)
2. Html (View and Model)
3. Models (POJO)
4. Repository (Make MySQL Queries)
5. Service (Business Logic, communicate with Repo Class)
6. Exception (Add error message when Transaction rollsback)
7. application.properties (MySQL url, user, password)


## JDBC Template Project Flow
```
1. index.html -> order.html
2. order.html (Track List, sessions)
3. order.html -> checkout.html (Transaction to check length)
```

## Queries
```
<!-- inserting ORDER into orders table -->
public static final String SQL_INSERT_ORDER = """
        INSERT INTO orders (order_id, customer, order_date) 
        VALUES (?, ?, ?)
        """;
    
<!-- insert LINE ITEM into line_items table -->
public static final String SQL_INSERT_LINE_ITEM = """
    INSERT INTO line_items (quantity, prod_id, order_id)
    VALUES (?, ?, ?)
    """;

<!-- get product details with NAME -->
public static final String SQL_GET_PRODUCT_BY_NAME = """
        SELECT * FROM products 
        WHERE prod_name = ?
        """;
```


