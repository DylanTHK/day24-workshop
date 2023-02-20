CREATE DATABASE myCart;

use myCart;

-- create order table
CREATE TABLE orders (
	order_id CHAR(8) NOT NULL,
    customer VARCHAR(128) NOT NULL,
    order_date DATE NOT NULL,
    
    primary key(order_id)
);

-- create product table
CREATE TABLE products (
	prod_id INTEGER AUTO_INCREMENT NOT NULL,
    prod_name VARCHAR(128) NOT NULL,
    prod_price DECIMAL(10,2) NOT NULL,
    
    PRIMARY KEY(prod_id)
);

-- create line item table
CREATE TABLE line_items (
	line_id INTEGER AUTO_INCREMENT NOT NULL,
    quantity INTEGER NOT NULL,
    prod_id INTEGER NOT NULL,
    order_id CHAR(8) NOT NULL,
    
    PRIMARY KEY(line_id),
    FOREIGN KEY (prod_id) REFERENCES products(prod_id),
	FOREIGN KEY (order_id) REFERENCES orders(order_id)
); 

-- insert products to table
INSERT INTO products (prod_name, prod_price) VALUES ("Milo", 5.00);
INSERT INTO products (prod_name, prod_price) VALUES ("Horlicks", 6.50);
INSERT INTO products (prod_name, prod_price) VALUES ("Tea", 3.50);
