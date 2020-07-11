N, K, M = list(map(int, input().split()))
# N: 人数，K：题目数，M：提交数
scores = list(map(int, input().split()))

students = {}
for _ in range(M):
    info = input().split()
    name, question, score = info[0], int(info[1]) - 1, int(info[2])
    if name not in students.keys():
        if score != -1:
            students[name] = [-1 for _ in range(K)]
        else:
            continue
    score = max(0, score)
    if 0 <= score <= scores[question]:
        if score > students[name][question]:
            students[name][question] = score


def sum_scores(scores: list) -> int:
    res = 0
    for s in scores:
        if s > 0:
            res += s
    return res

results = []
for name in students.keys():
    results.append([name, sum_scores(students[name])])
results.sort(key=lambda x: x[1])

for name, score in reversed(results):
    print(name, score, end=' ')
    prt = []
    for i in students[name]:
        if i != -1:
            prt.append(str(i))
        else:
            prt.append('-')
    print(' '.join(prt))

'''
7 4 9
25 25 25 25
00002 2 12
00007 4 17
00002 2 25
00005 3 22
00006 4 -1
00001 3 4
00001 4 2
00005 2 -1
00004 2 0
'''
