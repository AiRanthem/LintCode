"""
如果在输入的字符串中，含有 类似于“d-h”或者“4-8”的字串，我们就把它当作一种简写，输出时，用连续递增的字母获数字串替代其中的减号，即，将上面两个子串分别输出为 “defgh”和“45678”。在本题中，我们通过增加一些参数的设置，使字符串的展开更为灵活。具体约定如下：

(1) 遇到下面的情况需要做字符串的展开：在输入的字符串中，出现了减号“-”，减号两侧同为小写字母或同为数字，且按照ASCII码的顺序，减号右边的字符严格大于左边的字符。

(2) 参数p1：展开方式。p1=1时，对于字母子串，填充小写字母；p1=2时，对于字母子串，填充大写字母。这两种情况下数字子串的填充方式相同。p1=3时，不论是字母子串还是数字字串，都用与要填充的字母个数相同的星号“*”来填充。

(3) 参数p2：填充字符的重复个数。p2=k表示同一个字符要连续填充k个。例如，当p2=3时，子串“d-h”应扩展为“deeefffgggh”。减号两边的字符不变。

(4) 参数p3：是否改为逆序：p3=1表示维持原来顺序，p3=2表示采用逆序输出，注意这时候仍然不包括减号两端的字符。例如当p1=1、p2=2、p3=2时，子串“d-h”应扩展为“dggffeeh”。

(5) 如果减号右边的字符恰好是左边字符的后继，只删除中间的减号，例如：“d-e”应输出为“de”，“3-4”应输出为“34”。如果减号右边的字符按照 ASCII码的顺序小于或等于左边字符，输出时，要保留中间的减号，例如：“d-d”应输出为“d-d”，“3-1”应输出为“3-1”。

数据规模和约定

100%的数据满足：1< =p1< =3，1< =p2< =8，1< =p3< =3。字符串长度不超过100

简化参数理解：
p1：1小写，2大写，3填*，数字不变
p2：每个填充字符重复次数
p3：1正序，2倒序
减号两侧字符不参与
"""


def should_extract(a: str, b: str):
    if a < b:
        if a.islower() and b.islower():
            return True
        if a.isdigit() and b.isdigit():
            return True
    return False


def extract(s: str) -> tuple:
    """
    解析字符串
    @param s: input string
    @return: list of tuple (position, string to fill)
    """
    for i in range(1, len(s) - 1):
        if s[i] == '-' and should_extract(s[i - 1], s[i + 1]):
            yield i, "".join([chr(c) for c in range(ord(s[i - 1]) + 1, ord(s[i + 1]))])


def stylize(s: str, style: int) -> str:
    """
    根据 p1 值给定的风格处理字符串
    @param style: style
    @param s: input string
    @return: stylized string
    """
    if (not s.isdigit()) and style == 2:
        return s.upper()
    if style == 3:
        return "".join(['*' for i in range(len(s))])
    else:
        return s


def repeat(s: str, repeat_time: int) -> str:
    """
    根据 p2 值重复字符串
    @param s: input string
    @param repeat_time: repeat time
    @return: repeated string
    """
    return "".join([c * repeat_time for c in s])


def reverse(s: str, order: int) -> str:
    """
    根据 p3 倒序
    @param s:
    @param order:
    @return: reversed string
    """
    if order == 2:
        return s[::-1]
    else:
        return s


p1, p2, p3 = list(map(int, input().split()))
string = input()
result = ""
cur = 0
for pos, processed in extract(string):
    processed = stylize(processed, p1)
    processed = repeat(processed, p2)
    processed = reverse(processed, p3)
    result += string[cur:pos] + processed
    cur = pos + 1
result += string[cur:]
print(result)
