class Solution:

    def __init__(self):
        self.results = []
        self.n = 0

    def generateParenthesis(self, n):
        """
        @param n: n pairs
        @return: All combinations of well-formed parentheses
        """
        self.results = []
        self.n = n
        self.helper(0, 0, "")
        return self.results

    def helper(self, left: int, right: int, result: str):
        if left + right == 2 * self.n:
            self.results.append(result)
        if left < self.n:
            self.helper(left + 1, right, result + "(")
        if left > right:
            self.helper(left, right + 1, result + ")")


from TestUtil import Test

if __name__ == '__main__':
    test = Test(Solution())
    cases = [3]
    test.run(cases, 'generateParenthesis')
