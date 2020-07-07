n, k = list(map(int, input().split()))
cnt = 0
if k == 0:
    cnt = n * n
else:
    for y in range(k+1, n+1):
        base = (n//y)*(y-k)
        offset = n % y-k+1 if n % y >= k else 0
        cnt += base+offset
print(cnt)
