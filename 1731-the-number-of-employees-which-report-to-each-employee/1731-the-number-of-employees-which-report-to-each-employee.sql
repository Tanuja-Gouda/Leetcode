# Write your MySQL query statement below


select e1.employee_id,e1.name,count(e2.employee_id) as 'reports_count',round(avg(e2.age)) as average_age
from Employees as e1 
     join Employees as e2
     on e1.employee_id = e2.reports_to
group by e1.employee_id
order by e1.employee_id;












-- SELECT e1.employee_id,e1.name,COUNT(e1.employee_id) 'reports_count',ROUND(AVG(e2.age)) 'average_age'
-- FROM Employees e1 JOIN Employees e2 ON e1.employee_id=e2.reports_to
-- GROUP BY e1.employee_id
-- ORDER BY e1.employee_id;












