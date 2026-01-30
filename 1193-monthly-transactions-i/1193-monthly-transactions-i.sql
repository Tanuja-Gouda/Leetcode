# Write your MySQL query statement below

select date_format(trans_date,'%Y-%m') as month,
       country,
       count(*) as trans_count,
       sum(state ='approved') approved_count,
       sum(amount) as trans_total_amount,
       sum(case when state='approved' then amount else 0 end) as approved_total_amount
from Transactions
group by country,date_format(trans_date,'%Y-%m');














-- SELECT DATE_FORMAT(trans_date,'%Y-%m') AS 'month',
--        country,
--        COUNT(*) AS 'trans_count',
--        SUM(CASE WHEN state='approved' THEN 1 ELSE 0 END) AS 'approved_count',
--        SUM(amount) AS 'trans_total_amount',
--        SUM(CASE WHEN state='approved' THEN amount ELSE 0 END) AS 'approved_total_amount'
-- FROM Transactions
-- GROUP BY country,DATE_FORMAT(trans_date,'%Y-%m');












