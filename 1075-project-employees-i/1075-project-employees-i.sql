# Write your MySQL query statement below

select p.project_id,round(sum(e.experience_years)/count(e.employee_id),2) average_years
from Project p join Employee e
on p.employee_id=e.employee_id
group by p.project_id;













-- SELECT p.project_id, ROUND(AVG(e.experience_years),2) AS 'average_years'
-- FROM Project as p LEFT JOIN Employee as e ON p.employee_id=e.employee_id
-- GROUP BY p.project_id;











