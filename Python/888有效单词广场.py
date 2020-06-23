from Python.TestUtil import Test


class Solution:
    """
    @param words: a list of string
    @return: a boolean
    """

    def validWordSquare(self, words):
        nx = len(words)
        ny = len(words[0])
        if nx != ny:
            return False
        for i in range(nx):
            for j in range(ny):
                if i >= ny or j >= nx or words[i][j] != words[j][i]:
                    return False
        return True


if __name__ == '__main__':
    test = Test(Solution())
    cases = [[
        "abcd",
        "bnrt",
        "crmy",
        "dtye"
    ], [
        "abcd",
        "bnrt",
        "crm",
        "dt"
    ], [
        "ball",
        "area",
        "read",
        "lady"
    ]]
    test.run(cases, 'validWordSquare')
