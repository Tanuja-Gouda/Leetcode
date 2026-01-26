-- # Write your MySQL query statement below

-- select DISTINCT author_id as id
-- from Views
-- where author_id=viewer_id
-- ORDER BY id;



-- optional
select author_id as id
from Views
where author_id=viewer_id
group by author_id
order by id;












-- SELECT DISTINCT author_id as id
-- FROM Views
-- WHERE author_id = viewer_id
-- -- GROUP BY author_id
-- ORDER BY id;