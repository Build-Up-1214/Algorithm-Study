import sys
from collections import deque

input = sys.stdin.readline
N = int(input())
queue = deque()
a = 0

while True:
    a = int(input())
    if a == 0:
        queue.popleft()
    elif a == -1:
        break
    elif len(queue) < N:
        queue.append(a)

if len(queue) == 0:
    print("empty")
else:
    for _ in range(len(queue)):
        print(queue.popleft(), end = " ")