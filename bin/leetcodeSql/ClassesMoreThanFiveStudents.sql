/**
 * problem url: https://leetcode.com/problems/classes-more-than-5-students/
 * leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
**/


/* Write your PL/SQL query statement below */
SELECT c.class as "class" 
FROM courses c 
GROUP BY c.class
HAVING COUNT(DISTINCT c.student) >= 5;
            