/**
 * problem url: https://www.hackerrank.com/challenges/draw-the-triangle-1/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */


SELECT RPAD('*',LEVEL*2,' *')
  FROM dual
       CONNECT BY LEVEL <=20
ORDER BY 1 DESC;
