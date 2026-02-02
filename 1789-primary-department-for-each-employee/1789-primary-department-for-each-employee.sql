# Write your MySQL query statement below

select employee_id,department_id
from Employee 
where primary_flag='Y'
      or 
      employee_id in (select employee_id
                      from Employee
                      group by employee_id
                      having count(department_id)=1);













-- SELECT employee_id,department_id
-- FROM Employee
-- WHERE primary_flag='Y' OR 
--       employee_id IN (SELECT employee_id
--                       FROM Employee 
--                       GROUP BY employee_id
--                       HAVING COUNT(Employee_id)=1);












                      