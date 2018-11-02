/**
 * problem url: https://www.hackerrank.com/challenges/the-report/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */



/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
SELECT CASE WHEN g.grade < 8 THEN NULL ELSE s.Name END NAME,  g.grade GRADE, S.Marks MARK
FROM STUDENTS s, GRADES g
WHERE s.marks BETWEEN g.MIN_MARK AND g.Max_Mark
ORDER BY g.grade desc, s.name asc;


