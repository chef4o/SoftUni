-- Find Book Titles --

select `title` from `books`
where `title` like 'The%'
order by id;

-- Replace Titles --

select replace(`title`, 'The', '***') as `title` from `books`
where `title` like 'The%';

-- Sum Cost of All Books --

select format(Sum(`cost`), 2) as sum from `books`;

-- Days Lived --

SELECT concat_ws(' ', `first_name`, `last_name`) as `Full Name`, 
		 datediff(`died`, `born`) as `Days Lived` 
       FROM `authors`;
       
-- Harry Potter Books --

select `title` from `books`
where `title` like '%Harry Potter%'
order by `id`;