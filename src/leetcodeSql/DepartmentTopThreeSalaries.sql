/**
 * problem url: https://leetcode.com/problems/department-top-three-salaries/
 * leetcode profile url:  https://leetcode.com/jamsrandorj/
 * solved by jama
**/


/* Write your PL/SQL query statement below */
SELECT 
    d.Name AS 'Department', 
    e.Name AS 'Employee', 
    e.Salary 
FROM Employee AS e
INNER JOIN Department AS d ON e.DepartmentId = d.Id
LEFT JOIN Employee AS e2 ON e.DepartmentId = e2.DepartmentId AND e.Salary <= e2.Salary
GROUP BY e.Id
HAVING COUNT(DISTINCT e2.Salary) <= 3
ORDER BY e.DepartmentId, e.Salary DESC;