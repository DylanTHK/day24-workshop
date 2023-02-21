use myCart;

SELECT * FROM orders;
SELECT * FROM line_items;
SELECT * FROM products;

-- conduct joins
SELECT o.order_id, o.customer, o.order_date, li.quantity, p.prod_name, p.prod_price
FROM orders as o
INNER JOIN line_items AS li ON o.order_id = li.order_id
INNER JOIN products AS p ON p.prod_id = li.prod_id;

-- inserts (to occur with transaction)
-- insert to orders tproductsable (1 per order)
INSERT INTO orders (order_id, customer, order_date) 
VALUES ("abc12345", "Jill", CURDATE());

-- insert to line_items
INSERT INTO line_items (quantity, prod_id, order_id)
VALUES (5, 1, "abc12345");

SELECT * FROM products 
WHERE prod_name = "Milo";

UPDATE products
SET prod_name="Horlicks", prod_price=6.5
WHERE prod_id=2;