-- Mountains and Peaks --
use `camp`;
select * from `vehicles`;

create table `mountains` (
	`id` int primary key auto_increment, 
   `name` varchar(50) not null
   );
   
create table `peaks` (
		`id` int auto_increment,
		`name` varchar(50) not null,
      `mountain_id` int,
      primary key (`id`),
      constraint `fk_peaks_mountains` foreign key (`mountain_id`) references `mountains`(`id`)
);

-- Trip Organization --

select * from `campers`;
select * from `vehicles`;

select v.`driver_id`, 
		 v.`vehicle_type`, 
       (select concat_ws(' ', d.`first_name`, d.`last_name`)
			from `campers` d 
         where d.`id` = v.`driver_id`) as `driver_name`
from `vehicles` v;

select v.`driver_id`, v.`vehicle_type`, concat_ws(' ', c.`first_name`, c.`last_name`)
from `vehicles` v 
join `campers` c on 
v.`driver_id`  = c.`id`;

-- SoftUni Hiking --

select * from `routes`;
select * from `campers`;

select r.`starting_point` as `route_starting_point`,
		 r.`end_point` as `route_ending_point`,
		 r.`leader_id`,
		 (select concat_ws(' ', c.`first_name`, c.`last_name`)
					from `campers` c
					where r.`leader_id` = c.`id`) as `leader_name`
from `routes` r;

select r.`starting_point` as `route_starting_poijnt`,
		 r.`end_point` as `route_ending_point`,
       r.`leader_id`,
       concat_ws(' ', c.`first_name`, c.`last_name`) as `leader_name`
from `routes` r
join `campers` c on r.`leader_id` = c.`id`;

-- Delete Mountains --
drop TABLES `mountains`, `peaks`;

create table `mountains` (
	`id` int primary key auto_increment, 
   `name` varchar(50) not null
   );
   
create table `peaks` (
		`id` int auto_increment,
		`name` varchar(50) not null,
      `mountain_id` int,
      primary key (`id`),
      constraint `fk_peaks_mountains` foreign key (`mountain_id`) references `mountains`(`id`)
      on delete cascade
);

-- Project Management DB* --

create schema `mpdb`;
use `mpdb`;

create table `clients` (
	`id` int primary key auto_increment,
   `client_name` varchar(100)
);

create table `projects` (
	`id` int primary key auto_increment,
   `client_id` int,
   `project_lead_id` int
);

create table `employees` (
	`id` int primary key auto_increment,
   `first_name` varchar(30),
   `last_name` varchar(30),
   `project_id` int
);

alter table `projects`
add constraint `fk_projects_clients` foreign key (`client_id`) references `clients`(`id`),
add constraint `fk_projects_employees` foreign key (`project_lead_id`) references `employees`(`id`);

alter table `employees`
add constraint `fk_empoyees_projects` foreign key (`project_id`) references `projects`(`id`);

