/**
 * problem url: https://www.hackerrank.com/challenges/weather-observation-station-15/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */

SELECT ROUND(s1.long_w, 4)
FROM Station s1, (SELECT MAX(s.lat_n) lat_nn
                        FROM Station s
                        WHERE s.lat_n < 137.2345) s2
WHERE s1.lat_n = s2.lat_nn;

/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
