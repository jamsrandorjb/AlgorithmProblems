/**
 * problem url: https://www.hackerrank.com/challenges/the-company/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */



SELECT  c.company_code, 
        c.founder, 
        COUNT(DISTINCT l.lead_manager_code),
        COUNT(DISTINCT s.senior_manager_code),
        COUNT(DISTINCT m.manager_code),
        COUNT(DISTINCT e.employee_code)
FROM company c, lead_manager l, senior_manager s, manager m, employee e 
WHERE l.company_code = c.company_code
    AND s.lead_manager_code = l.lead_manager_code
    AND m.senior_manager_code = s.senior_manager_code  
    AND e.manager_code = m.manager_code
GROUP BY c.company_code, c.founder
ORDER BY c.company_code;






/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/

