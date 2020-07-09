import math

class Solution:
    def isPowerOfThree(self, n):
        """
        @param n: an integer
        @return: if n is a power of three
        """
        if n < 1:
            return False
        return (math.log(n) / math.log(3) % 1) == 0

from TestUtil import Test
if __name__ == '__main__':
    test = Test(Solution())
    cases = [9]
    test.run(cases, 'isPowerOfThree')

