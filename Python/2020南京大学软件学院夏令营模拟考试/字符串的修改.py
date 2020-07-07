"""
依旧是字符串处理，设A和B是两个字符串。我们要用最少的字符操作次数，将字符串A转换为字符串B。这里所说的字符操作共有三种：

删除一个字符；
插入一个字符；
将一个字符改为另一个字符。 对任给的两个字符串A和B，计算出将字符串A变换为字符串B所用的最少字符操作次数。
"""

a: str = input()
b: str = input()

dp = [[0 for j in range(len(b) + 1)] for i in range(len(a) + 1)]
for i in range(len(a) + 1):
    dp[i][0] = i
for j in range(len(b) + 1):
    dp[0][j] = j

for j in range(1, len(b) + 1):
    for i in range(1, len(a) + 1):
        if a[i - 1] == b[j - 1]:
            dp[i][j] = dp[i - 1][j - 1]
        else:
            dp[i][j] = 1 + min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1])

print(dp[len(a)][len(b)])
