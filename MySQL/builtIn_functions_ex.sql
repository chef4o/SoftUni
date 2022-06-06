-- Part I – Queries for SoftUni Database --
use `soft_uni`;
select * from `employees`;
select * from `towns`;

-- Find Names of All Employees by First Name --

select `first_name`, `last_name` from `employees`
where lower(`first_name`) like 'sa%'
order by `employee_id`; 

-- Find Names of All Employees by Last Name --

select `first_name`, `last_name` from `employees`
where lower(`last_name`) like '%ei%'
order by `employee_id`;

-- Find First Names of All Employees --

select `first_name` from `employees`
where `department_id` in (3, 10)
and year(`hire_date`) between 1995 and 2005 
order by `employee_id`;

-- Find All Employees Except Engineers --

select `first_name`, `last_name` from `employees`
where lower(`job_title`) not like '%engineer%'
order by `employee_id`;

-- Find Towns with Name Length --

select `name` from `towns`
where char_length(`name`) in (5, 6) 
order by `name`;

-- Find Towns Starting With --

select * from `towns`
where left(lower(`name`), 1) in ('m', 'k', 'b', 'e')
order by `name`;

-- Find Towns Not Starting With --

select * from `towns`
where substr(lower(`name`), 1, 1) not in ('r','b','d')
order by `name`;

-- Create View Employees Hired After 2000 Year --

create view `v_employees_hired_after_2000` as 
select `first_name`, `last_name` from `employees`
where year(`hire_date`) > 2000
order by `hire_date`;
select * from `v_employees_hired_after_2000`;

-- Length of Last Name --

select `first_name`, `last_name` from `employees`
where char_length(`last_name`) = 5
order by `employee_id`;

-- Part II – Queries for Geography Database --
use `geography`;
select * from `countries`;

-- Countries Holding 'A' 3 or More Times --

select `country_name`, `iso_code` from `countries`
where char_length(`country_name`) - char_length(replace(lower(`country_name`), 'a', '')) >= 3
order by `iso_code`;
-- or --
select `country_name`, `iso_code` from `countries`
where `country_name` like '%a%a%a%'
order by `iso_code`;

-- Mix of Peak and River Names --

select * from peaks;
select * from rivers;

select `peak_name`, 
		`river_name`, 
      lower(concat(`peak_name`, substr(`river_name`, 2))) as mix
from `peaks`, `rivers`
where right(lower(`peak_name`), 1) = left(lower(`river_name`), 1)
order by `mix`;

-- Part III – Queries for Diablo Database --
-- Games from 2011 and 2012 Year --

use `diablo`;
select * from `games`;

select `name`, date_format(`start`, '%Y-%m-%d') as `start` from `games`
where year(`start`) in (2011, 2012)
order by `start`, `name`
limit 50;

-- User Email Providers --

select * from `users`;

select `user_name`, substring(`email`, position('@' in `email`) + 1) as `Email Provider` 
from `users`
order by `Email Provider`, `user_name`;

-- Get Users with IP Address Like Pattern --

select `user_name`, `ip_address` from `users`
where `ip_address` like '___.1%.%.___'
order by `user_name`;

-- Show All Games with Duration and Part of the Day --

select * from games;

select `name` as `game`, 
	(case	when hour(`start`) between 0 and 11 then 'Morning'
			when hour(`start`) between 12 and 17 then 'Afternoon'
			else 'Evening'
	end) as `Part of the Day`,
   (case	when `duration` <= 3 then 'Extra Short'
			when `duration` <= 6 then 'Short'
			when `duration` <= 10 then 'Long'
			else 'Extra Long'
	end) as `Duration`
   from `games`;
   
   -- Part IV – Date Functions Queries --
   use `orders`;
   select * from `orders`;
   
   -- Orders Table --
   
   select `product_name`, `order_date`,
      date_add(`order_date`, interval 3 day) as `pay_due`, 
      date_add(`order_date`, interval 1 month) as `deliver_due`
	from `orders`;
	
   