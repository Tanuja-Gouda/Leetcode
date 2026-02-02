# Write your MySQL query statement below

select q1.person_name
from Queue q1 join Queue q2
     on q2.turn <= q1.turn
group by q1.turn
having sum(q2.weight)<=1000
order by sum(q2.weight) desc
limit 1;












-- SELECT q1.person_name
-- FROM Queue q1 JOIN Queue q2 ON q1.turn >= q2.turn
-- GROUP BY q1.turn
-- HAVING SUM(q2.weight) <= 1000
-- ORDER BY SUM(q2.weight) DESC
-- LIMIT 1












