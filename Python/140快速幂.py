from TestUtil import Test


class Solution:
    def fastPower(self, a: int, b: int, n: int):
        """
        @param a A 32bit integer
        @param b A 32bit integer
        @param n A 32bit integer
        @return: An integer
        """
        ans = 1
        while n:
            if n & 0b1:
                ans = ans * a % b
            a = a * a % b
            n >>= 1
        return ans % b


if __name__ == '__main__':
    test = Test(Solution())
    cases = [(3, 7, 5)]
    test.run(cases, 'fastPower')
