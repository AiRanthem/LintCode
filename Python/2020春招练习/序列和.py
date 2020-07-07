from math import floor


def algorithm(N, L):
    while True:
        s = ((2*N/L) + 1 - L) / 2
        if L > 100:
            return 'No'
        if s - floor(s) == 0:
            s = int(s)
            break
        L = L + 1
    ret = [str(i) for i in range(s,s+L)]
    return ' '.join(ret)

N, L = input().split()
N, L = int(N), int(L)
print(algorithm(N, L))