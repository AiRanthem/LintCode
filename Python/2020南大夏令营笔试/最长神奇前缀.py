s = input()
temp = ""
for i in range(len(s) // 2):
    pre = s[0:i + 1]
    suf = s[-i - 1:]
    if pre == suf:
        temp = pre
print(temp)
