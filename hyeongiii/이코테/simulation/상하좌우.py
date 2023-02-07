import sys
input = sys.stdin.readline

n = int(input())
command = list(input().split())

r, c = 1, 1

for i in command:
    if i == 'L':
        c -= 1
    elif i == 'R':
        c += 1
    elif i == 'U':
        r -= 1
    elif i == 'D':
        r += 1

    if c < 1:
        c = 1
    if c > n:
        c = n
    if r < 1:
        r = 1
    if r > n:
        r = n

print(r, c)