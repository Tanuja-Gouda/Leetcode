# Write your MySQL query statement below
SELECT EU.unique_id AS unique_id, E.name AS name
FROM Employees as E LEFT JOIN EmployeeUNI AS EU ON E.id=EU.id;
