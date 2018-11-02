/**
 * problem url: https://www.hackerrank.com/challenges/challenges/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */



SELECT h.hacker_id, h.name, COUNT(c.hacker_id)
FROM hackers h, challenges c
WHERE h.hacker_id = c.hacker_id
GROUP BY h.hacker_id, h.name
HAVING COUNT(c.hacker_id) not in
(
    SELECT DISTINCT COUNT(hacker_id) from Challenges 
    WHERE hacker_id <> h.hacker_id 
    GROUP BY hacker_id
    HAVING COUNT(hacker_id) < 
    (
        SELECT MAX(challenge_count) 
        FROM (
                SELECT COUNT(b.challenge_id) challenge_count
                FROM Challenges b 
                GROUP BY b.hacker_id
        )
    )
)
ORDER BY COUNT(c.challenge_id) DESC, h.hacker_id ASC;







