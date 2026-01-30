# Write your MySQL query statement below

select product_id,year as first_year,quantity,price
from Sales
where (product_id,year) in (select product_id,min(year) as 'first_year'
                      from Sales
                      group by product_id);









-- SELECT product_id,year 'first_year',quantity,price
-- FROM Sales
-- WHERE (product_id,year) IN (SELECT product_id,MIN(year) AS 'first_year' 
--                             FROM Sales 
--                             GROUP BY product_id );












