#879. Profitable Schemes
#problem url: https://leetcode.com/problems/profitable-schemes/
#leetcode profile url:  https://leetcode.com/jamsrandorj/
#solved by jama

from typing import List

class Solution:
    def __init__(self):
        pass
        
    def profitableSchemes(self, n: int, minProfit: int, group: List[int], profit: List[int]) -> int:
        MOD = 10 ** 9 + 7
        M = len(group)

        has_cache = [[[False] * (minProfit + 1) for _ in range(M+1)] for _ in range(n+1)]
        cache = [[[None] * (minProfit + 1) for _ in range(M+1)] for _ in range(n+1)]

        def count(ppl_left, index, profit_left):
            if ppl_left < 0:
                return 0
            if profit_left < 0:
                profit_left = 0
            if index == M:
                if profit_left == 0:
                    return 1
                return 0

            if has_cache[ppl_left][index][profit_left]:
                return cache[ppl_left][index][profit_left]

            using_current_index = count(ppl_left-group[index], index+1, profit_left - profit[index])
            not_using_current_index = count(ppl_left, index+1, profit_left)

            has_cache[ppl_left][index][profit_left] = True
            cache[ppl_left][index][profit_left] = (using_current_index + not_using_current_index) % MOD

            return cache[ppl_left][index][profit_left]

        return count(n, 0, minProfit) % MOD
        
test = Solution()
print(test.profitableSchemes(5, 3, [2,2], [2, 3]))   