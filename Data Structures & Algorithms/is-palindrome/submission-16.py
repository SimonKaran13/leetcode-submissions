class Solution:
    def isPalindrome(self, s: str) -> bool:
        
        s0 = ''.join(char.lower() for char in s if char.isalnum())

        if len(s0) == 1:
            return True

        for i in range(len(s0) // 2):
            j = len(s0) - 1 - i
            if s0[i] != s0[j]:
                return False

        return True
        