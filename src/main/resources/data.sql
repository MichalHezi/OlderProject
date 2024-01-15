DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS "order";
DROP TABLE IF EXISTS item;
--DROP TABLE IF EXISTS favorite_list;

CREATE TABLE user (
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

CREATE TABLE "order"(
    id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    order_date date NOT NULL,
    shipping_address varchar(255) NOT NULL DEFAULT '',
    total_price DECIMAL(100,2) NOT NULL DEFAULT '',
    order_status varchar(50) NOT NULL DEFAULT 'TEMP',
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user(id)
);
--    private int id;
--    @JsonProperty("user_id")
--    private Long userId;
--    @JsonProperty("order_date")
--    private LocalDate orderDate;
--    @JsonProperty("shipping_address")
--    private String shippingAddress;
--    @JsonProperty("total_price")
--    private double totalPrice;
--    @JsonProperty("order_status")
--    private OrderType orderStatus;

CREATE TABLE item (
    id int(255) NOT NULL AUTO_INCREMENT,
    title varchar(255) NOT NULL,
    photoURL varchar(255) NOT NULL DEFAULT '',
    price DOUBLE NOT NULL,
    stock INT NOT NULL DEFAULT ''
);

--CREATE TABLE favorite_list (
--     id int(255) NOT NULL AUTO_INCREMENT,
--     user_id int(255) NOT NULL DEFAULT '',
--     item_id int(255) NOT NULL DEFAULT '',
--    PRIMARY KEY (user_id, item_id),
--    FOREIGN KEY (user_id) REFERENCES user(id),
--    FOREIGN KEY (item_id) REFERENCES item(id)
--);

INSERT INTO user (username, password, active, roles, permissions) VALUES
    ('dan', '1234', 1, '', ''),
    ('alon', '12345', 1, '', '');
