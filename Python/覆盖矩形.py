n = int(input())
x1 = []
x2 = []
y1 = []
y2 = []
for i in range(n):
    a,b,c,d = list(map(int,input().split()))
    x1.append(a)
    y1.append(b)
    x2.append(c)
    y2.append(d)
mx1 = min(x1)
mx2 = max(x2)
my1 = min(y1)
my2 = max(y2)

print((my2-my1)*(mx2-mx1))