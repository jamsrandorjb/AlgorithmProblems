import bisect
from typing import List

#881. Boats to Save People
#problem url: https://leetcode.com/problems/boats-to-save-people/
#hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb
#solved by jama
class Solution:
    def __init__(self):
        pass
        
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        N = len(people)
        people.sort()
        count = 0
        left = 0
        right = N - 1
        while left < right:
            if people[left] + people[right] <= limit:
                left += 1
                right -= 1
            else:
                right -= 1
            count += 1
        if left == right:
            count += 1
            
        return count
        
test = Solution()
print(test.numRescueBoats([3,5,3,4], 5))   