class Solution:
    def isPowerOfTwo(self, n: int):
        """
        @param n: an integer
        @return: if n is a power of two
        """
        return not(n & (n - 1))
