#1302. Deepest Leaves Sum
#problem url: https://leetcode.com/problems/deepest-leaves-sum/
#leetcode profile url:  https://leetcode.com/jamsrandorj/
#solved by jama
from typing import Optional

from base import TreeNode


class Solution:
    def deepestLeavesSum(self, root: Optional[TreeNode]) -> int:
        maxH = 0
        result = 0
        def getHeight(node: TreeNode, currentH: int):
            if not node: 
                return
            currentH += 1
            nonlocal maxH, result
            if currentH == maxH:
                result += node.val
            elif currentH > maxH: 
                maxH = currentH
                result = node.val
            if node.left:
                getHeight(node.left, currentH + 1)
            if node.right:
                getHeight(node.right, currentH + 1)

        getHeight(root, 0)
        return result

test = Solution()
root = TreeNode(1, TreeNode(2), TreeNode(3))
print(test.deepestLeavesSum(root))   