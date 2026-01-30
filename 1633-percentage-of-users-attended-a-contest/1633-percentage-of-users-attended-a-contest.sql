# Write your MySQL query statement below

select contest_id, round(count(user_id) * 100/(select count(*) from Users),2) percentage
from Register
group by contest_id
order by percentage desc,contest_id asc;












-- SELECT r.contest_id, ROUND(COUNT(DISTINCT r.user_id) * 100 / (SELECT COUNT(*) FROM Users),2) AS percentage
-- FROM Users as u JOIN Register as r ON u.user_id=r.user_id
-- GROUP BY r.contest_id
-- ORDER BY percentage DESC,r.contest_id ASC; 












