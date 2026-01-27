# Write your MySQL query statement below

select w1.id
from Weather w1 
     join Weather w2 
     on w1.recordDate = date_add(w2.recordDate, interval 1 day)
where w1.temperature>w2.temperature;















-- SELECT id
-- FROM (SELECT id,temperature,LAG(temperature) over() AS preTemp 
--       FROM Weather) new
-- WHERE temperature > preTemp;





