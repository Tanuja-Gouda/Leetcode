# Write your MySQL query statement below
select product_name,year,price
from Sales as s
     left join Product as p
     on s.product_id=p.product_id; 














-- SELECT p.product_name,s.year,s.price
-- FROM Sales as s LEFT JOIN Product as p On s.product_id=p.product_id;
