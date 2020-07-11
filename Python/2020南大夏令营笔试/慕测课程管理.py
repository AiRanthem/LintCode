N, K = list(map(int, input().split()))
courses = {i + 1: [] for i in range(K)}
for _ in range(N):
    info = input().split()
    name = info[0]
    if int(info[1]) > 0:
        joined = list(map(int, info[2:]))
        for course in joined:
            if name not in courses[course]:
                courses[course].append(name)

# to list
info = []
for course, ls in courses.items():
    info.append([course, len(ls)])
info.sort(key=lambda x: -x[1])
for name, num in info:
    print(name, num)
    for student in sorted(courses[name]):
        print(student)
'''
3 3
ZZY1 2 1 2
ZYY0 1 1
BBQ5 2 1 2
'''
