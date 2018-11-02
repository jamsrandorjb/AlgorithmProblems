/**
 * problem url: https://www.hackerrank.com/challenges/binary-search-tree-1/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */



/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
SELECT b.N, CASE 
        WHEN b.P is null THEN 'Root'
        WHEN (SELECT COUNT(*) FROM BST b1 WHERE b1.P = b.N) = 0 THEN 'Leaf'
        ELSE 'Inner' END
FROM BST b
ORDER BY b.N;






