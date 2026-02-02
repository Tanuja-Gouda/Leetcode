# Write your MySQL query statement below

-- select class
-- from Courses
-- group by class
-- having count(student) >= 5;


select distinct class
from (select class,
      count(student) over(partition by class) as std_count
      from Courses)t
where std_count>=5;









-- SELECT class
-- FROM Courses 
-- GROUP BY class
-- HAVING COUNT(student) >= 5 ;












