use myCart;

SELECT * FROM orders;
SELECT * FROM products;
SELECT * FROM line_items;

-- conduct joins
SELECT o.order_id, o.customer, o.order_date, li.quantity, p.prod_name, p.prod_price
FROM orders as o
INNER JOIN line_items AS li ON o.order_id = li.order_id
INNER JOIN products AS p ON p.prod_id = li.prod_id;

-- inserts (to occur with transaction)
-- orders tablle (1 per order)
INSERT INTO orders (order_id, customer, order_date) 
VALUES ("abc12345", "Jill", CURDATE());