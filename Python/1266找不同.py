class Solution:
    def findTheDifference(self, s: str, t: str):
        """
        @param s: a string
        @param t: a string
        @return: the letter that was added in t
        """
        counter = {chr(c): 0 for c in range(ord('a'), ord('z') + 1)}
        for c in t:
            counter[c] += 1
        for c in s:
            counter[c] -= 1
        for c, v in counter.items():
            if v != 0:
                return c


from TestUtil import Test

if __name__ == '__main__':
    test = Test(Solution())
    cases = [("abcd", "abcde")]
    test.run(cases, 'findTheDifference')
