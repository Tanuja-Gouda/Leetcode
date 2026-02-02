# Write your MySQL query statement below

select distinct num as ConsecutiveNums
from (select id,num,lag(num,1) over() as prev1, lag(num,2) over() as prev2
      from Logs) t
where num=prev1 and num=prev2;













-- SELECT DISTINCT num AS ConsecutiveNums
-- FROM (SELECT num,
--              LAG(num,1) OVER() AS prev1,
--              LAG(num,2) OVER() AS prev2
--       FROM Logs
--      ) t1
-- WHERE num=prev1 AND num=prev2;












