/**
 * problem url: https://www.hackerrank.com/challenges/weather-observation-station-18/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */

SELECT ROUND((MAX(s.lat_n) - MIN(s.lat_n)) + (MAX(s.long_w) - MIN(s.long_w)), 4)
FROM Station s;
/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/