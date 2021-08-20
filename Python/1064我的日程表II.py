"""
实现MyCalendarTwo类来存储您的事件。 如果添加活动不会导致三重预订，则可以添加新活动。
你的类将有一个方法，book(int start, int end)。 这代表左闭右开的间隔[start, end)有一个预订，范围内的实数x，都满足start <= x < end。
当三个事件具有一些非空交集时（即，有一个时间同时有三个预定），会发生三重预订。
每次调用MyCalendar.book时，如果没有三重预定，则事件可以成功添加到日历，且返回true。 否则，返回false，并且事件不会添加到日历中。
你的类以此方式被调用：MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end);

解法：
扫描线：将所有注册的检查点按照时间顺序排列。如果一个检查点上start，则值+1，反之-1。检查时，扫描整个序列进行求和即可。
"""
from bisect import insort


class MyCalendarTwo:

    def __init__(self) -> None:
        self.checkpoints = []
        self.record = {}

    def book(self, start, end):
        """
        @param start: start tme
        @param end: end time
        """
        for checkpoint in start, end:
            if checkpoint not in self.checkpoints:
                insort(self.checkpoints, checkpoint)
                self.record[checkpoint] = 0
        self.record[start] += 1
        self.record[end] -= 1

        cnt = 0
        for checkpoint in self.checkpoints:
            cnt += self.record[checkpoint]
            if cnt >= 3:
                self.record[start] -= 1
                self.record[end] += 1
                return False
        return True


def test(param):
    global calendar
    print(calendar.book(param[0], param[1]))
    cps = ""
    rcs = ""
    for checkpoint in calendar.checkpoints:
        cps += "{:5d}".format(checkpoint)
        rcs += "{:5d}".format(calendar.record[checkpoint])
    print(cps)
    print(rcs)


if __name__ == '__main__':
    calendar = MyCalendarTwo()
    print(calendar.book(10, 20))
    print(calendar.book(50, 60))
    print(calendar.book(10, 40))
    print(calendar.book(5, 15))  # false
    print(calendar.book(5, 10))
    print(calendar.book(25, 55))
    # error_test("test_cases/1064_1.in", test, int, [[38, 39]])
