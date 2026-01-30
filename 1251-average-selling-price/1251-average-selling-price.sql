# Write your MySQL query statement below

select p.product_id,ifnull(round(sum(p.price*u.units)/sum(u.units),2),0) average_price
from Prices p 
     left join UnitsSold u
     on p.product_id=u.product_id and u.purchase_date between p.start_date and p.end_date
group by p.product_id;













-- SELECT p.product_id, IFNULL(ROUND(SUM(p.price * us.units)/SUM(us.units),2),0) as average_price
-- FROM Prices as p LEFT JOIN UnitsSold as us ON p.product_id=us.product_id
--     --  AND us.purchase_date BETWEEN p.start_date and p.end_date
-- WHERE us.purchase_date BETWEEN p.start_date and p.end_date
-- GROUP BY p.product_id;

-- you cant use the where condition if udes then it works like INNNER JOIN  












