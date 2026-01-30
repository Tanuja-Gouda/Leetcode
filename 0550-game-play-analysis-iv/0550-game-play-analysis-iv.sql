# Write your MySQL query statement below
select round(count(distinct a1.player_id)/(select count(distinct player_id) from Activity),2) as fraction
from (select player_id, min(event_date) as first_login
      from Activity
      group by player_id
      ) a1
      join Activity a2
      on a1.player_id=a2.player_id
      and a2.event_date=date_add(a1.first_login,interval 1 day);














-- SELECT ROUND(COUNT(DISTINCT a1.player_id)/(SELECT COUNT(DISTINCT player_id) FROM Activity),2) AS 'fraction'
-- FROM (SELECT player_id, MIN(event_date) AS 'first_login'
--       FROM Activity 
--       GROUP BY player_id) a1

--       JOIN Activity As a2 ON a1.player_id = a2.player_id
--       AND a2.event_date=DATE_ADD(a1.first_login, INTERVAL 1 DAY);












      