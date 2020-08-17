class Solution:
    """
    @param: s: A string
    @return: A string
    """
    def reverseWords(self, s:str):
        words = s.split()
        stack = []
        for word in words:
             stack.append(word)
        return ' '.join(reversed(stack))
