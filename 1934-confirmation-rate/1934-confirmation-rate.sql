# Write your MySQL query statement below


select s.user_id,round(ifnull(sum(c.action='confirmed')/count(action),0),2) confirmation_rate
from Signups s
     left join Confirmations c
     on s.user_id=c.user_id
group by s.user_id;












-- SELECT s.user_id, round(COUNT(CASE WHEN c.action='confirmed' THEN c.user_id END )/count(s.user_id),2) as 'confirmation_rate'
-- FROM Signups s LEFT JOIN Confirmations c ON s.user_id=c.user_id
-- GROUP BY s.user_id;












