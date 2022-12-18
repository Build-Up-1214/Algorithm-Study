# 덱 340ms

from collections import deque

n = int(input())
deque = deque()

for i in range(1, n+1):
    deque.append(i)

while len(deque) >= 2:
    deque.popleft()
    deque.append(deque.popleft())

print(deque[0])


'''
다른 풀이 (64ms)

import sys

n = int(sys.stdin.readline().strip())
now = 1
while now < n:
    now *= 2
if now == n:
    print(now)
else:
    print(n*2-now)
'''
