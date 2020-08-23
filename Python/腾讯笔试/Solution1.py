n, k = list(map(int, input().split()))
all_nodes = input().split(' ')
print(' '.join(all_nodes[:k-1]), end=' ')
print(' '.join(all_nodes[k:]))
