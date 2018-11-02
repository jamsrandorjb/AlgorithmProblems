/**
 * problem url: https://www.hackerrank.com/challenges/weather-observation-station-12/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */


SELECT DISTINCT CITY FROM STATION WHERE SUBSTR(LOWER(CITY), -1, 1) NOT IN ('a', 'e', 'i', 'o', 'u')
AND SUBSTR(LOWER(CITY), 1, 1) NOT IN ('a', 'e', 'i', 'o', 'u');
/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
