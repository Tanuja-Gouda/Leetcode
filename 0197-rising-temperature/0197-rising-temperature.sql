# Write your MySQL query statement below

SELECT w1.id
FROM Weather w1
JOIN Weather w2
  ON w1.recordDate = DATE_ADD(w2.recordDate, INTERVAL 1 DAY)
WHERE w1.temperature > w2.temperature;















-- SELECT id
-- FROM (SELECT id,temperature,LAG(temperature) over() AS preTemp 
--       FROM Weather) new
-- WHERE temperature > preTemp;





