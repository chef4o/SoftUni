-- Employees Without Project --

select distinct e.`employee_id`, e.`first_name`
from `employees` e
left join `employees_projects` ep
using (`employee_id`)
where ep.`project_id` is null
order by `employee_id` desc
limit 3;
