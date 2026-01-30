# Write your MySQL query statement below

select teacher_id,count(distinct subject_id) as cnt
from Teacher
group by teacher_id;












-- SELECT teacher_id, COUNT(DISTINCT subject_id) 'cnt'
-- FROM Teacher
-- GROUP BY teacher_id;












