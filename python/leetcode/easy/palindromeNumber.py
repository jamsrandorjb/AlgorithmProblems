#9. Palindrome Number
#problem url: https://leetcode.com/problems/palindrome-number/
#leetcode profile url:  https://leetcode.com/jamsrandorj/
#solved by jama
class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0 :
            return False
        original = x
        reverse = 0
        while x != 0:
            reverse = reverse*10 + x%10
            x = x//10
            
        return reverse == original
        
test = Solution()
print(test.isPalindrome(121))
print(test.isPalindrome(1210))