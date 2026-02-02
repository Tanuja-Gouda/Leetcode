# Write your MySQL query statement below

select x,y,z,(case when x+y>z and y+z>x and x+z>y then 'Yes' else 'No' end) as triangle
from Triangle;














-- SELECT x,y,z,(CASE WHEN x+y>z AND x+z>y AND y+z>x THEN 'Yes' ELSE 'No' END) 'triangle'
-- FROM Triangle;













