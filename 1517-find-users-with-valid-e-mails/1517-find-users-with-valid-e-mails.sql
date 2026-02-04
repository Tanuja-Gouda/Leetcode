# Write your MySQL query statement below

select user_id,name,mail
from Users
where mail regexp '^[A-Za-z][A-Za-z0-9._-]*@leetcode\\.com$'
      and mail like binary '%@leetcode.com';












-- SELECT 
--     user_id, 
--     name, 
--     mail
-- FROM 
--     users
-- WHERE 
--     mail REGEXP '^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode\\.com$' 
--     AND mail LIKE BINARY '%@leetcode.com';
