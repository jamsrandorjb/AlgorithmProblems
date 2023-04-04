import bisect
from typing import List

#2300. Successful Pairs of Spells and Potions
#problem url: https://leetcode.com/problems/successful-pairs-of-spells-and-potions/
#leetcode profile url:  https://leetcode.com/jamsrandorj/
#solved by jama
class Solution:
    def __init__(self):
        pass
        
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
            s = len(spells)
            p = len(potions)
            potions.sort()
            result = [None] * s
            for i, s in enumerate(spells):
                result[i] = p - bisect.bisect_left(potions, success/s)
            
            return result
        
test = Solution()
print(test.successfulPairs([5,1,3], [1,2,3,4,5], 7))

    

    