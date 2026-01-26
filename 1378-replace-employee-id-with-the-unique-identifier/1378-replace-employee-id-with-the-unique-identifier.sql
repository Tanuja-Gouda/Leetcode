# Write your MySQL query statement below

select eu.unique_id, e.name
from Employees as e left join EmployeeUNI as eu on e.id=eu.id;












-- SELECT EU.unique_id AS unique_id, E.name AS name
-- FROM Employees as E LEFT JOIN EmployeeUNI AS EU ON E.id=EU.id;
