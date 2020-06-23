n = int(input())
shebaos = []
for i in range(n):
    shebaos.append(input())

times = {}
for shebao in shebaos:
    if shebao in times.keys():
        times[shebao] += 1
    else:
        times[shebao] = 1

shebaos2 = list(times.keys())
shebaos2.sort()

for shebao in shebaos2:
    print(shebao, times[shebao])