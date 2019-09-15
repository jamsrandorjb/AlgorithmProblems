/**
 * problem url: https://leetcode.com/problems/swap-salary/
 * leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
**/


/* Write your PL/SQL query statement below */
UPDATE salary s
SET s.sex = CASE 
            WHEN s.sex = 'm' THEN 'f' 
            WHEN s.sex = 'f' THEN 'm' END;
            