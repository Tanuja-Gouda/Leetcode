# Write your MySQL query statement below

select user_id,count(follower_id) as "followers_count"
from Followers
group by user_id
order by user_id;












-- SELECT user_id,COUNT(DISTINCT follower_id) AS 'followers_count'
-- FROM Followers 
-- GROUP BY user_id;












