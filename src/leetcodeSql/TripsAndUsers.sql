/**
 * problem url: https://leetcode.com/problems/rising-temperature/
 * leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
**/


/* Write your PL/SQL query statement below */
SELECT 
	t.Request_at as 'Day',
	round(sum(CASE WHEN t.Status = 'completed' THEN 0 ELSE 1 END)/count(1), 2) as 'Cancellation Rate'
FROM Trips t, Users d, Users c
WHERE t.Driver_Id = d.Users_Id
	AND t.Client_Id = c.Users_Id
	AND d.Banned = 'No'
	AND c.Banned = 'No'
	AND t.Request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY t.Request_at;

            