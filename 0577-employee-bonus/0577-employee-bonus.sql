# Write your MySQL query statement below

select e.name,b.bonus
from Employee e
     left join Bonus b
     on e.empId=b.empId
where b.bonus<1000 or b.bonus is null;












-- SELECT e.name,b.bonus
-- FROM Employee as e LEFT JOIN Bonus as b ON e.empId=b.empId
-- WHERE b.bonus<1000 OR b.bonus is null;
















