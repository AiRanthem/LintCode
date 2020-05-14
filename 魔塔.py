n,D = list(map(int,input().split()))
A = list(map(int,input().split()))
B = list(map(int,input().split()))
Guais = []
class guai:
    A = 0
    B = 0

    def __init__(self, a, b):
        self.A = a
        self.B = b
    
    def __lt__(self, value):
        return self.A < value.A

dmg = 0

for i, a in enumerate(A):
    Guais.append(guai(a, B[i]))

Guais.sort()

for g in Guais:
    if D < g.A:
        dmg += g.B
    D += 1
print(dmg)
