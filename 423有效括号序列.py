from TestUtil import Test


class Solution:
    """
    @param s: A string
    @return: whether the string is a valid parentheses
    """

    def isValidParentheses(self, s):
        def pair(a, b):
            if a == '(':
                return b == ')'
            if a == '[':
                return b == ']'
            if a == '{':
                return b == '}'

        stack = []
        for c in s:
            if c in ('(', '[', '{'):
                stack.append(c)
            else:
                if not stack or not pair(stack.pop(), c):
                    return False
        return len(stack) == 0


if __name__ == '__main__':
    test = Test(Solution())
    cases = ['()[]{}', '[{]}()', '{[()]}', '((']
    test.run(cases, 'isValidParentheses')
