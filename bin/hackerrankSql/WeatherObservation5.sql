/**
 * problem url: https://www.hackerrank.com/challenges/weather-observation-station-5/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */

SELECT * FROM (
                SELECT CITY, MIN(LENGTH(CITY)) FROM STATION 
                GROUP BY CITY
                ORDER BY LENGTH(CITY), CITY ) D 
                WHERE ROWNUM =1;
SELECT * FROM (
                SELECT CITY, MAX(LENGTH(CITY)) FROM STATION 
                GROUP BY CITY
                ORDER BY LENGTH(CITY) DESC, CITY DESC) S 
                WHERE ROWNUM =1;
/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
