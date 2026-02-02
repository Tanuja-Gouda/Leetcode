# Write your MySQL query statement below

select 'Low Salary' as category, ifnull(count(case when income<20000 then 1 end),0) as accounts_count
from Accounts

union all

select 'Average Salary' as category, ifnull(count(case when income between 20000 and 50000 then 1 end),0) as accounts_count
from Accounts

union all

select 'High Salary' as category, ifnull(count(case when income>50000 then 1 end),0) as account_count
from Accounts;













-- SELECT 'Low Salary' AS category, COUNT(CASE WHEN income<20000 THEN 1 END) AS accounts_count
-- FROM Accounts

-- UNION ALL
-- SELECT 'Average Salary' AS category, COUNT(CASE WHEN income BETWEEN 20000 AND 50000 THEN 1 END) AS accounts_count
-- FROM Accounts

-- UNION ALL
-- SELECT 'High Salary' AS category, COUNT(CASE WHEN income>50000 THEN 1 END) AS accounts_count
-- FROM Accounts

