from TestUtil import Test


class Solution:
    """
    @param digits: a number represented as an array of digits
    @return: the result
    """

    def plusOne(self, digits):
        flag = 1
        for i in range(1, len(digits) + 1):
            digits[-i], flag = (0, 1) if digits[-i] + flag == 10 else (digits[-i] + flag, 0)
        if digits[0] == 0:
            digits = [1] + digits
        return digits


if __name__ == '__main__':
    test = Test(Solution())
    cases = [[1, 2, 3], [9, 9, 9]]
    test.run(cases, 'plusOne')
