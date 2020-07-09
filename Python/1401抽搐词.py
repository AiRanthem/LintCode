class Solution:
    def twitchWords(self, string: str):
        """
        @param string: the origin string
        @return: the start and end of every twitch words
        """
        if len(string) < 3:
            return []
        result = []
        start, end = 0, 0
        cur = string[0]
        for i in range(1, len(string)):
            if string[i] != cur:
                cur = string[i]
                end = i - 1
                if end - start >= 2:
                    result.append([start, end])
                start = i
        if len(string) - 1 - start >= 2:
            result.append([start, len(string) - 1])
        return result

from TestUtil import Test
if __name__ == '__main__':
    test = Test(Solution())
    cases = ["whaaaaatttsup","whooooisssbesssst"]
    test.run(cases, 'twitchWords')

