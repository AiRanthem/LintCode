n, m = list(map(int, input().split()))
grid = []
for i in range(n):
    grid.append(list(map(int, input().split())))

res = [[grid[i][j] for j in range(m)] for i in range(n)]

# iter row
for i in range(n):
    start = 0
    end = 0
    cur = grid[i][0]
    for j in range(m):
        if j == m-1 or grid[i][j+1] != cur:
            end = j
            if end - start >= 2:
                for k in range(start, end+1):
                    res[i][k] = 0
            start = end + 1

# iter col
for j in range(m):
    start = 0
    end = 0
    cur = grid[0][j]
    for i in range(n):
        if i == n-1 or grid[i+1][j] != cur:
            end = i
            if end - start >= 2:
                for k in range(start, end+1):
                    res[k][j] = 0
            start = end + 1

print(res)
'''
4 5
2 2 3 1 2
3 4 5 1 4
2 3 2 1 3
2 2 2 4 4
'''
