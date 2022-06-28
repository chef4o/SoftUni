/* Create Tables */

CREATE TABLE `employees` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL
);

CREATE TABLE `categories` (
    `id` INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL
);

CREATE TABLE `products` (
	`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `category_id` INT NOT NULL
);

/* Insert Data in Tables */

INSERT INTO `employees`
	(`first_name`, `last_name`) 
	VALUES 
    ('Stefan', 'Hristov');
INSERT INTO `employees` 
	(`first_name`, `last_name`) 
	VALUES 
    ('Petar', 'Ivanov');
INSERT INTO `employees` 
	(`first_name`, `last_name`) 
	VALUES 
	('Hristo', 'Gerasimov');

/* Alter Tables */

ALTER TABLE `employees`
	ADD COLUMN `middle_name` VARCHAR(50) NOT NULL AFTER `first_name`;

/* Adding Constraints */

ALTER TABLE `products`
	ADD CONSTRAINT fk_products_categories
    FOREIGN KEY (`category_id`)
    REFERENCES `categories`(`id`);
    
/* Modifying Columns */

ALTER TABLE `employees`
CHANGE COLUMN `middle_name` `middle_name` VARCHAR(100) NOT NULL;

