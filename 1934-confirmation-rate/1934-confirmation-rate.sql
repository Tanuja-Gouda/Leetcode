# Write your MySQL query statement below
SELECT s.user_id, round(COUNT(CASE WHEN c.action='confirmed' THEN c.user_id END )/count(s.user_id),2) as 'confirmation_rate'
FROM Signups s LEFT JOIN Confirmations c ON s.user_id=c.user_id
GROUP BY s.user_id;
