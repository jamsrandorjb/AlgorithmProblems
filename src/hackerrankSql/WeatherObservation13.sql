/**
 * problem url: https://www.hackerrank.com/challenges/weather-observation-station-13/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */

SELECT ROUND(SUM(s.lat_n), 4)
FROM Station s
WHERE s.lat_n > 38.7880 
    AND s.lat_n < 137.2345;
