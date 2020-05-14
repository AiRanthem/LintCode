class Solution:
    """
    @param color: the given color
    @return: a 7 character color that is most similar to the given color
    """
    def similarRGB(self, color):
        # Write your code here
        def getClosest(s):
            return min(
                ['00', '11', '22', '33', '44', '55', '66', '77', '88', '99', 'aa', 'bb', 'cc', 'dd', 'ee', 'ff'],
                key=lambda x: abs(int(x, 16) - int(s, 16))
            )

        rgb = [getClosest(color[i:i+2]) for i in [1, 3, 5]]
        return '#'+''.join(rgb)

if __name__ == '__main__':
    c = "#09f166"
    solution = Solution()
    print(solution.similarRGB(c))
