import sys

# key words
AND = 'AND'
OR = 'OR'
NOT = 'NOT'

def is_key_word(cmd):
    return cmd == AND or cmd == OR or cmd == NOT

def is_command(cmd):
    return not is_key_word(cmd) and cmd == cmd.lower()

def is_valid(cmds):
    valid = 1
    if len(cmds) == 1:
        valid = is_command(cmds[0])

    # elif cmds[0] == NOT or cmds[0] == AND:
    #     valid = 0

    else:
        l = len(cmds)
        pre_key = True # 前一个是关键字
        for i, cmd in enumerate(cmds):
            
            if pre_key:
                # 前一个是关键字的情况, 只能是命令
                if cmd == NOT:
                    # 预处理NOT
                    if i == l-1 or cmds[i+1] == NOT:
                        valid = 0
                        break
                    else:
                        continue
                pre_key = False
                if not is_command(cmd):
                    valid = 0
                    break

            else:
                # 前一个不是关键字的情况，只能是关键字
                pre_key = True
                if not is_key_word(cmd):
                    valid = 0
                    break
    return int(valid)

for line in sys.stdin:
    cmds = line.split()
    print(is_valid(cmds))
