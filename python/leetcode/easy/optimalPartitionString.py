#2405. Optimal Partition of String
#problem url: https://leetcode.com/problems/optimal-partition-of-string/
#leetcode profile url:  https://leetcode.com/jamsrandorj/
#solved by jama
class Solution:
    def __init__(self):
        pass
        
    def partitionString(self, s: str) -> int:
        seen = set()
        result = 0

        for c in s:
            if c in seen:
                result += 1    
                seen.clear()
            seen.add(c)

        return result + 1 #the last set of chars
        
test = Solution()
print(test.partitionString('abacaba'))   