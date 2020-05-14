'''
小Q得到一个神奇的数列: 1, 12, 123,...12345678910,1234567891011...。
并且小Q对于能否被3整除这个性质很感兴趣。
小Q现在希望你能帮他计算一下从数列的第l个到第r个(包含端点)有多少个数可以被3整除。
'''
l, r = list(map(int, input().split()))
# mod = 0
# for i in range(l):
#     mod = (mod + i+1) % 3
mod = 0
result = 0 if mod else 1
print('start done')

l = l+1
while(l <= r):
    mod = (mod + l) % 3
    result = result if mod else result + 1
    l = l+1
print(result)
