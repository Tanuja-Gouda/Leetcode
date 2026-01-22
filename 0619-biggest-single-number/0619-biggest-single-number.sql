# Write your MySQL query statement below
SELECT MAX(num) 'num'
-- FROM MyNumbers
-- WHERE num IN 
FROM (SELECT num
               FROM MyNumbers
               GROUP BY num
               HAVING COUNT(num)=1) t1 ;













