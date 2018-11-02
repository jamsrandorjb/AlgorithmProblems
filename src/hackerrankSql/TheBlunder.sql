/**
 * problem url: https://www.hackerrank.com/challenges/the-blunder/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */



SELECT CEIL(AVG(salary) - AVG(REPLACE(salary, 0, ''))) 
FROM Employees;






/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/

