from Python.TestUtil import Test

"""
Definition of Interval.
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""


class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end


class Solution:
    """
    @param intervals: interval list.
    @return: A new interval list.
    """

    def merge(self, intervals: list):
        intervals.sort(key=lambda x: x.start)
        res = []
        for interval in intervals:
            if not res or res[-1].end < interval.start:
                res.append(interval)
            else:
                res[-1].end = max(interval.end, res[-1].end)
        return res


if __name__ == '__main__':
    test = Test(Solution())
    # inls = [(1, 3), (2, 6), (15, 18), (8, 10)]
    inls = [(1, 3)]
    for i in inls:
        cases = [[Interval(i[0], i[1]) for i in inls]]
    test.run(cases, 'merge')
