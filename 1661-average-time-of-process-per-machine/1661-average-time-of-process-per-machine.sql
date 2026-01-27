# Write your MySQL query statement below


select machine_id,round(avg(end-start),3) as processing_time
from (select machine_id,process_id,
             MAX(CASE WHEN activity_type='end' THEN timestamp END) AS 'end',
             MAX(CASE WHEN activity_type='start' THEN timestamp END )AS 'start'
      from Activity
      group by machine_id,process_id
      )t
group by machine_id;
    
    












-- SELECT a1.machine_id, round(avg(a2.timestamp-a1.timestamp),3) as 'processing_time'
-- -- SELECT a1.machine_id, round(sum(a2.timestamp-a1.timestamp)/COUNT(a1.process_id),3) as 'processing_time'
-- FROM Activity a1 JOIN Activity a2 ON a1.machine_id=a2.machine_id and a1.process_id=a2.process_id and a1.activity_type='start' and a2.activity_type='end'
-- GROUP BY a1.machine_id;












