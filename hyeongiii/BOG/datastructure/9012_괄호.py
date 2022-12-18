# 스택

import sys

n = int(sys.stdin.readline().rstrip())

for _ in range(n):
    data = sys.stdin.readline().rstrip()
    stack = []

    for i in data:
        if i == '(':
            stack.append(i)
        elif i == ')':
            if stack:
                stack.pop()
            else:
                stack.append(i)
                break

    print('NO' if stack else 'YES')
