-- Create Tables --

create schema `minions`;

create table `minions` (
`id` int primary key not null auto_increment, 
`name` varchar(50) not null, 
`age` int
);

create table `towns` (
`town_id` int primary key not null auto_increment, 
`name` varchar(50) not null
);

-- Alter Minions Table -- 

alter table `towns`
change column `town_id` `id` int not null auto_increment;

alter table `minions`
add column `town_id` int not null,
add constraint `fk_minions_towns`
foreign key (`town_id`)
references `towns`(id);
  
  -- Insert Records in Both Tables -- 

insert into `towns`
values
(1, 'Sofia'),
(2, 'Plovdiv'),
(3, 'Varna');

insert into `minions`
values 
(1, 'Kevin', 22, 1),
(2, 'Bob', 15, 3),
(3, 'Steward', null, 2);

-- Truncate Table Minions --

truncate `minions`;

-- Drop All Tables --
use `minions`;
drop tables `minions`, `towns`;

-- Create Table People --

create schema `people`;
use `people`;

create table `people` (
	`id` int primary key auto_increment,
    `name` varchar(200) not null,
    `picture` blob,
    `height` float(2),
    `weight` float(2),
    `gender` char(1) not null,
    `birthdate` date not null,
    `biography` text
);

insert into `people` 
(`name`, `height`, `weight`, `gender`, `birthdate`) 
values 
('Stefan', '1.64', '61', 'm', '1985-1-3'),
('Petar', '1.75', '62', 'm', '1992-2-4'),
('Geno', '1.90', '89', 'm', '1988-3-7'),
('Penka', '1.60', '50', 'f', '1999-9-8'),
('GInka', '1.54', '65', 'f', '1949-1-4')
;

-- Create Table Users --

create table `users` (
	`id` int primary key auto_increment,
    `username` varchar(30) not null,
    `password` varchar(26) not null,
    `profile_picture` blob,
    `last_login_time` datetime,
    `is_deleted` bool not null
);

insert into `users`
(`username`, `password`, `is_deleted`)
values
('chefo', 'parolka123', true),
('gefo', 'parol4232', false),
('bedenefo', 'parol343223', true),
('kokaza', 'par3243223', true),
('mokaza', 'parrew32123', false)
;

-- Change Primary Key --

alter table `users`
drop primary key,
add constraint `pk_users`
primary key (`id`,`username`);

-- Set Default Value of a Field --

alter table `users`
change column `last_login_time` `last_login_time` datetime default current_timestamp;

-- Set Unique Field --

alter table `users`
drop primary key,
add constraint `pk_users`
primary key (`id`),
change column `username` `username` varchar(30) not null unique;

-- Movies Database --

create schema `movies`;

create table `directors` (
	`id` int primary key auto_increment,
    `director_name` varchar(150) not null,
    `notes` text
);

insert into `directors` 
(`director_name`)
values
('Michael Bay'),
('Steven Spielberg'),
('Guy Richie'),
('Quentin Tarantino'),
('George Lucas');

create table `genres` (
	`id` int primary key auto_increment,
	`genre_name` varchar(150) not null,
	`notes` text
);

insert into `genres`
(`genre_name`)
values
('horror'),
('action'),
('comedy'),
('drama'),
('biographoc');
 
create table `categories` (
	`id` int primary key auto_increment,
	`category_name` varchar(150) not null,
	`notes` text
);

insert into `categories`
(`category_name`)
values
('family'),
('animation'),
('children'),
('adult'),
('all_ages');
 
create table `movies`(
	`id` int primary key auto_increment,
	`title` varchar(150) not null,
	`director_id` int not null,
	`copyright_year` int not null,
	`length` time not null,
	`genre_id` int not null,
	`category_id` int not null,
	`rating` float not null,
	`notes` text
);

alter table `movies`
add constraint `fk_movies_directors` foreign key (`director_id`) references `directors`(`id`),
add constraint `fk_movies_genres` foreign key (`genre_id`) references `genres`(`id`),
add constraint `fk_movies_categories` foreign key (`category_id`) references `categories`(`id`);

-- Car Rental Database --

create schema `car_rental`;
use `car_rental`;

create table `categories` (
	`id` int primary key auto_increment, 
    `category` varchar(45) not null unique, 
    `daily_rate` double not null, 
    `weekly_rate` double not null, 
    `monthly_rate` double not null, 
    `weekend_rate` double not null
);

insert into `categories` 
(`category`, `daily_rate`, `weekly_rate`, `monthly_rate`, `weekend_rate`)
values
('roadster', 5.5, 5, 4, 6),
('SUV', 2.5, 2, 1.5, 3),
('van', 4, 3, 2.5, 5);

create table `cars` (
	`id` int primary key auto_increment, 
    `plate_number` varchar(8) not null unique, 
    `make` varchar(20) not null, 
    `model` varchar(45) not null, 
    `car_year` int not null, 
    `category_id` int not null, 
    `doors` int not null, 
    `picture` blob, 
    `car_condition` varchar(45) not null, 
    `available` bool not null,
    constraint `fk_cars_categories` foreign key (`category_id`) references `categories`(`id`)
);

insert into `cars` 
(`plate_number`, `make`, `model`, `car_year`, `category_id`, `doors`, `car_condition`, `available`)
values
('CA3456BT', 'Hyundai', 'Coupe', 2020, 1, 2, 'new', true),
('CB777777', 'Mercedes', 'GLS', 2021, 2, 4, 'new', false),
('CA1226PB', 'Renault', 'Kangoo', 2010, 3, 6, 'used', false);

create table `employees` (
	`id` int primary key auto_increment, 
    `first_name` varchar(50) not null, 
    `last_name`varchar(50) not null, 
    `title` varchar (150) not null, 
    `notes` text
);

insert into `employees` 
(`first_name`, `last_name`, `title`)
values
('Geno', 'Genov', 'Manager'),
('Petar', 'Petrov', 'Sales'),
('Tosho', 'Toshkov', 'Technician');

create table `customers` (
	`id` int primary key auto_increment,
    `driver_licence_number` int not null unique, 
    `full_name` varchar(150) not null, 
    `address` text not null, 
    `city` varchar(150) not null, 
    `zip_code` varchar(24), 
    `notes` text
);

insert into `customers` 
(`driver_licence_number`, `full_name`, `address`, `city`, `zip_code`)
values
(432345667, 'Kosta Maslinkov', 'Zonata na zdracha 13', 'Temnovo', '13424'),
(765342821, 'Blago Bibitkov', 'Slivenski geroi 3', 'Ubavino', '23454'),
(432345327, 'Pitko Mekitsov', 'Vetrino 42', 'Madara', '34453');

create table `rental_orders` (
	`id` int primary key auto_increment, 
    `employee_id` int not null, 
    `customer_id` int not null, 
    `car_id` int not null, 
    `car_condition` varchar(45) not null, 
    `tank_level` varchar(45) not null, 
    `kilometrage_start` int not null, 
    `kilometrage_end` int not null, 
    `total_kilometrage` int not null, 
    `start_date` date not null, 
    `end_date` date not null, 
    `total_days` int not null, 
    `rate_applied` double not null, 
    `tax_rate` double not null, 
    `order_status` varchar(45) not null, 
    `notes` text
);

insert into `rental_orders` 
(`employee_id`, `customer_id`, `car_id`, `car_condition`, `tank_level`,  `kilometrage_start`, `kilometrage_end`, `total_kilometrage`, 
 `start_date`, `end_date`, `total_days`, `rate_applied`, `tax_rate`, `order_status`)
 values
 (2, 1, 3, 'used', 'full', 212540, 212550, 10, '2021-01-01', '2021-01-03', 3, 1.5, 20, 'completed'),
 (1, 3, 2, 'new', 'full', 10500, 10800, 300, '2021-03-01', '2021-03-10', 10, 1.5, 20, 'completed'),
 (3, 2, 1, 'new', 'empty', 8000, 10000, 2000, '2021-02-20', '2021-02-25', 5, 5.5, 20, 'completed');
 
 -- Basic Insert --
 
create database `soft_uni`;
use `soft_uni`;
 
create table `towns` (
	`id` int primary key auto_increment,
    `name` varchar(150) not null
);

create table `addresses` (
	`id` int primary key auto_increment,
    `address_text` text not null,
    `town_id` int not null,
    constraint `fk_addresses_towns` foreign key (`town_id`) references `towns`(`id`)
);

create table `departments` (
	`id` int primary key auto_increment,
    `name` varchar(150) not null
);

create table `employees` (
	`id` int primary key auto_increment,
    `first_name` varchar(50) not null,
    `middle_name` varchar(50) not null,
    `last_name` varchar(50) not null,
    `job_title` varchar(100),
    `department_id` int not null,
    `hire_date` date,
    `salary` decimal(10,2),
    `address_id` int,
    constraint `fk_employees_department` foreign key (`department_id`) references `departments`(`id`),
    constraint `fk_employees_addresses` foreign key (`address_id`) references `addresses`(`id`)
);

insert into `towns` 
(`name`)
values
('Sofia'), ('Plovdiv'), ('Varna'), ('Burgas');

insert into `departments`
(`name`)
values
('Engineering'), ('Sales'), ('Marketing'), ('Software Development'), ('Quality Assurance');

insert into `employees`
(`first_name`, `middle_name`, `last_name`, `job_title`, `department_id`, `hire_date`, `salary`)
values
('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013/02/01', 3500.00),
('Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004/03/02', 4000.00),
('Maria', 'Petrova', 'Ivanova',	'Intern', 5, '2016/08/28', 525.25),
('Georgi', 'Terziev', 'Ivanov',	'CEO',	2, '2007/12/09', 3000.00),
('Peter', 'Pan', 'Pan',	'Intern', 3, '2016/08/28', 599.88);

-- Basic Select All Fields --

select * from `towns`;
select * from `departments`;
select * from `employees`;

-- Basic Select All Fields and Order Them --

select * from `towns` order by `name` asc;
select * from `departments` order by `name` asc;
select * from `employees` order by `salary` desc;

-- Basic Select Some Fields --

select `name` from `towns` order by `name` asc;
select `name` from `departments` order by `name` asc;
select `first_name`, `last_name`, `job_title`, `salary` from `employees` order by `salary` desc;

-- Increase Employees Salary --

update `employees`
set `salary` = `salary` * (1 + (10 / 100));

select `salary` from `employees`;

-- Delete All Records --
 
truncate table `occupancies`;