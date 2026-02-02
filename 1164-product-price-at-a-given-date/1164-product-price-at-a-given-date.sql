# Write your MySQL query statement below

select p.product_id,coalesce((select pr.new_price
                             from Products pr
                             where p.product_id=pr.product_id
                                   and pr.change_date<='2019-08-16'
                             order by pr.change_date desc limit 1),10) as price
from (select distinct product_id
      from Products) p;











-- SELECT p.product_id,COALESCE((SELECT pr.new_price
--                               FROM Products pr
--                               WHERE p.product_id=pr.product_id
--                                     AND pr.change_date<='2019-08-16'
--                               ORDER BY pr.change_date DESC LIMIT 1),10) AS price
-- FROM (SELECT DISTINCT product_id
--       FROM Products
--       ) AS p;




