# Write your MySQL query statement below

select max(num) as num
from (select num
      from MyNumbers
      group by num
      having count(*)=1) t;













-- SELECT MAX(num) 'num'
-- FROM MyNumbers
-- WHERE num IN (SELECT num
--                FROM MyNumbers
--                GROUP BY num
--                HAVING COUNT(num)=1) t1 ;













