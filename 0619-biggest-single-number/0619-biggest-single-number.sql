# Write your MySQL query statement below
SELECT MAX(NUM) 'num'
FROM MyNumbers
WHERE num IN (SELECT num
               FROM MyNumbers
               GROUP BY num
               HAVING COUNT(num)=1);