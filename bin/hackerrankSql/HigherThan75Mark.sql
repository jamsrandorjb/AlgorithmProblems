/**
 * problem url: https://www.hackerrank.com/challenges/more-than-75-marks/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */


/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
SELECT s.Name FROM STUDENTS s
WHERE s.Marks > 75
ORDER BY SUBSTR(s.NAME, -3), s.ID;