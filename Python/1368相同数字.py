class Solution:
    def sameNumber(self, nums: list, k: int):
        """
        @param nums: the arrays
        @param k: the distance of the same number
        @return: the ans of this question
        """
        table = {}
        for i in range(len(nums)):
            n = nums[i]
            if n not in table.keys():
                table[n] = i
            else:
                if i - table[n] < k:
                    return "YES"
                else:
                    table[n] = i
        return "NO"


from TestUtil import Test

if __name__ == '__main__':
    test = Test(Solution())
    cases = [([1,2,3,4,5,6,7,7], 7)]
    test.run(cases, 'sameNumber')
