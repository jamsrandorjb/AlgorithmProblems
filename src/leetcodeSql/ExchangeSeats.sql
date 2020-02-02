/**
 * problem url: https://leetcode.com/problems/exchange-seats/
 * leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
**/


/* Write your PL/SQL query statement below */
SELECT
	s1.id, 
	s2.student
FROM seat s1, seat s2
WHERE (CASE WHEN s1.id % 2 = 1 AND s1.id = (SELECT MAX(id) FROM seat) 
				THEN s1.id = s2.id
			WHEN s1.id % 2 = 1 THEN
				THEN s1.id = s2.id-1
			ELSE s1.id = s2.id + 1 END)
ORDER BY s1.id;
            