import sys

loops = []
dependent = {}
startfile = ''

def scan_loop(curfile, path):
    # if curfile in path:
    if curfile == startfile and startfile in path:
        loops.append((path.index(curfile),path.copy()))
        return
    
    if curfile in dependent.keys():
        path.append(curfile)
        for f in dependent[curfile]:
            scan_loop(f, path)


for line in sys.stdin:
    if line.startswith('search '):
        startfile = line[17:-1]
        break
    dependency = line.split()
    relier, dependency[0] = dependency[0].split(':')
    # depedent[relier] = list(set(depedent[relier]+dependency))
    dependent[relier] = dependency

# scan_loop(startfile, [])

if startfile in dependent.keys():
    for f in dependent[startfile]:
        scan_loop(f, [startfile])

if len(loops) == 0:
    print("none loop include " + startfile)
else:
    print("Bad coding -- loop include as bellow:")
    for idx, loop in loops:
        print(' '.join(loop[idx:]))
