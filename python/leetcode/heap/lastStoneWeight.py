#1046. Last Stone Weight
#problem url: https://leetcode.com/problems/last-stone-weight/
#leetcode profile url:  https://leetcode.com/jamsrandorj/
#solved by jama
import heapq
from typing import List


class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        heap = [-s for s in stones]
        heapq.heapify(heap)
        while len(heap) > 1:
            l1 = heapq.heappop(heap)
            l2 = heapq.heappop(heap)
            if l1 != l2:
                heapq.heappush(heap, -abs(l2 - l1))
        
        if len(heap) == 1:
            return -heap[0]

        return 0
        
test = Solution()
print(test.lastStoneWeight([2,7,4,1,8,1]))
print(test.lastStoneWeight([1]))