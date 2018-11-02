/**
 * problem url: https://www.hackerrank.com/challenges/revising-the-select-query/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */



/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
SELECT c.Name FROM City c WHERE c.CountryCode = 'USA' AND c.Population > 120000