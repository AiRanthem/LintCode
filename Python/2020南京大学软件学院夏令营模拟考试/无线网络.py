n, m, k, r = list(map(int, input().split()))
# 现有n个路由器
# 还有m个路由器
# 可放k个路由器
# 连接距离r
pos = []
for _ in range(n):
    pos.append(list(map(int, input().split())))

putable = []
for _ in range(m):
    putable.append(list(map(int, input().split())))


# build a graph
def link(a: list, b: list) -> bool:
    return (a[0] - b[0]) ** 2 + (a[1] - b[1]) ** 2 <= r ** 2


A = [[100000 for _ in range(n)] for _ in range(n)]
for i in range(n - 1):
    for j in range(i + 1, n):
        if link(pos[i], pos[j]):
            A[i][j] = 1
            A[j][i] = 1

# Dijkstra
dis = []
for i in A[0]:
    dis.append(i)
dis[0] = 0

selected = [0 for _ in range(n)]
selected[0] = 1

while sum(selected) < n:
    m_val = 100000
    m_pos = -1
    # find min
    for i in range(n):
        if not selected[i] and dis[i] < m_val:
            m_pos = i
            m_val = dis[i]
    selected[m_pos] = 1
    # update
    for i in range(n):
        new_dist = m_val + A[m_pos][i]
        if not selected[i] and dis[i] > new_dist:
            dis[i] = new_dist

# 当前1到2的距离
dist = dis[1]

'''
5 3 1 3
0 0
5 5
0 3
0 5
3 5
3 3
4 4
3 0
'''
