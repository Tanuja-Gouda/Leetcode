# Write your MySQL query statement below


select id,movie,description,rating
from Cinema
where id%2=1 and description != 'boring'
order by rating desc;










-- SELECT id,movie,description,rating
-- FROM Cinema
-- WHERE id%2=1 AND description != 'boring'
-- ORDER BY rating DESC;











