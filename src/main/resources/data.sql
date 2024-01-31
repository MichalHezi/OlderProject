DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS order_items;
--DROP TABLE IF EXISTS favorite_list;

CREATE TABLE users (
     id int(11) unsigned NOT NULL AUTO_INCREMENT,
     username varchar(20) NOT NULL DEFAULT '',
     password varchar(20) NOT NULL DEFAULT '',
     firstname varchar(20) NOT NULL DEFAULT '',
     lastname varchar(20) NOT NULL DEFAULT '',
     email varchar(255) NOT NULL DEFAULT '',
     phone varchar(20) NOT NULL DEFAULT '',
     address varchar(255) NOT NULL DEFAULT '',
     active tinyint(1) NOT NULL DEFAULT '1',
     roles varchar(200) NOT NULL DEFAULT '',
     permissions varchar(200) NOT NULL DEFAULT '',
     PRIMARY KEY (id)
);

CREATE TABLE orders (
    id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    order_date date NOT NULL,
    shipping_address varchar(255) NOT NULL DEFAULT '',
    total_price DECIMAL(100,2) NOT NULL DEFAULT '',
    order_status varchar(50) NOT NULL DEFAULT 'TEMP',
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);


CREATE TABLE items (
    id int(255) NOT NULL AUTO_INCREMENT,
--    order_id int(255) NOT NULL,
    title varchar(255) NOT NULL,
    photoURL varchar(255) NOT NULL DEFAULT '',
    price DOUBLE NOT NULL,
    stock INT NOT NULL DEFAULT '',
    PRIMARY KEY (id)
--    FOREIGN KEY (order_id) REFERENCES orders(id)
);

CREATE TABLE order_items (
    id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT NOT NULL,
    item_id INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (item_id) REFERENCES items(id)
);


CREATE TABLE favorite_list (
     id int(255) NOT NULL AUTO_INCREMENT,
     user_id int(255) NOT NULL DEFAULT '',
     item_id int(255) NOT NULL DEFAULT '',
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (item_id) REFERENCES items(id)
);

INSERT INTO users (username, password, active, roles, permissions) VALUES
    ('dan', '1234', 1, '', ''),
    ('alon', '12345', 2, '', '');
INSERT INTO orders (user_id,order_date,shipping_address,total_price,order_status)
VALUES (1,'2023-12-01','moshe levi 1',150,'close');

INSERT INTO items (title,photoURL,price,stock)
VALUES ('Chair','skejrfhufv',150,15);

INSERT INTO favorite_list (user_id,item_id)
VALUES (1,1);