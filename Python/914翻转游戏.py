from Python.TestUtil import Test


class Solution:
    """
    @param s: the given string
    @return: all the possible states of the string after one valid move
    """
    def generatePossibleNextMoves(self, s):
        ret = []
        for i, _ in enumerate(s[:-1]):
            if s[i] == '+' and s[i+1] == '+':
                ret.append(s[:i]+'--'+s[i+2:])
        return ret


if __name__ == '__main__':
    test = Test(Solution())
    cases = ["---+++-+++-+", "++++"]
    test.run(cases, 'generatePossibleNextMoves')
