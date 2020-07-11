def extract_first(line: str, split=' ', right=False):
    if right:
        space = line.rfind(split)
    else:
        space = line.find(split)
    if space == -1:
        return line, ''
    fore = line[:space].strip()
    back = line[space + 1:].strip()
    return fore, back


def extract_loop(line: str):
    time, back = extract_first(line, '[')
    time = int(time)
    loop, back = extract_first(back, ']', right=True)

    return time, loop, back


def interpret(line: str):
    if not line:
        return 0
    cmd, back = extract_first(line.strip())
    if cmd == "REPEAT":
        time, loop, back = extract_loop(back)
        return time * interpret(loop) + interpret(back)
    else:
        flag = 1 if cmd == "FD" else -1
        step, back = extract_first(back)
        return int(step) * flag + interpret(back)


cmd = input()

print(interpret(cmd))
