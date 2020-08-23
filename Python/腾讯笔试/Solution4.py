n = int(input())
pads = list(map(int, input().split()))
# init height
height = max(pads)
highest = pads.index(height)
# init width
button = {}
tw = 0 # temp width
cur = 0 # current start
for i, h in enumerate(pads):
    if h == 0:
        tw = 0
    else:
        if tw == 0:
            tw += 1
            button[i] = tw
            cur = i
        else:
            tw += 1
            button[cur] += 1

cnt = 0
while height != 0:
    width = max(button.values())
    #if height > width:




