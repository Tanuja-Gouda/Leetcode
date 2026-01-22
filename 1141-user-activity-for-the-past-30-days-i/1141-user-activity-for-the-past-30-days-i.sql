# Write your MySQL query statement below
SELECT activity_date AS 'day', COUNT(DISTINCT user_id) AS 'active_users'
-- FROM (SELECT user_id,activity_date FROM Activity WHERE activity_date > '2019-06-27' AND activity_date <= '2019-07-27') t2
-- GROUP BY t2.activity_date;
FROM Activity
WHERE activity_date > '2019-06-27' AND activity_date <= '2019-07-27'
GROUP BY activity_date;












