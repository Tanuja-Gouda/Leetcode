# Write your MySQL query statement below


select employee_id
from Employees
where salary<30000 and manager_id is not null and manager_id not in (select employee_id
                         from Employees 
                         )
order by employee_id;












-- SELECT employee_id
-- FROM Employees
-- WHERE salary<30000 AND manager_id NOT IN (SELECT employee_id
--                          FROM Employees)
-- ORDER BY employee_id;