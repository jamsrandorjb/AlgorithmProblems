/**
 * problem url: https://www.hackerrank.com/challenges/weather-observation-station-2/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */


SELECT ROUND(SUM(s.lat_n), 2) lat, ROUND(SUM(s.long_w), 2) lon
FROM Station s;

/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
