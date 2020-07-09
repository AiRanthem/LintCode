class Solution:
    def myPow(self, x: float, n: int):
        """
        @param x: the base number
        @param n: the power number
        @return {float}: the result
        """
        negative = False
        if n < 0:
            n = -n
            negative = True
        result = 1
        while n:
            if n & 0b1:
                result *= x
            x *= x
            n >>= 1
        return 1 / result if negative else result


from TestUtil import Test
if __name__ == '__main__':
    test = Test(Solution())
    cases = [(9.88023, 3), (2.1, 3), (1, 0)]
    test.run(cases, 'myPow')

