/**
 * problem url: https://www.hackerrank.com/challenges/weather-observation-station-19/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */

SELECT ROUND( 
        SQRT( 
            POWER(MIN(s.lat_n) - MAX(s.lat_n), 2) + 
            POWER(MIN(s.long_w) - MAX(s.long_w), 2) 
            ) , 4 )
FROM Station s;
/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/