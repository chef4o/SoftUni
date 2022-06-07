-- Departments Info --
select * from `employees`;

select `department_id`, count( distinct `id`) as `Number of employees` from `employees`
group by `department_id`;

-- Average Salary -- 

select 
	`department_id`, 
	round(avg(`salary`), 2) as `Average Salary` 
from `employees`
group by `department_id`;

-- Min Salary --

select 
	`department_id`, 
   min(`salary`) as `Min Salary`
from `employees`
group by `department_id`
having min(`salary`) > 800;

-- Appetizers Count --
select * from `products`;

select count(*) from `products`
where `price` > 8
group by `category_id`
having `category_id` = 2;

-- Menu Pricesss --

select 
	`category_id`,
   round(avg(`price`), 2) as `Average Price`, 
   round(min(`price`), 2) as `Cheapest Product`,
   round(max(`price`), 2) as `Most Expensive Product`
from `products`
group by `category_id`
order by `category_id`;