/**
 * problem url: https://www.hackerrank.com/challenges/the-pads/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */



SELECT Name||'('||SUBSTR(Occupation, 1, 1)||')' FROM OCCUPATIONS
ORDER BY Name;
SELECT 'There are a total of '||COUNT(Occupation)||' '||LOWER(Occupation)||'s.'
FROM OCCUPATIONS
GROUP BY Occupation
ORDER BY COUNT(Occupation), Occupation ASC;




