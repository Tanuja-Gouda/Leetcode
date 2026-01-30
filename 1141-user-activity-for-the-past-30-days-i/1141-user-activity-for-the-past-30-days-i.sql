# Write your MySQL query statement below

select activity_date as day, count(distinct user_id) as active_users
from Activity
where activity_date between '2019-06-28' and '2019-07-27'
group by activity_date;












-- SELECT activity_date AS 'day', COUNT(DISTINCT user_id) AS 'active_users'
-- FROM (SELECT user_id,activity_date FROM Activity WHERE activity_date > '2019-06-27' AND activity_date <= '2019-07-27') t2
-- GROUP BY t2.activity_date;
-- FROM Activity
-- WHERE activity_date BETWEEN '2019-06-28' AND '2019-07-27'
-- GROUP BY activity_date;












