s = input()
k = int(input())
substrs = set()
top = 'z'
for i in range(len(s)):
    if s[i] > top:
        continue
    for j in range(i, len(s)):
        if len(substrs) >= k:
            top = min(top, s[i])
            break
        substrs.add(s[i:j + 1])

print(sorted(list(substrs))[k - 1])
