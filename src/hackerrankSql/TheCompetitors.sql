/**
 * problem url: https://www.hackerrank.com/challenges/full-score/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */



/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
SELECT s.hacker_id, h.name--, SUM(d.score), COUNT(*) 
FROM    submissions s, 
        difficulty d, 
        challenges c, 
        hackers h
WHERE   s.challenge_id = c.challenge_id
        AND d.difficulty_level = c.difficulty_level
        AND s.score = d.score
        AND h.hacker_id = s.hacker_id
GROUP BY s.hacker_id, h.name 
HAVING(COUNT(s.hacker_id))>1
ORDER BY COUNT(s.hacker_id) DESC, s.hacker_id ASC;

        


