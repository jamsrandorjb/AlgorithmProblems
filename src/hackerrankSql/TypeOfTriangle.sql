/**
 * problem url: https://www.hackerrank.com/challenges/what-type-of-triangle/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */

SELECT 
CASE WHEN A + B > C THEN 
        CASE WHEN A = B AND B = C THEN 'Equilateral' 
        WHEN A = B OR B = C OR A = C THEN 'Isosceles' 
        WHEN A != B OR B != C OR A != C THEN 'Scalene' END 
ELSE 'Not A Triangle' END FROM TRIANGLES;

/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
