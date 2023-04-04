#2405. Optimal Partition of String
#problem url: https://leetcode.com/problems/optimal-partition-of-string/
#leetcode profile url:  https://leetcode.com/jamsrandorj/
#solved by jama
class Solution:
    def __init__(self):
        pass
        
    def partitionString(self, s: str) -> int:
        seen = set()
        N = len(s)
        result = 0

        for i in range(N):
            if s[i] not in seen:
                seen.add(s[i])
                continue
            result += 1
            seen.clear()
            seen.add(s[i])

        return result + 1
        
test = Solution()
print(test.partitionString('abacaba'))   