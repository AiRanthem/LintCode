class Solution:
    def findPeak(self, A: list):
        """
        @param A: An integers array.
        @return: return any of peek positions.
        """
        return self.helper(A, 0, len(A) - 1)

    def helper(self, A: list, left: int, right: int):
        mid = (left + right) // 2
        if A[mid] > A[mid - 1] and A[mid] > A[mid + 1]:
            return mid
        if A[mid] < A[mid + 1]:
            return self.helper(A, mid, right)
        else:
            return self.helper(A, left, mid)


from TestUtil import Test

if __name__ == '__main__':
    test = Test(Solution())
    cases = [[1, 2, 1, 3, 4, 5, 7, 6], [1, 2, 3, 4, 1]]
    test.run(cases, 'findPeak')
