DROP TABLE IF EXISTS `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `orders`;

CREATE TABLE IF NOT EXISTS `orders` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `customer_id` INT(11) NOT NULL,
    FOREIGN KEY (`customer_id`) REFERENCES customers(`id`), 
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `orders_items`;

CREATE TABLE IF NOT EXISTS `orders_items` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `orders_id` INT(11) NOT NULL,
    `items_id` INT(11) NOT NULL,
    FOREIGN KEY (`orders_id`) REFERENCES orders(`id`),
    FOREIGN KEY (`items_id`) REFERENCES items(`id`), 
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `items`;

CREATE TABLE IF NOT EXISTS `items` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);