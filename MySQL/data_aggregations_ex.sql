use `gringotts`;
select * from `wizzard_deposits`;

-- Records' Count --

select count(*) from `wizzard_deposits`;

-- Longest Magic Wand --

select max(`magic_wand_size`) as `longest_magic_wand`
from `wizzard_deposits`;

-- Longest Magic Wand Per Deposit Groups --

select 
	`deposit_group`, 
   max(`magic_wand_size`) as `longest_magic_wand`
from `wizzard_deposits`
group by `deposit_group`
order by `longest_magic_wand`, `deposit_group`;

-- Smallest Deposit Group Per Magic Wand Size --

select `deposit_group`
from `wizzard_deposits`
group by `deposit_group`
order by avg(`magic_wand_size`)
limit 1;

-- Deposits Sum --

select 
	`deposit_group`, 
   sum(`deposit_amount`) as `total_sum`
from `wizzard_deposits`
group by `deposit_group`
order by `total_sum`;

-- Deposits Sum for Ollivander Family --

select 
	`deposit_group`, 
   sum(`deposit_amount`) as `total_sum`
from `wizzard_deposits`
where `magic_wand_creator` = 'Ollivander family'
group by `deposit_group`
order by `deposit_group`;

-- Deposits Filter --

select 
	`deposit_group`, 
   sum(`deposit_amount`) as `total_sum`
from `wizzard_deposits`
where `magic_wand_creator` = 'Ollivander family'
group by `deposit_group`
having `total_sum` < 150000
order by `total_sum` desc;

-- Deposit Charge --

select 
	`deposit_group`, 
   `magic_wand_creator`,
   min(`deposit_charge`) as `min_deposit_charge`
from `wizzard_deposits`
group by `deposit_group`, `magic_wand_creator`
order by `magic_wand_creator`, `deposit_group`;

-- Age Groups --

select 
	(case 
		when `age` <= 10 then '[0-10]'
		when `age` <= 20 then '[11-20]'
		when `age` <= 30 then '[21-30]'
		when `age` <= 40 then '[31-40]'
		when `age` <= 50 then '[41-50]'
		when `age` <= 60 then '[51-60]'
		else '[61+]'
   end) as `age_group`,
   count(`id`) as `wizard_count`
from `wizzard_deposits`
group by `age_group`
order by `wizard_count`;

-- First Letter --

select 
	left(`first_name`, 1) as `first_letter`
from `wizzard_deposits`
where `deposit_group` = 'Troll Chest'
group by `first_letter`
order by `first_letter`;

-- Average Interest -- 

select 
	`deposit_group`,
   `is_deposit_expired`,
   avg(`deposit_interest`) as `average_interest`
from `wizzard_deposits`
where date(`deposit_start_date`) > '1985-01-01'
group by `deposit_group`, `is_deposit_expired`
order by `deposit_group` desc, `is_deposit_expired`;

-- Employees Minimum Salaries --
use `soft_uni`;
select * from `employees`;

select 
	`department_id`,
	min(`salary`) as `minimum_salary`
from `employees`
where date(`hire_date`) > '2000-01-01'
group by `department_id`
having `department_id` in (2,5,7)
order by `department_id`;

-- Employees Average Salaries --

create table `high_paid_empl` as 
	select `department_id`, `salary`
	from `employees`
   where `salary` > 30000
		and `manager_id` != 42;

update `high_paid_empl`
set `salary` = `salary` + 5000
where `department_id` = 1;
   
select 
	`department_id`,
   avg(`salary`) as `avg_salary`
from `high_paid_empl`
group by `department_id`
order by `department_id`;

-- Employees Maximum Salaries --

select 
	`department_id`, 
	max(`salary`) as `max_salary`
from `employees`
group by `department_id`
having `max_salary` not between 30000 and 70000
order by `department_id`;

-- Employees Count Salaries --

select count(*) as '' from `employees`
where `manager_id` is null;

-- 3rd Highest Salary* --
select `department_id`,
					`salary`
from (select a.*, 
			ROW_NUMBER () OVER (PARTITION BY `department_id` ORDER BY `salary` desc) as num
			from (
					select 
					`department_id`,
					`salary`
					from `employees`
					group by `department_id` , `salary`
					) a
	 order by 1, 2
	 ) b
where num = 3
order by `department_id`; 

select distinct `department_id`,
		`salary`
from (select `department_id`,
				`salary`,
				DENSE_RANK() OVER (PARTITION BY `department_id` order by `salary` desc) as num
		from `employees`
		-- order by 1, 2
      ) a
where num = 3
order by `department_id`;

select  `department_id`,
		`salary`
from (select `department_id`,
				`salary`,
				DENSE_RANK() OVER (PARTITION BY `department_id` order by `salary` desc) as num, 
            ROW_NUMBER () OVER (PARTITION BY `department_id`, `salary`) as num2
		from `employees`
      ) a
where num = 3 and num2 = 1
order by `department_id`;

select a1.`department_id`,
		(select distinct a2.`salary` from `employees` as a2
			where a2.`department_id` = a1.`department_id`
         order by a2.`salary` desc
         limit 1 offset 2) as `third_highest_salary`
from `employees` as a1
group by a1.`department_id`
having `third_highest_salary` is not null
order by a1.`department_id`;

-- Salary Challenge** --

select b1.`first_name`, b1.`last_name`, b1.`department_id`
from `employees` as b1
where b1.`salary` > (select avg(b2.`salary`)
							from `employees` as b2
							group by b2.`department_id`
                     having b1.`department_id` = b2.`department_id`
							)
order by b1.`department_id`, b1.`employee_id`
limit 10;

-- Departments Total Salaries --

select b1.`first_name`, b1.`last_name`, b1.`department_id`
from `employees` as b1
where b1.`salary` > (
							select avg(b2.`salary`)
							from `employees` as b2
                     where b1.`department_id` = b2.`department_id`
                     )
order by b1.`department_id`, b1.`employee_id`
limit 10;

select `first_name`,`last_name`,`department_id`
from `employees` as c1
where (case when (
						select avg(`salary`) from `employees` as c2
						where c1.`department_id` = c2.`department_id`
                  ) < c1.`salary` then 1
				else 0
				end) = 1
order by `department_id`,`employee_id`
limit 10;

select `first_name`,`last_name`,`department_id` from
		(
      select `employee_id`, 
				 `first_name`,
             `last_name`,
             `department_id`,
             `salary`,
             avg(`salary`) OVER (PARTITION BY `department_id`) as `avg_salary` 
		from `employees`
      ) a
where `salary` > `avg_salary`
order by `department_id`, `employee_id`
limit 10;

 