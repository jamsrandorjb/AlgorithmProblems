#516. Longest Palindromic Subsequence
#problem url: https://leetcode.com/problems/longest-palindromic-subsequence/description/
#leetcode profile url:  https://leetcode.com/jamsrandorj/
#solved by jama
class Solution:
    def __init__(self):
        pass
        
    def longestPalindromeSubseq(self, s: str) -> int:
        N = len(s)
        cache = [[None] * N for _ in range(N)]
        has_cache = [[False] * N for _ in range(N)]
        def getLongest(left, right):
            if left > right: 
                return 0
            if left == right:
                return 1
            if has_cache[left][right]:
                return cache[left][right]
            best = 0
            if s[left] == s[right]:
                best = max(best, 2 + getLongest(left+1, right-1))
            best = max(best, getLongest(left + 1, right), getLongest(left, right-1))
            has_cache[left][right] = True
            cache[left][right] = best

            return best
        
        return getLongest(0, N-1)
        
test = Solution()
print(test.longestPalindromeSubseq('abac'))   