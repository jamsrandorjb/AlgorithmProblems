/**
 * problem url: https://leetcode.com/problems/human-traffic-of-stadium/
 * leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
**/


/* Write your PL/SQL query statement below */
SELECT DISTINCT t1.*
FROM stadium t1, stadium t2, stadium t3
WHERE t1.people >= 100 AND t2.people >= 100 AND t3.people >= 100
AND
(
	(t1.id - t2.id = 1 AND t1.id - t3.id = 2 AND t2.id - t3.id =1)  -- t1, t2, t3
    OR
    (t2.id - t1.id = 1 AND t2.id - t3.id = 2 AND t1.id - t3.id =1) -- t2, t1, t3
    OR
    (t3.id - t2.id = 1 AND t2.id - t1.id =1 AND t3.id - t1.id = 2) -- t3, t2, t1
)
ORDER BY t1.id;
            