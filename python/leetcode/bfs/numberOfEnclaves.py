#1020. Number of Enclaves
#problem url: https://leetcode.com/problems/number-of-enclaves/
#leetcode profile url:  https://leetcode.com/jamsrandorj/
#solved by jama

import collections
from typing import List

class Solution:
    def numEnclaves(self, grid: List[List[int]]) -> int:
        R = len(grid)
        C = len(grid[0])
        directions = [(1,0), (0,1), (-1,0), (0,-1)]
        used = [[False] * C for _ in range(R)]
        def bfs(x, y):
            q = collections.deque()
            def enqueue (x,y):
                used[x][y] = True
                q.append((x,y))
            enqueue(x,y)
            coveredArea = 0
            reached = False
            while len(q) > 0:
                cx, cy = q.popleft()
                coveredArea += 1
                for dx, dy in directions:
                    nx, ny = cx + dx, cy + dy
                    if 0 <= nx < R and 0 <= ny < C:
                        if not used[nx][ny] and grid[nx][ny] == 1:
                            enqueue(nx, ny)
                    else:
                        reached = True
            if reached: 
                return 0
            return coveredArea

        area = 0
        for x in range(R):
            for y in range(C):
                if used[x][y] or grid[x][y] == 0:
                    continue
                area += bfs(x,y)
        
        return area

test = Solution()
print(test.numEnclaves([(0,0,0,0),(1,0,1,0),(0,1,1,0),(0,0,0,0)]))   