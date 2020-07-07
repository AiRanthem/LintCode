"""
Pear有一个字符串，不过他希望把它切成两段。 这是一个长度为N（<=10^5）的字符串。 Pear希望选择一个位置，把字符串不重复不遗漏地切成两段，长度分别是t和N-t（这两段都必须非空）。

Pear用如下方式评估切割的方案： 定义“正回文子串”为：长度为奇数的回文子串。 设切成的两段字符串中，前一段中有A个不相同的正回文子串，后一段中有B个不相同的非正回文子串，则该方案的得分为A*B。

注意，后一段中的B表示的是：“...非正回文...”，而不是: “...正回文...”。 那么所有的切割方案中，A*B的最大值是多少呢？
"""
n = int(input())
s = input()


def isPositive(string: str) -> bool:
    return len(string) % 2 and string == string[::-1]


def genSide(string: str, left: bool) -> list:
    """
    生成一侧的数字，放在arr中。arr[i]为分割点为i时满足的
    @param left: 方向，1为左侧，0为右侧
    @param string: 要分割的字符串
    @return: 列表arr，arr[i]为从左或右端起，到 第i个 字符所满足条件的字串个数（左为
    """
    arr = []
    substr_set = set()
    if not left:
        string = string[::-1]
    for i in range(len(string)):
        j = i
        while j >= 0:
            test = string[j:i + 1]
            if isPositive(test) == left:
                substr_set.add(test)
            j = j - 1 - left
        arr.append(len(substr_set))
    return arr if left else arr[::-1]


A = genSide(s, True)
B = genSide(s, False)
print(max([A[i] * B[i + 1] for i in range(len(A) - 1)]))
