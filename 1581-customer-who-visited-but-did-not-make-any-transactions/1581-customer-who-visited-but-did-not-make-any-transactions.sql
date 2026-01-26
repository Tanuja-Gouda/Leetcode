# Write your MySQL query statement below

-- select v.customer_id,count(*) as count_no_trans
-- from Visits v
--      left join Transactions t
--      on v.visit_id=t.visit_id
-- where t.transaction_id is null
-- group by v.customer_id;


-- optional 
select v.customer_id,count(*) count_no_trans
from Visits v
where not exists (
    select 1
    from Transactions t
    where v.visit_id=t.visit_id
)
group by v.customer_id;











-- SELECT v.customer_id,count(v.customer_id) as count_no_trans
-- FROM Visits v LEFT JOIN Transactions t ON v.visit_id=t.visit_id
-- WHERE t.transaction_id is null 
-- GROUP BY v.customer_id; 





















