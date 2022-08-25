create schema `stc`;
use `stc`;

-- Section 1: Data Definition Language (DDL) – 40 pts --
-- 1.	Table Design --

create table `clients` (
	`id` int primary key auto_increment,
   `full_name` varchar(50) not null,
   `phone_number` varchar(20) not null
);

create table `addresses` (
	`id` int primary key auto_increment,
	`name` varchar(100) not null
);

create table `categories` (
	`id` int primary key auto_increment,
   `name` varchar(10) not null
);

create table `cars` (
	`id` int primary key auto_increment,
   `make` varchar(20) not null,
   `model` varchar(20),
   `year` int not null default 0,
   `mileage` int default 0,
   `condition` char(1) not null,
	`category_id` int not null,
   constraint `fk_cars_categories` foreign key (`category_id`) references `categories`(`id`)
);

create table `courses` (
	`id` int primary key auto_increment,
   `from_address_id` int not null,
   `start` datetime not null,
   `car_id` int not null,
   `client_id` int not null,
   `bill` decimal(10,2) default 10,
   constraint `fk_courses_addresses` foreign key (`from_address_id`) references `addresses`(`id`),
   constraint `fk_courses_cars` foreign key (`car_id`) references `cars`(`id`),
   constraint `fk_courses_clients` foreign key (`client_id`) references `clients`(`id`)
);

create table `drivers` (
	`id` int primary key auto_increment,
   `first_name` varchar(30) not null,
   `last_name` varchar(30) not null,
   `age` int not null,
   `rating` float default 5.5
);

create table `cars_drivers` (
	`car_id` int not null,
   `driver_id` int not null,
   primary key (`car_id`,`driver_id`),
   constraint `fk_cars_drivers_cars` foreign key (`car_id`) references `cars`(`id`),
   constraint `fk_cars_drivers_drivers` foreign key (`driver_id`) references `drivers`(`id`)
);

-- Section 2: Data Manipulation Language (DML) – 30 pts --
-- 2.	Insert --

insert into `clients` (`full_name`, `phone_number`)
			select 
				concat_ws(' ', `first_name`, `last_name`) as `full_name`,
				concat('(088) 9999',`id` * 2) as `phone_number`
			from `drivers`
			where `id` between 10 and 20;
	
-- 3.	Update --

update `cars`
set `condition` = 'C'
where `mileage` >=  800000  or `mileage` is null
and year <= 2010
and `make` != 'Mercedes-Benz';

-- 4.	Delete --

delete from `clients`
where `id` in (select a.`id` from
								(select cl.`id`
											from `clients` cl
											left join `courses` c
											on cl.`id` = c.`client_id`
											where char_length(`full_name`) > 3 
											and c.`client_id` is null) a );
                                 
-- 5.	Cars --

select `make`, `model`, `condition` 
from `cars`
order by `id`;

-- 6.	Drivers and Cars --

select d.`first_name`, d.`last_name`, c.`make`, c.`model`, c.`mileage`
from `drivers` d
left join `cars_drivers` cd
on d.`id` = cd.`driver_id`
left join `cars` c
on cd.`car_id` = c.`id`
where `mileage` is not null
order by c.`mileage` desc, d.`first_name`;

-- 7.	Number of courses for each car --

select 
		c.`id` as `car_id`, 
      c.`make`,
      c.`mileage`,
		count(co.`id`) as `count_of_courses`,
      round(avg(co.`bill`), 2) as `avg_bill`
from `cars` c
left join `courses` co
on c.`id` = co.`car_id`
group by c.`id`
having count(c.`id`) != 2
order by `count_of_courses` desc, `car_id`;

-- 8.	Regular clients --

select 
		c.`full_name`,
      count(distinct co.`car_id`) as `count_of_cars`,
      sum(co.`bill`) as `total_sum`
from `clients` c
left join `courses` co
on c.`id` = co.`client_id`
where c.`full_name` like '_a%'
group by c.`id`
having count(distinct co.`car_id`) > 1
order by c.`full_name`;

-- 9.	Full information of courses --

select 
		a.`name`,
      (if(hour(c.`start`) between 6 and 20, 'Day', 'Night')) as `day_time`,
      c.`bill`,
      cl.`full_name`,
      v.`make`, 
      v.`model`,
      ctg.`name` as `category_name`
from `courses` c
left join `addresses` a 
on c.`from_address_id` = a.`id`
left join `clients` cl
on c.`client_id` = cl.`id`
left join `cars` v
on c.`car_id` = v.`id`
left join `categories` ctg
on v.`category_id` = ctg.`id`;

-- Section 4: Programmability – 30 pts --
-- 10.	Find all courses by client’s phone number --

CREATE FUNCTION udf_courses_by_client (phone_num VARCHAR (20)) 
RETURNS INTEGER
BEGIN
DECLARE e_count int;
   
	SET e_count := (select count(co.`id`)
							from `clients` cl
							left join `courses` co
							on cl.`id` = co.`client_id`
							where cl.`phone_number` = phone_num);
   
	RETURN e_count;
    
RETURN 1;
END;
                     
-- 11.	Full info for address

CREATE PROCEDURE `udp_courses_by_address` (address_name varchar(50))
BEGIN
			select 
					a.`name`,
				  c.`full_name`,
				  (case 
						when co.`bill` <= 20 then 'Low'
						when co.`bill` <= 30 then 'Medium'
						when co.`bill` <= 40 then 'High'
				  end) as `level_of_bill`,
				  v.`make`,
				  v.`condition`,
				  cat.`name` as `cat_name`
			from `addresses` a
			left join `courses` co
			on a.`id` = co.`from_address_id`
			left join `clients` c 
			on co.`client_id` = c.`id`
			left join `cars` v
			on co.`car_id` = v.`id`
			left join `categories` cat
			on v.`category_id` = cat.`id`
			where a.`name` = address_name
			order by v.`make`, c.`full_name`;
END;

