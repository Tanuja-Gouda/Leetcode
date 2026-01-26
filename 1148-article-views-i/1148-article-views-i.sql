-- # Write your MySQL query statement below

select DISTINCT author_id as id
from Views
where author_id=viewer_id
ORDER BY id;












-- SELECT DISTINCT author_id as id
-- FROM Views
-- WHERE author_id = viewer_id
-- -- GROUP BY author_id
-- ORDER BY id;