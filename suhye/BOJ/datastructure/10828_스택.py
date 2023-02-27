import sys

n = int(sys.stdin.readline())
commands = [sys.stdin.readline().strip() for _ in range(n)]
stack = []

for c in commands:
    if 'push' in c:
        stack.append(c[5:])
    elif c == 'pop':
        if len(stack) == 0:
            print(-1)
        else:
            print(stack.pop())
    elif c == 'size':
        print(len(stack))
    elif c == 'empty':
        if len(stack) == 0:
            print(1)
        else:
            print(0)
    else:
        if len(stack) == 0:
            print(-1)
        else:
            print(stack[-1])