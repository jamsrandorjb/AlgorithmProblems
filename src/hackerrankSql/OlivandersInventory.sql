/**
 * problem url: https://www.hackerrank.com/challenges/harry-potter-and-wands/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */


SELECT w.id, wp.age, w.coins_needed, w.power 
FROM Wands w, Wands_Property wp
WHERE w.code=wp.code 
    AND wp.is_evil = 0 
    AND w.coins_needed =(
        SELECT MIN(w1.coins_needed) FROM Wands w1, Wands_Property wp1 
        WHERE w1.code=wp1.code AND wp1.age=wp.age AND w1.power=w.power) 
ORDER BY w.power DESC, wp.age DESC;

