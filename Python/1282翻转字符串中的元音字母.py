class Solution:
    def reverseVowels(self, s: str):
        """
        @param s: a string
        @return: reverse only the vowels of a string
        """
        vowels = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']
        ls = list(s)
        l, r = 0, len(ls) - 1
        while l < r:
            while l < r and ls[l] not in vowels:
                l += 1
            while l < r and ls[r] not in vowels:
                r -= 1
            ls[l], ls[r] = ls[r], ls[l]
            l += 1
            r -= 1
        return "".join(ls)

from TestUtil import Test
if __name__ == '__main__':
    test = Test(Solution())
    cases = ["hello", "lintcode"]
    test.run(cases, 'reverseVowels')

