import re
from sys import stdin

# lines = [line.strip() for line in stdin.readlines()]
lines = ['a*', 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab', 'a*a+', 'aaaaaaaaaaaaaaaaaaaaaaaaaaa']
n = len(lines) // 2
for i in range(n):
    pattern = lines[2*i]
    string = lines[2*i+1]
    print("Yes" if re.search(pattern, string) else "No")

# try:
#     pattern = stdin.readline()
#     string = stdin.readline()
#     print("Yes" if re.search(pattern, string) else "No")
# except:
#     pass
