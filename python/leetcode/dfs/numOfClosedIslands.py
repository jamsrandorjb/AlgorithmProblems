#1254. Number of Closed Islands
#problem url: https://leetcode.com/problems/number-of-closed-islands/
#leetcode profile url:  https://leetcode.com/jamsrandorj/
#solved by jama
from typing import List

class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        R = len(grid)
        C = len(grid[0])

        used = [[False] * C for _ in range(R)]

        directions = [(1,0), (0,1), (-1, 0), (0,-1)]

        def traverse(x: int, y: int):
            if used[x][y]: 
                return

            used[x][y] = True
            for dx, dy in directions:
                nx, ny = x + dx, y + dy

                if nx >= 0 and nx < R and ny >= 0 and ny < C:
                    if grid[nx][ny] == 0:
                        traverse(nx, ny)
                else: 
                    nonlocal closed
                    closed = False

        islands = 0
        for x in range(R):
            for y in range(C):
                if used[x][y] or grid[x][y] != 0: 
                    continue
                closed = True
                traverse(x,y)
                if closed:
                    islands += 1

        return islands

test = Solution()
print(test.closedIsland([(1,1,1,1,1,1,1,0),(1,0,0,0,0,1,1,0),(1,0,1,0,1,1,1,0),(1,0,0,0,0,1,0,1),(1,1,1,1,1,1,1,0)]))   