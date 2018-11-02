/**
 * problem url: https://www.hackerrank.com/challenges/placements/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */



SELECT s.name FROM Students s
INNER JOIN Friends f ON f.id = s.id
INNER JOIN Packages p1 ON f.id = p1.id
INNER JOIN Packages p2 ON f.friend_id = p2.id
WHERE p1.salary<p2.salary
ORDER BY p2.salary;
/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
